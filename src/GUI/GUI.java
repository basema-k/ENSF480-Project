package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.WindowConstants;

public class GUI {
    public GUI(){

    }

    public void start(){
        JFrame frame = new JFrame();

        JPanel panel = new JPanel(new GridLayout(3,1));
        JPanel fieldsPanel = new JPanel(new GridLayout(2,2));
        fieldsPanel.add(new JLabel("Enter your email"));
        fieldsPanel.add(new JTextField());
        fieldsPanel.add(new JLabel("Enter your password"));
        fieldsPanel.add(new JPasswordField());

        fieldsPanel.setSize(500, 50);

        JLabel title = new JLabel("480 Term Project", JLabel.CENTER);
        title.setSize(1000, 10);

        panel.add(title);
        panel.add(fieldsPanel);
        panel.add(new JButton("Login"));

        frame.add(panel);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
