import java.awt.*;

public class Circle extends Shape {
    private int radius;

    public Circle(Point center, int radius, Color lineColor, int lineWidth) {
        super(center, lineWidth, lineColor);
        this.radius = radius;
    }

    public Circle(Point center, int radius) {
        this(center, radius, Color.BLACK, 1);
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void print() {
        System.out.println("Circle - center : " + super.getCenter() + ", radius : " + this.radius);
    }

    public void draw(Paint paint) {
        paint.setColor(getLineColor());
        paint.setLineWidth(getLineWidth());
        paint.drawArc(getCenter().getX(), getCenter().getY(), 2 * radius, 2 * radius, 0, 360);
    }

    @Override
    public void moveTo(int x, int y) {
        Point p = new Point(x, y);
        setCenter(p);
    }

    public Rectangle getTmpBounding() {
        return new Rectangle(new Point(this.center.getX(), this.center.getY()), 2 * radius, 2 * radius);
    }
}
