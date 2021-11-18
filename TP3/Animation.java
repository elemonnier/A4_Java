import javax.swing.JLabel;

public class Animation extends Thread {

    private JLabel label;
    private String text;
    private int delay;


    public Animation(JLabel label,  String text, int delay) {
        this.label = label;
        this.delay = delay;
        this.text = text;
    }

    public void animate(){

        String text = "";

        for (int i = 0; i < this.text.length(); i++) {

            text += this.text.charAt(i);

            try {
                Thread.sleep(this.delay);

            } catch (InterruptedException e) {

            }

            this.label.setText(text);
        }
    }

    public void run() {
        animate();
    }
}