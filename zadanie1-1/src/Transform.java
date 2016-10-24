/**
 * Created by Zuzanna on 14.10.2016.
 */

import org.apache.bcel.Constants;
import org.apache.bcel.Repository;
import org.apache.bcel.classfile.*;
import org.apache.bcel.generic.*;

public class Transform {

    private static Transform transform = new Transform();

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
        InstructionFactory factory = new InstructionFactory(modClass, cp);

        /*
         * PARAMETERS NEEDED:
         * method name, arguments' types, return value type
         * e.g. Method to be called: someMethod(Ljava/lang/String;)Ljava/lang/String;
         */

        MethodGen methodGen;

        methodGen = transform.createStatementMethod(il, cp, className, factory);

        modClass.addMethod(methodGen.getMethod());
        modClass.update();

//        InvokeInstruction callStatement = factory.createInvoke(className,
//                "statement",
//                Type.VOID,
//                new Type[]{new ArrayType(Type.STRING, 1)},
//                Constants.INVOKEVIRTUAL);

//        try {
//            JavaClass newClass = modClass.getJavaClass();
//            String className2 = className.replace(".", "/");
//            newClass.dump(className2 + ".class");
//            System.out.println("Class " + className + " modified\n");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        for(Method m : clazz.getMethods()){
            if(m.getReturnType().toString() != "void"){
                System.out.println("Method's name: " + m.getName().toString());
                System.out.println("Type of method: " + m.getReturnType().toString());
                System.out.println("Arguments' types:");

                Type[] types = m.getArgumentTypes();
                if(types.length > 0) {
                    for(int i = 0; i < types.length; i++){
                        System.out.println(types[i].toString());
                    }
                } else {
                    System.out.println("no arguments");
                }
                Instruction fieldInstruction = null;
                MethodGen mg = new MethodGen(m, clazz.getClassName(), cp);
                InstructionList instructionList  = mg.getInstructionList();
                InstructionHandle[] ihs = instructionList.getInstructionHandles();

                for(int f = 0; f < ihs.length; f++){
                    if(ihs[f].getInstruction() instanceof INVOKESTATIC
                            || ihs[f].getInstruction() instanceof  LDC
                            || ihs[f].getInstruction() instanceof INVOKEVIRTUAL
                            || ihs[f].getInstruction() instanceof INVOKEINTERFACE){
                        fieldInstruction = ihs[f].getInstruction();
//                        instructionList.insert(fieldInstruction, callStatement);
                        System.out.println("Found the invoke " + fieldInstruction.toString() + "\n");
                    }
                }
            }
        }

    }

    private MethodGen createStatementMethod(InstructionList il, ConstantPoolGen cp, String className, InstructionFactory factory){
        il.append(new GETSTATIC(cp.addFieldref("java.lang.System", "out", "Ljava/io/PrintStrem;")));
        il.append(new PUSH(cp, "Is it working??"));
        il.append(new INVOKEVIRTUAL(cp.addMethodref("java.io.PrintStrem", "println", "(Ljava/lang/String;)V")));
        il.append(new RETURN());

        MethodGen methodGen = new MethodGen(
                Constants.ACC_PUBLIC | Constants.ACC_STATIC,
                Type.VOID,
                new Type[]{new ArrayType(Type.STRING, 1)},
                null,
                "statement",
                className,
                il,
                cp);

        methodGen.setMaxLocals();
        methodGen.setMaxStack();

        return methodGen;
    }
}
