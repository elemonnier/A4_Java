public class Main {
    public static void testFirstWindow1() {
        Window1 w = new Window1("My first JFrame", 300, 100);
    }

    public static void testFirstWindow2() {
        Window2 w = new Window2("My first JFrame", 300, 100);
    }

    public static void testAnimation1() {
        Window1 w1 = new Window1("My first JFrame", 300, 100);

        Animation a1 = new Animation(w1.getOkLabel(), "ABCDEF", 500);
        a1.start();
        Animation a2 = new Animation(w1.getCancelLabel(), "123456", 500);
        a2.start();
    }

    public static void testAnimation2() {
        Window2 w2 = new Window2("My first JFrame", 300, 100);

        Animation a1 = new Animation(w2.getOkLabel(), "ABCDEF", 500);
        a1.start();
        Animation a2 = new Animation(w2.getCancelLabel(), "123456", 500);
        a2.start();
    }

    public static void main(String[] args) {
        testAnimation1();
    }
}
