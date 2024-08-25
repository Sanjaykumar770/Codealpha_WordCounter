import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCount {

    public static void main(String[] args) {
        // Create a new JFrame (the window)
        JFrame frame = new JFrame("Word Counter");

        // Set the size of the window
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the window on the screen

        // Create a JTextArea for the paragraph input with custom font and size
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 18));
        textArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));

        // Create a JLabel to display the word count with custom font and color
        JLabel wordCountLabel = new JLabel("Word Count: 0");
        wordCountLabel.setFont(new Font("Arial", Font.BOLD, 24));
        wordCountLabel.setForeground(Color.BLUE);
        wordCountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create a JButton to trigger the word count with custom colors
        JButton countButton = new JButton("Count Words");
        countButton.setFont(new Font("Arial", Font.BOLD, 20));
        countButton.setBackground(Color.DARK_GRAY);
        countButton.setForeground(Color.WHITE);
        countButton.setFocusPainted(false);
        countButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add ActionListener to the button to perform the word count
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the text from the JTextArea
                String text = textArea.getText().trim();

                // Split the text into words
                if (text.isEmpty()) {
                    wordCountLabel.setText("Word Count: 0");
                } else {
                    String[] words = text.split("\\s+");
                    wordCountLabel.setText("Word Count: " + words.length);
                }
            }
        });

        // Create a JPanel to hold the components with improved layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);

        // Add the components to the panel
        panel.add(new JScrollPane(textArea));
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer
        panel.add(countButton);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer
        panel.add(wordCountLabel);

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
