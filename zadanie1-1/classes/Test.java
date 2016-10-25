public class Test {

    private static Test test = new Test();

    public static void main(String[] args){
        System.out.println("Hello, I'm MAIN");
        natural(5, 2);
        System.out.println(hello("Hello from the other side"));
    }

    static int natural(int a, int b){
        test.hi();
        return a + b;
    }

    String hi(){
        String s = "HI naturally!";
        return s;
    }

    static String hello(String s){
        return s;
    }
}
