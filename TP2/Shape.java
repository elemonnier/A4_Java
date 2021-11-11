import java.awt.*;

public abstract class Shape implements Moveable {
    protected Point center;
    private int lineWidth;
    private Color lineColor;

    public Shape(Point center, int lineWidth, Color lineColor) {
        this.center = center;
        this.lineWidth = lineWidth;
        this.lineColor = lineColor;
    }

    public Shape(Point center) {
        this(center, 1, Color.BLACK);
    }

    public Point getCenter() {
        return center;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public int getLineWidth() {
        return lineWidth;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    public void print() {
        System.out.println("Shape - center : " + this.center);
    }

    public abstract void draw(Paint paint);

    public static void printShapes(Shape[] shapes) {
        for (Shape shape : shapes) {
            shape.print();
        }
    }

    public static void drawShapes(Shape[] shapes, Paint paint) {
        for (Shape shape : shapes) {
            shape.draw(paint);
        }
    }

    public abstract Rectangle getTmpBounding();

    public static Rectangle getBoundingBox(Shape[] shapes) {
        int xmax = Integer.MIN_VALUE;
        int ymax = Integer.MIN_VALUE;
        int xmin = Integer.MAX_VALUE;
        int ymin = Integer.MAX_VALUE;
        Rectangle tmp;

        for (Shape shape : shapes) {
            tmp = shape.getTmpBounding();

            if (xmax < tmp.center.getX() + tmp.getWidth() / 2) {
                xmax = tmp.center.getX() + tmp.getWidth() / 2;
            }
            if (xmin > tmp.center.getX() - tmp.getWidth() / 2) {
                xmin = tmp.center.getX() - tmp.getWidth() / 2;
            }
            if (ymax < tmp.center.getY() + tmp.getHeight() / 2) {
                ymax = tmp.center.getY() + tmp.getHeight() / 2;
            }
            if (ymin > tmp.center.getY() - tmp.getHeight() / 2) {
                ymin = tmp.center.getY() - tmp.getHeight() / 2;
            }
        }
        int height = ymax - ymin;
        int weight = xmax - xmin;

        Point point = new Point(xmin + weight / 2, ymin + height / 2);

        return new Rectangle(point, weight, height);
    }
}
