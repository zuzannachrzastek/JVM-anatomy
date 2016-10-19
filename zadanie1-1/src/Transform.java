/**
 * Created by Zuzanna on 14.10.2016.
 */

import org.apache.bcel.Constants;
import org.apache.bcel.Repository;
import org.apache.bcel.classfile.*;
import org.apache.bcel.generic.*;

import java.io.IOException;

public class Transform {

    public static void main(String[] args) {

        String className = (args.length >= 1) ? args[0] : "";
        JavaClass clazz = null;

        try {
            clazz = Repository.lookupClass(className);
            System.out.println("I found that class");
        } catch (Exception e) {
            System.err.println("Could not get class " + className);
        }

        ClassGen modClass = new ClassGen(clazz);
        ConstantPoolGen cp = modClass.getConstantPool();

        InstructionList il = new InstructionList();

        il.append(new GETSTATIC(cp.addFieldref("java.lang.System", "out", "Ljava/io/PrintStrem;")));
        il.append(new PUSH(cp, "Is it working??"));
        il.append(new INVOKEVIRTUAL(cp.addMethodref("java.io.PrintStrem", "println", "(Ljava/lang/String;)V")));
        il.append(new RETURN());

        MethodGen methodGen = new MethodGen(
                Constants.ACC_PUBLIC | Constants.ACC_STATIC,
                Type.VOID,
                new Type[]{new ArrayType(Type.STRING, 1)},
                null,
                "communicate",
                className,
                il,
                cp);

        methodGen.setMaxLocals();
        methodGen.setMaxStack();

        modClass.addMethod(methodGen.getMethod());
        modClass.update();

        try {
            JavaClass newClass = modClass.getJavaClass();
            String className2 = className.replace(".", "/");
            newClass.dump(className2 + ".class");
            System.out.println("Class " + className + " modified");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Method m : clazz.getMethods()){
            if(m.getReturnType().toString() != "void"){
                System.out.println("Type of method: " + m.getReturnType().toString());
                MethodGen mg = new MethodGen(m, clazz.getClassName(), cp);
                InstructionList instructionList  = mg.getInstructionList();
                InstructionHandle[] ihs = instructionList.getInstructionHandles();
                Instruction fieldInstruction = null;

                for(int f = 0; f < ihs.length; f++){
                    if(ihs[f].getInstruction() instanceof INVOKESTATIC
                            || ihs[f].getInstruction() instanceof  LDC
                            || ihs[f].getInstruction() instanceof INVOKEVIRTUAL){
                        fieldInstruction = ihs[f].getInstruction();
                        System.out.println("Found the invoke " + fieldInstruction.toString());
                    }
                }
            }
        }

    }
}
