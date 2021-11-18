import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window2 extends JFrame implements ActionListener {
    private JPanel labelPanel;
    private JLabel okLabel;
    private JLabel cancelLabel;

    private JPanel buttonPanel;
    private JButton okButton;
    private JButton cancelButton;

    public Window2(String title, int width, int height) {

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

        this.okButton.addActionListener(this);
        this.cancelButton.addActionListener(this);


        // Print the window

        this.setVisible(true);
    }

    public JLabel getOkLabel() {
        return okLabel;
    }

    public JLabel getCancelLabel() {
        return cancelLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.okButton) {
            System.out.println("OK clicked! (v2)");
            this.okLabel.setText("OK clicked! (v2)");
        }
        if (e.getSource() == this.cancelButton) {
            System.out.println("Cancel clicked! (v2)");
            this.cancelLabel.setText("Cancel clicked! (v2)");
        }
    }
}
