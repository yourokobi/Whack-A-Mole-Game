import javax.swing.*;
import java.awt.event.*;

public class CloseButton {
    // This method demonstrates how to add a close button to a container
    public static JButton createCloseButton(JPanel jp, JFrame frame) {
        JButton closeButton = new JButton("Close Application");
        jp.add(closeButton);
        closeButton.addActionListener(new ActionListener(){
            @Override 
            public void actionPerformed(ActionEvent e){
                System.out.println("Application closed via button.");
                System.exit(0); // This line actually closes the application
            }
        });
        //program terminates when the user clicks the [X] button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        return closeButton;
    }
}