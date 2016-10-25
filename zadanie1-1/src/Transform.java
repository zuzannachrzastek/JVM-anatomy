/**
 * Created by Zuzanna on 14.10.2016.
 */

import org.apache.bcel.Constants;
import org.apache.bcel.Repository;
import org.apache.bcel.classfile.*;
import org.apache.bcel.generic.*;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;

public class Transform {

    private static Transform transform = new Transform();

    public static void main(String[] args) throws TargetLostException {

        String className = (args.length >= 1) ? args[0] : "";
        JavaClass clazz = null;

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

        InstructionList il = new InstructionList();
        il.append(new GETSTATIC(cpg.addFieldref("java.lang.System", "out", "Ljava/io/PrintStrem;")));
        il.append(new PUSH(cpg, "Method to be called: "));
        il.append(new INVOKEVIRTUAL(cpg.addMethodref("java.io.PrintStrem", "println", "(Ljava/lang/String;)V")));
        il.append(new RETURN());

//        InstructionHandle[] ihs = il.getInstructionHandles();
//        il.delete(ihs[0], ihs[ihs.length]);

        InstructionFactory factory = new InstructionFactory(modClass, cpg);

        /*
         * PARAMETERS NEEDED:
         * method name, arguments' types, return value type
         * e.g. Method to be called: someMethod(Ljava/lang/String;)Ljava/lang/String;
         */

        for(Method m : methods){
            MethodGen mg = new MethodGen(m, m.getName(), cpg);
            System.out.println("\nMethod's name: " + m.getName().toString());
            System.out.println("Type of method: " + m.getReturnType().toString());
            System.out.println("Arguments' types:");

            InstructionList mgInsList = mg.getInstructionList();
            InstructionHandle[] mgInsHandles = mgInsList.getInstructionHandles();

            for(Iterator i = mgInsList.iterator(); i.hasNext(); ){
                InstructionHandle handle = (InstructionHandle) i.next();
                if(handle.getInstruction() instanceof InvokeInstruction){
                    InvokeInstruction invokeInstruction = (InvokeInstruction) handle.getInstruction();
                    String calledClass = invokeInstruction.getClassName(modClass.getConstantPool());
                    String calledMethodName = invokeInstruction.getName(modClass.getConstantPool());
                    String calledMethodSignature = invokeInstruction.getSignature(modClass.getConstantPool());
                    boolean isStaticMethod = invokeInstruction.getOpcode() == Constants.INVOKESTATIC;

                    System.out.println("Called call: " + calledClass);
                    System.out.println("Called method name: " + calledMethodName);
                    System.out.println("Called method signature: " + calledMethodSignature);
                }


//                if(ih.getInstruction() instanceof INVOKESTATIC){
//                    INVOKESTATIC newInst = ((INVOKESTATIC)ih.getInstruction());
//                    String name = cp.getConstantString(((ConstantMethodref)cp.getConstant(newInst.getIndex())).getClassIndex(), Constants.CONSTANT_Class);
//                    System.out.println("Static call: " + name);
//                }
            }
        }

//        for(Method m : methods){
//            MethodGen mg = new MethodGen(m, m.getName(), cpg);
//            if(m.getReturnType().toString() != "void"){
//                System.out.println("\nMethod's name: " + m.getName().toString());
//                System.out.println("Type of method: " + m.getReturnType().toString());
//                System.out.println("Arguments' types:");
//
//                Type[] types = m.getArgumentTypes();
//                if(types.length > 0) {
//                    for(int i = 0; i < types.length; i++){
//                        System.out.println(types[i].toString());
//                    }
//                } else {
//                    System.out.println("no arguments");
//                }
//                Instruction fieldInstruction = null;
//
//                InstructionList mgInsList = mg.getInstructionList();
//                InstructionHandle[] mgInsHandles = mgInsList.getInstructionHandles();
//                InstructionHandle ih = mgInsList.getStart();
//
//                for(int f = 0; f < mgInsHandles.length; f++){
//
//                    System.out.println("ins. " + f + ": " + mgInsHandles[f].getInstruction().toString());
//
//                    if(mgInsHandles[f].getInstruction() instanceof INVOKESTATIC){
//                        INVOKESTATIC newInst = ((INVOKESTATIC)mgInsHandles[f].getInstruction());
//                        name = cp.getConstantString(((ConstantMethodref)cp.getConstant(newInst.getIndex())).getClassIndex(), Constants.CONSTANT_Class);
//                        System.out.println("Static call: " + name);
////                        fieldInstruction = mgInsHandles[f].getInstruction();
////                        instructionList.insert(fieldInstruction, callStatement);
////                        System.out.println("Found the invoke " + fieldInstruction.toString());
//                    }
//                }
//            }
//        }

//        modClass.update();
    }
}
