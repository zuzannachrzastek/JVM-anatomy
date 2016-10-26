/**
 * Created by Zuzanna on 14.10.2016.
 */

import org.apache.bcel.Constants;
import org.apache.bcel.Repository;
import org.apache.bcel.classfile.*;
import org.apache.bcel.generic.*;

import java.io.IOException;
import java.io.PrintStream;

public class Transform {

    public static void main(String[] args) throws TargetLostException {

        String className = (args.length >= 1) ? args[0] : "";
        JavaClass clazz = null;
        String mesg;

        try {
            clazz = Repository.lookupClass(className);
            System.out.println("I found that class");
        } catch (Exception e) {
            System.err.println("Could not get class " + className);
        }

        ClassGen modClass = new ClassGen(clazz);
        ConstantPoolGen cpg = modClass.getConstantPool();
        Method[] methods = clazz.getMethods();

        for(Method m : methods){

            MethodGen mg = new MethodGen(m, m.getName(), cpg);
            System.out.println("\nMethod's name: " + m.getName().toString());
            System.out.println("Return type: " + m.getReturnType().toString());

            InstructionFactory factory = new InstructionFactory(modClass);
            InstructionList mgInsList = mg.getInstructionList();
            InstructionHandle[] mgInsHandles = mgInsList.getInstructionHandles();

            for(InstructionHandle handle : mgInsHandles){

                if(handle.getInstruction() instanceof InvokeInstruction){
                    InvokeInstruction invokeInstruction = (InvokeInstruction) handle.getInstruction();
                    String calledMethodName = invokeInstruction.getMethodName(cpg);
                    String calledMethodSignature = invokeInstruction.getSignature(cpg);

                    mesg = "Method to be called: " + calledMethodName + calledMethodSignature;

                    mgInsList.insert(handle, factory.createPrintln(mesg));

                    if(!(invokeInstruction instanceof INVOKESPECIAL)){
                        Type returnType = invokeInstruction.getReturnType(cpg);
                        InstructionList returnInsList = new InstructionList();

                        if(returnType == Type.VOID) {
                            returnInsList.append(factory.createPrintln("Got result: "));
                        } else {
                            returnInsList.append(factory.createFieldAccess(
                                    System.class.getCanonicalName(),
                                    "out",
                                    new ObjectType(PrintStream.class.getCanonicalName()),
                                    Constants.GETSTATIC
                            ));
                            returnInsList.append(factory.createConstant("Got result: "));
                            returnInsList.append(factory.createInvoke(
                                    PrintStream.class.getCanonicalName(),
                                    "print",
                                    Type.VOID,
                                    new Type[]{new ObjectType("java.lang.String")},
                                    Constants.INVOKEVIRTUAL
                            ));
                            returnInsList.append(InstructionFactory.createDup(returnType.getSize()));
                            returnInsList.append(factory.createFieldAccess(
                                    System.class.getCanonicalName(),
                                    "out",
                                    new ObjectType(PrintStream.class.getCanonicalName()),
                                    Constants.GETSTATIC
                            ));

                            if(returnType.equals(Type.DOUBLE) || returnType.equals(Type.LONG)){
                                returnInsList.append(InstructionFactory.DUP_X2);
                                returnInsList.append(InstructionFactory.POP);
                            } else {
                                returnInsList.append(InstructionFactory.SWAP);
                            }

                            InvokeInstruction callInvoke = factory.createInvoke(
                                    PrintStream.class.getCanonicalName(),
                                    "println",
                                    Type.VOID,
                                    new Type[]{new ObjectType("java.lang.Object")},
                                    Constants.INVOKEVIRTUAL
                            );
                            returnInsList.append(callInvoke);
                        }
                        mgInsList.append(handle, returnInsList);
                    }
                }
            }
            mg.setMaxStack();
            modClass.replaceMethod(m, mg.getMethod());
        }

        String classFilePath = Repository.lookupClassFile(modClass.getClassName()).getPath();
        try {
            modClass.getJavaClass().dump(classFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
