/**
 * Created by Zuzanna on 26.10.2016.
 */
import java.io.IOException;

public class Test {
    private int num = 5;

    public static void main(String[] argv) throws IOException {
        int b;
        System.out.println("Hello world");
        Test test = new Test();
        for (int i=0; i<10; i++){
            System.out.println(test.plus());
        }
    }

    public int plus(){
        return num++;
    }

    public Test() {
        System.out.println("Value of someInt: [" + this.num + "]");
    }
}
