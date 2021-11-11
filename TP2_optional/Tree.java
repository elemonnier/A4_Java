public abstract class Tree {

    public static void drawTree(Turtle turtle, int l, int n, float lratio, int langle, int rangle) {
        if (n == 0) {
            turtle.forward(l);
            turtle.backward(l);
            return;
        }
        turtle.forward(l);
        turtle.left(langle);
        drawTree(turtle, (int) (l * lratio), n - 1, lratio, langle, rangle);
        turtle.right(langle + rangle);
        drawTree(turtle, (int) (l * lratio), n - 1, lratio, langle, rangle);
        turtle.left(rangle);
        turtle.backward(l);
    }

    public static void drawTree(Turtle turtle, int l, int n) {
        drawTree(turtle, l, n, (float) 2 / 3, 15, 15);
    }

    public static void drawTreeInitTurtle(int l, int n, float lratio, int langle, int rangle) {
        Turtle turtle = new Turtle(500, 500);
        turtle.penUp();
        turtle.moveTo(0, -250);
        turtle.penDown();
        turtle.left(90);
        drawTree(turtle, l, n, lratio, langle, rangle);
    }

    public static void drawTreeInitTurtle(int l, int n) {
        Turtle turtle = new Turtle(500, 500);
        turtle.penUp();
        turtle.moveTo(0, -250);
        turtle.penDown();
        turtle.left(90);
        drawTree(turtle, l, n);
    }

    public static void testDrawTree1() {
        drawTreeInitTurtle(100,5);
    }

    public static void testDrawTree2() {
        drawTreeInitTurtle(100, 5, (float) 4 / 5, 15, 15);
    }

    public static void testDrawTree3() {
        drawTreeInitTurtle( 100, 5, (float) 2 / 3, 30, 30);
    }

    public static void testDrawTree4() {
        drawTreeInitTurtle(100, 5, (float) 2 / 3, -5, 30);
    }

    public static void broccoli() {
        drawTreeInitTurtle(100, 9, (float) 2 / 3, 45, 45);
    }

    public static void molecule() {
        drawTreeInitTurtle( 150, 9, (float) 2 / 3, 60, 60);
    }

    public static void squaredDandelion() {
        drawTreeInitTurtle( 200, 9, (float) 2 / 3, 90, 90);
    }

    public static void carpetPattern() {
        drawTreeInitTurtle( 200, 10, (float) 2 / 3, 135, 135);
    }

    public static void crystal() {
        drawTreeInitTurtle( 200, 9, (float) 2 / 3, 140, 140);
    }

    public static void main(String[] args) {
//        testDrawTree1();
//        testDrawTree2();
//        testDrawTree3();
//        testDrawTree4();
//        broccoli();
//        molecule();
//        squaredDandelion();
        carpetPattern();
//        crystal();
    }
}
