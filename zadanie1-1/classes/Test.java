public class Test {

    public static void main(String[] args){
        System.out.println("Hello, I'm MAIN");
        natural(5, 2);
        System.out.println(hello());
    }

    static int natural(int a, int b){
        hi();
        return a + b;
    }

    static String hi(){
        String s = "HI naturally!";
        return s;
    }

    static String hello(){
        return "Hello from the other side";
    }
}
