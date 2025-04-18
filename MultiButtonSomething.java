import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MultiButtonSomething extends Frame {

    public MultiButtonSomething() {
        super("This is my application");
        Panel jp = new Panel(new FlowLayout());
        add(jp);
        setSize(350, 200);

        Button aButton = new Button("Push me");
        jp.add(aButton);

        Button bButton = new Button("Click me");
        jp.add(bButton);

        jp.add(new Button("Nothing"));

        aButton.addActionListener(new AButtonActionListener());
        bButton.addActionListener(new BButtonActionListener());

        ActionListener arl = new ArrActionListener();
        for (int x = 0; x < 4; x++) {
            Button btnArr = new Button("Button " + x);
            jp.add(btnArr);
            btnArr.addActionListener(arl);
        }

        Button closeButton = new Button("Close Application");
        jp.add(closeButton);
        
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Application closed via button.");
                System.exit(0);
            }
        });

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Application closed via [X] button.");
                System.exit(0);
            }
        });
    }
    
    private class AButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            JOptionPane.showMessageDialog(null, "A button was pushed!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private class BButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            int response = JOptionPane.showConfirmDialog(
                null,
                "Do you want to continue?",
                "Confirmation",
                JOptionPane.YES_NO_CANCEL_OPTION
            );

            if (response == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "You clicked YES!");
            } else if (response == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "You clicked NO!");
            } else if (response == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "You clicked CANCEL!");
            } else {
                JOptionPane.showMessageDialog(null, "No response selected.");
            }
        }
    }

    private class ArrActionListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            String btn = evt.getActionCommand();
            JOptionPane.showMessageDialog(null, btn + " was pressed!");
        }
    }

    public static void main(String[] args) {
        new MultiButtonSomething();
    }
}