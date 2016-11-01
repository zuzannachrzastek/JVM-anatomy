import org.apache.bcel.Constants;
import org.apache.bcel.Repository;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.*;

import java.io.IOException;

/**
 * Created by Zuzanna on 26.10.2016.
 */
public class Transform {

    public static void main(String[] args) throws IOException {
        String className = (args.length >= 1) ? args[0] : "";
        JavaClass clazz = null;

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
            InstructionList mgInsList = mg.getInstructionList();
            InstructionFactory factory = new InstructionFactory(modClass);
            InstructionHandle[] mgInsHandles = mgInsList.getInstructionHandles();

            for(InstructionHandle handle : mgInsHandles){
                if(handle.getInstruction() instanceof GETFIELD){
                    Type type = ((GETFIELD) handle.getInstruction()).getType(cpg);

                    if(type instanceof  BasicType){
                        GETFIELD getField = (GETFIELD) handle.getInstruction();
                        InstructionList resInsList = new InstructionList();

                        resInsList.insert(handle, factory.createPrintln(
                                "Before getfield:\n    "
                                + modClass.getClassName() + "\n    "
                                + type.toString() + "\n    "
                                + ((GETFIELD) handle.getInstruction()).getFieldName(cpg)
                        ));
                        resInsList.append(factory.createFieldAccess(
                                "java.lang.System",
                                "out",
                                new ObjectType("java.io.PrintStream"),
                                Constants.GETSTATIC
                        ));
                        resInsList.append(new LDC(cpg.addString("    ")));
                        resInsList.append(factory.createInvoke(
                                "java.io.PrintStream",
                                "print",
                                Type.VOID,
                                new Type[]{Type.STRING},
                                Constants.INVOKEVIRTUAL
                        ));
                        resInsList.append(InstructionFactory.DUP);
                        resInsList.append(factory.createFieldAccess(
                                "java.lang.System",
                                "out",
                                new ObjectType("java.io.PrintStream"),
                                Constants.GETSTATIC
                        ));
                        resInsList.append(InstructionFactory.SWAP);
                        resInsList.append(getField);
                        resInsList.append(factory.createInvoke(
                                "java.io.PrintStream",
                                "println",
                                Type.VOID,
                                new Type[]{type},
                                Constants.INVOKEVIRTUAL
                        ));
                        mgInsList.insert(getField, resInsList);
                    }

                    mg.setInstructionList(mgInsList);
                    mg.setMaxStack();
                    modClass.replaceMethod(m, mg.getMethod());
                }
            }
        }
        modClass.getJavaClass().dump(Repository.lookupClassFile(modClass.getClassName()).getPath());
    }
}
