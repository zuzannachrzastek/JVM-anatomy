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
        ConstantPoolGen cp = new ConstantPoolGen(clazz.getConstantPool());

        InstructionList il = new InstructionList();
        il.append(new GETSTATIC(cp.addFieldref("java.lang.System", "out", "Ljava/io/PrintStrem;")));
        il.append(new PUSH(cp, "Is it working??"));
        il.append(new INVOKEVIRTUAL(cp.addMethodref("java.io.PrintStrem", "println", "(Ljava/lang/String;)V")));
        il.append(new RETURN());

        InstructionFactory factory = new InstructionFactory(modClass, cp);

        /*
         * PARAMETERS NEEDED:
         * method name, arguments' types, return value type
         * e.g. Method to be called: someMethod(Ljava/lang/String;)Ljava/lang/String;
         */

        for(Method m : clazz.getMethods()){
            MethodGen mg = new MethodGen(m, m.getName(), cp);
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

                InstructionList mgInsList = mg.getInstructionList();
                InstructionHandle[] ihs = mgInsList.getInstructionHandles();

                for(int f = 0; f < ihs.length; f++){

                    System.out.println("ins. " + f + ": " + ihs[f].getInstruction().toString());

                    if(ihs[f].getInstruction() instanceof INVOKESTATIC){
                        fieldInstruction = ihs[f].getInstruction();
//                        instructionList.insert(fieldInstruction, callStatement);
                        System.out.println("Found the invoke " + fieldInstruction.toString() + "\n");
                    }
                }
            }
        }

        modClass.update();
    }
}
