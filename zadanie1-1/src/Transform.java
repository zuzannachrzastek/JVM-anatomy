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
