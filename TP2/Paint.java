import javax.swing.JPanel;
import javax.swing.JFrame;

// java.awt.*
import java.awt.Color;
import java.awt.Shape;
import java.awt.Dimension;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;

import java.util.LinkedList;
import java.util.List;




public class Paint extends JPanel{

    // inner class modeling a view on a AWT Shape
    private class ShapeView {

        // model : AWT Shape
        private final Shape shape;

        // drawing settings
        private final int lineWidth;        // in px
        private final Color lineColor;

        public ShapeView(Shape shape, int lineWidth, Color lineColor) {
            this.shape = shape;
            this.lineWidth = lineWidth;
            this.lineColor = lineColor;
        }

        public Shape getShape() {
            return this.shape;
        }

        public int getLineWidth() {
            return this.lineWidth;
        }

        public Color getLineColor() {
            return this.lineColor;
        }
    }


    private List<ShapeView> shapeViews;

    // current drawing settings
    private int currentLineWidth;
    private Color currentColor;

    // default drawing settings
    private static final int DEFAULT_LINE_WIDTH = 1;
    private static final Color DEFAULT_LINE_COLOR = Color.BLACK;
    private static final Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;

    public Paint(int width, int height){
        this.shapeViews = new LinkedList<>();
        this.currentColor = DEFAULT_LINE_COLOR;
        this.currentLineWidth = DEFAULT_LINE_WIDTH;

        this.setBackground(DEFAULT_BACKGROUND_COLOR);
        this.setPreferredSize( new Dimension( width, height ) );

        JFrame wrappingFrame = new JFrame("Paint");
        wrappingFrame.setContentPane(this);
        wrappingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wrappingFrame.pack();
        wrappingFrame.setVisible(true);


    }

    // add a shape view and refresh panel
    private void addShapeView(Shape s){
        this.shapeViews.add(new ShapeView(s, this.currentLineWidth, this.currentColor));
        this.repaint();
    }

    public void setLineWidth(int lineWidth){
        this.currentLineWidth = lineWidth;
    }

    public void setColor(Color color){
        this.currentColor = color;
    }

    // creates the model associated to a line (Line2D instance) and add the associated view with the current drawing settings
    public void drawLine(int xstart, int ystart, int xend, int yend){

        this.addShapeView(new Line2D.Double(xstart, ystart, xend, yend));

    }

    // creates the model associated to an arc (Arc2D instance) and add the associated view with the current drawing settings
    public void drawArc(double x, double y, double width, double height, double start, double end){

        this.addShapeView(new Arc2D.Double(x-width/2, y-height/2, width, height, start, end - start, Arc2D.OPEN));

    }

    // remove all shape views and refresh panel
    public void clear(){
        this.shapeViews.clear();
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.clearRect(0, 0, getSize().width, getSize().height);
        Graphics2D g2 = (Graphics2D)g;

        System.out.println(shapeViews.size());

        for (ShapeView shapeView : new LinkedList<>(shapeViews)){

            g2.setColor(shapeView.getLineColor());
            g2.setStroke(new BasicStroke(shapeView.getLineWidth()));
            g2.draw(shapeView.getShape());
        }

    }
}
