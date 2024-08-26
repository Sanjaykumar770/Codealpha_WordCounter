import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WordCount extends JFrame implements ActionListener {
    JTextArea ta;
    JButton b1, b2;

    WordCount() {
        super("Word Character Counter");

        // Set up the JTextArea
        ta = new JTextArea();
        ta.setPreferredSize(new Dimension(300, 200));

        // Set up the buttons
        b1 = new JButton("Word Count");
        b2 = new JButton("Character Count");

        b1.addActionListener(this);
        b2.addActionListener(this);

        // Create a panel for the buttons and center them with spacing
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(b1);
        buttonPanel.add(b2);

        // Create a panel for the text area and add it to a JScrollPane
        JPanel textPanel = new JPanel();
        textPanel.add(new JScrollPane(ta));

        // Set the layout of the JFrame and add panels
        setLayout(new BorderLayout());
        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set the frame size and center it on the screen
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center the window on the screen
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String text = ta.getText();
        if (e.getSource() == b1) {
            String[] words = text.trim().split("\\s+");
            JOptionPane.showMessageDialog(this, "Total words: " + (text.isEmpty() ? 0 : words.length));
        }
        if (e.getSource() == b2) {
            JOptionPane.showMessageDialog(this, "Total Characters (with spaces): " + text.length());
        }
    }

    public static void main(String[] args) {
        new WordCount();
    }
}
