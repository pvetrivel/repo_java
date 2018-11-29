package Game;

public class Utils {


    private Utils() {
        throw new AssertionError("dont instatntiate");
    }


    public static int doRandom(int someParam) {
        return (int) (Math.random() * someParam);
    }


    public static void printMessage(String message) {
        System.out.println(message);
    }
}
