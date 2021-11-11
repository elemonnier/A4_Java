public class Main {
    public static void testSquare() {
        Turtle turtle = new Turtle(500,500);
        for (int i = 0; i < 4; i++) {
            turtle.forward(100);
            turtle.right(90);
        }
    }

    public static void testEquilateralTriangle() {
        Turtle turtle = new Turtle(500, 500);
        for (int i = 0; i < 3; i++) {
            turtle.forward(100);
            turtle.left(-120);
        }
    }

    public static void main(String[] args) {
        testSquare();
    }
}
