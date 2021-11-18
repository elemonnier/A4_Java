import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OKButtonListener implements ActionListener {
    private JLabel OKLabel;

    public OKButtonListener(JLabel OKlabel) {
        this.OKLabel = OKlabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("OK Clicked! (v1)");
        this.OKLabel.setText("OK clicked! (v1)");
    }
}
