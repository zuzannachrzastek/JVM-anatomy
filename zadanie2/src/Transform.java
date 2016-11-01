import com.sun.org.apache.bcel.internal.Repository;
import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import com.sun.org.apache.bcel.internal.classfile.Method;
import com.sun.org.apache.bcel.internal.generic.ClassGen;
import com.sun.org.apache.bcel.internal.generic.ConstantPoolGen;

import java.io.IOException;

/**
 * Created by Zuzanna on 01.11.2016.
 */
public class Transform {

    private static JavaClass clazz;
    private static ClassGen cg;
    private static ConstantPoolGen cpg;

    public static void main(String[] args) throws IOException {

        String className = (args.length >= 1) ? args[0] : "";
        try {
            clazz = Repository.lookupClass(className);
        } catch (Exception e) {
            System.err.println("Could not find class " + className);
        }

        Method[] methods = clazz.getMethods();

        for(Method method : methods) {

        }

        String classFilePath = Repository.lookupClassFile(cg.getClassName()).getPath();
        cg.getJavaClass().dump(classFilePath);
    }
}
