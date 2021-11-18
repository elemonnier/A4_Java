import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CancelButtonListener  implements ActionListener {
    private JLabel CancelLabel;

    public CancelButtonListener(JLabel cancelLabel) {
        this.CancelLabel = cancelLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Cancel Clicked! (v1)");
        this.CancelLabel.setText("Cancel clicked! (v1)");
    }
}
