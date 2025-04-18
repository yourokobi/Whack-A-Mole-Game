import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonInteraction extends JFrame {
    public ButtonInteraction() {
        // Set up the JFrame
        setTitle("Exercise 1: Button Interaction");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Create a panel for the main buttons
        JPanel mainPanel = new JPanel(new FlowLayout());

        // Add "Push me" button
        JButton pushButton = new JButton("Push me");
        pushButton.addActionListener(e -> JOptionPane.showMessageDialog(
                this,
                "You pushed the button!",
                "Push Button",
                JOptionPane.INFORMATION_MESSAGE
        ));
        mainPanel.add(pushButton);

        // Add "Click me" button
        JButton clickButton = new JButton("Click me");
        clickButton.addActionListener(e -> JOptionPane.showMessageDialog(
                this,
                "You clicked the button!",
                "Click Button",
                JOptionPane.INFORMATION_MESSAGE
        ));
        mainPanel.add(clickButton);

        // Add "Nothing" button
        JButton nothingButton = new JButton("Nothing");
        mainPanel.add(nothingButton); // No action listener, does nothing

        // Add the main panel to the JFrame
        add(mainPanel, BorderLayout.CENTER);

        // Create a panel for numbered buttons
        JPanel numberPanel = new JPanel(new GridLayout(1, 5));
        for (int i = 1; i <= 5; i++) {
            JButton numberButton = new JButton("Button " + i);
            int buttonNumber = i; // Capture loop variable for use in lambda
            numberButton.addActionListener(e -> JOptionPane.showMessageDialog(
                    this,
                    "You pressed Button " + buttonNumber,
                    "Number Button",
                    JOptionPane.INFORMATION_MESSAGE
            ));
            numberPanel.add(numberButton);
        }

        // Add the number panel to the JFrame
        add(numberPanel, BorderLayout.SOUTH);

        // Make the JFrame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ButtonInteraction::new);
    }
}
