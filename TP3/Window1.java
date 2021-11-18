import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class Window1 extends JFrame {
    private JPanel labelPanel;
    private JLabel okLabel;
    private JLabel cancelLabel;

    private JPanel buttonPanel;
    private JButton okButton;
    private JButton cancelButton;


    public Window1(String title, int width, int height) {

        // Default initializations

        super(title);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // First half of the window

        this.okLabel = new JLabel("Click on OK");
        this.cancelLabel = new JLabel("Click on Cancel");

        this.labelPanel = new JPanel();
        this.labelPanel.setLayout(new GridLayout(2,1));
        this.labelPanel.add(this.okLabel);
        this.labelPanel.add(this.cancelLabel);

        this.add(this.labelPanel, BorderLayout.CENTER);


        // Second half of the window

        this.okButton = new JButton("OK");
        this.cancelButton = new JButton("Cancel");

        this.buttonPanel = new JPanel();
        this.buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.buttonPanel.add(this.okButton);
        this.buttonPanel.add(this.cancelButton);

        this.add(this.buttonPanel, BorderLayout.SOUTH);


        // Listener calls

        OKButtonListener okButtonListener = new OKButtonListener(this.okLabel);
        CancelButtonListener cancelButtonListener = new CancelButtonListener(this.cancelLabel);
        this.okButton.addActionListener(okButtonListener);
        this.cancelButton.addActionListener(cancelButtonListener);


        // Print the window

        this.setVisible(true);
    }

    public JLabel getOkLabel() {
        return okLabel;
    }

    public JLabel getCancelLabel() {
        return cancelLabel;
    }
}
