import java.awt.*;

public class Main {

    public static void testPoint1() {
        Point p = new Point(100, 200);
        System.out.println(p.getX());
        p.setX(300);
        System.out.println(p.getX());
    }

    public static void testPoint2() {
        Point p = new Point(100, 200);
        System.out.println(p);
    }

    public static void testPoint3() {
        Point p = new Point(100, 200);
        String s = "Point coordinates : " + p;
        System.out.println(s);
    }

    public static void testShape1() {
        Point center = new Point(100, 200);
//        Shape s = new Shape(center);
//        s.print();
    }

    public static void testShape2() {
//        Shape s = new Shape(new Point(100, 200));
//        s.print();
    }

    public static void testCircle1() {
        Circle c = new Circle(new Point(100, 200), 50);
        c.print();
    }

    public static void testCircle2() {
        Shape c = new Circle(new Point(100, 200), 50);
        c.print();
    }

    public static void testRectangle() {
        Rectangle r = new Rectangle(new Point(100, 200), 25, 35);
        r.print();
    }

    public static void testShapesArray() {
        Shape c = new Circle(new Point(100, 200), 50);
        Rectangle r = new Rectangle(new Point(100, 200), 25, 35);

        Shape[] array = new Shape[2];
        array[0] = c;
        array[1] = r;

        Shape.printShapes(array);
    }

    public static void testPaint() {
        Paint p = new Paint(500, 300);
        p.drawLine(100, 200, 200, 100);
        p.drawArc(300, 200, 200, 200, 0, 90);
    }

    public static void testDrawCircleAndRectangle() {
        Paint p = new Paint(200, 200);
        Circle c = new Circle(new Point(100, 100), 100);
        c.draw(p);
        Rectangle r = new Rectangle(new Point(100, 100), 173, 100);
        r.draw(p);
    }

    public static void testPolymorphism() {
        Paint p = new Paint(200, 200);
        Circle c = new Circle(new Point(100, 100), 100);
        Rectangle r = new Rectangle(new Point(100, 100), 173, 100);
        Shape[] shapes = new Shape[2];
        shapes[0] = c;
        shapes[1] = r;
        Shape.drawShapes(shapes, p);
    }

    public static void testColors() {
        Paint p = new Paint(200, 200);

        Circle c = new Circle(new Point(100, 100), 100, Color.RED, 5);
        c.draw(p);
        Rectangle r = new Rectangle(new Point(100, 100), 173, 100, Color.BLUE, 2);
        r.draw(p);
    }

    public static void testBoundingBox() {
        Paint p = new Paint(700, 700);
        Shape c = new Circle(new Point( 150, 150 ),100, Color.BLUE,1);
        Shape r = new Rectangle(new Point(100, 100),173,100, Color.BLUE, 1);
        r.moveTo(550, 550);
        c.moveTo(200,200);

        Shape[] shapes1 = {r,c};
        Rectangle final_rect = Shape.getBoundingBox(shapes1);
        final_rect.setLineColor(Color.RED);
        final_rect.setLineWidth(2);

        Shape[] shapes = {r,c,final_rect};
        Shape.drawShapes(shapes,p);
    }

    public static void main(String[] args) {
        testBoundingBox();
    }
}
