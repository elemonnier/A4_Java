import java.awt.*;

public class Rectangle extends Shape {
    private int width; // todo: protected
    private int height;

    public Rectangle(Point center, int width, int height, Color lineColor, int lineWidth) {
        super(center, lineWidth, lineColor);
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point center, int width, int height) {
        this(center, width, height, Color.BLACK, 1);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void print() {
        System.out.println("Rectangle - center : " + super.getCenter() + ", width : " + this.width + ", height : " + this.height);
    }

    public void draw(Paint paint) {
        paint.setColor(getLineColor());
        paint.setLineWidth(getLineWidth());
        int x = getCenter().getX();
        int y = getCenter().getY();
        paint.drawLine(x - width / 2, y - height / 2, x + width / 2, y - height / 2);
        paint.drawLine(x + width / 2, y - height / 2, x + width / 2, y + height / 2);
        paint.drawLine(x + width / 2, y + height / 2, x - width / 2, y + height / 2);
        paint.drawLine(x - width / 2, y + height / 2, x - width / 2, y - height / 2);
    }

    @Override
    public void moveTo(int x, int y) {
        Point p = new Point(x, y);
        setCenter(p);
    }

    public Rectangle getTmpBounding(){
        return new Rectangle(new Point(this.center.getX(), this.center.getY()),this.width,this.height);
    }
}
