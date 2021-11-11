public class Turtle extends Paint {
    // attributes
    private boolean pen; // false = up, true = down
    private int heading;
    private int posX; // coordinate shifted on center
    private int posY;
    final private int width; // origin modification, could be a Point type
    final private int height;

    // constructor
    public Turtle(int width, int height) {
        super(width, height);
        this.heading = 0;
        this.pen = true;
        this.posX = width / 2;
        this.posY = height / 2;
        this.width = width;
        this.height = height;
    }

    // getters
    public boolean isPen() { // isDown
        return pen;
    }

    public int getHeading() {
        return heading;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    // setters
    public void penUp() {
        this.pen = false;
    }

    public void penDown() {
        this.pen = true;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public void setPosX(int posX) {
        this.posX = this.width / 2 + posX;
    }

    public void setPosY(int posY) {
        this.posY = this.height / 2 - posY;
    }

    // methods
    public void forward(int distance) {
        if (this.pen) {
            super.drawLine(this.posX, this.posY, this.posX + (int) (distance * Math.cos(Math.toRadians(this.heading))), this.posY - (int) (distance * Math.sin(Math.toRadians(this.heading))));
        }
        this.posX = this.posX + (int) (distance * Math.cos(Math.toRadians(this.heading)));
        this.posY = this.posY - (int) (distance * Math.sin(Math.toRadians(this.heading)));
    }

    public void backward(int distance) {
        if (this.pen) {
            super.drawLine(this.posX, this.posY, this.posX - (int) (distance * Math.cos(Math.toRadians(this.heading))), this.posY + (int) (distance * Math.sin(Math.toRadians(this.heading))));
        }
        this.posX = this.posX - (int) (distance * Math.cos(Math.toRadians(this.heading)));
        this.posY = this.posY + (int) (distance * Math.sin(Math.toRadians(this.heading)));
    }

    public void moveTo(int x, int y) {
        if (this.pen) {
            super.drawLine(this.posX, this.posY, this.width / 2 + x, this.height / 2 - y);
        }
        this.posX = this.width / 2 + x;
        this.posY = this.height / 2 - y;
    }

    public void left(int degrees) {
        this.heading += degrees;
    }

    public void right(int degrees) {
        this.heading -= degrees;
    }
}
