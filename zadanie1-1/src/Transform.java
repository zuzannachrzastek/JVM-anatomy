/**
 * Created by Zuzanna on 14.10.2016.
 */

import org.apache.bcel.Repository;
import org.apache.bcel.classfile.*;
import org.apache.bcel.generic.*;

import java.io.IOException;

public class Transform {

//    private static Transform transform = new Transform();

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
        ConstantPool cp = clazz.getConstantPool();
        ConstantPoolGen cpg = new ConstantPoolGen(cp);
        Method[] methods = clazz.getMethods();

        InstructionFactory factory = new InstructionFactory(modClass);

        for(Method m : methods){
            MethodGen mg = new MethodGen(m, m.getName(), cpg);
            System.out.println("\nMethod's name: " + m.getName().toString());
            System.out.println("Type of method: " + m.getReturnType().toString());

            InstructionList mgInsList = mg.getInstructionList();
            InstructionHandle[] mgInsHandles = mgInsList.getInstructionHandles();

//            for(Iterator i = mgInsList.iterator(); i.hasNext(); ){
            for(InstructionHandle handle : mgInsHandles){
//                InstructionHandle handle = (InstructionHandle) i.next();
                if(handle.getInstruction() instanceof InvokeInstruction){
                    InvokeInstruction invokeInstruction = (InvokeInstruction) handle.getInstruction();
                    String calledMethodName = invokeInstruction.getMethodName(modClass.getConstantPool());
                    String calledMethodSignature = invokeInstruction.getSignature(modClass.getConstantPool());

                    mesg = "Method to be called: " + calledMethodName + calledMethodSignature;

                    mgInsList.insert(handle, factory.createPrintln(mesg));

//                    for(Method m1 : methods){
//                        if(calledMethodName == m1.getName().toString() && m1.getReturnType() != Type.VOID){
//                            System.out.println("Called method name: " + m1.getName().toString());
//                            System.out.println("Called method signature: " + m1.getSignature().toString());
//
//
//                            InstructionList il = new InstructionList();
//                            il.append(new GETSTATIC(cpg.addFieldref("java.lang.System", "out", "Ljava/io/PrintStrem;")));
//                            il.append(new PUSH(cpg, mesg));
//                            il.append(new INVOKEVIRTUAL(cpg.addMethodref("java.io.PrintStrem", "println", "(Ljava/lang/String;)V")));
//
//                            System.out.println("il: " + il.toString());
//                            System.out.println("handle: " + handle);
//
//                            mgInsList.insert(il);
//                            mgInsList.update();
//                            mg.update();
//                            break;
//                        }
//                    }
                }
            }

            mg.setMaxStack();
            modClass.replaceMethod(m, mg.getMethod());
        }
//        modClass.update();
//        clazz.setConstantPool(cpg.getFinalConstantPool());
        
        String classFilePath = Repository.lookupClassFile(modClass.getClassName()).getPath();
        try {
            modClass.getJavaClass().dump(classFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
