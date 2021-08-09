import java.awt.*;
import javax.swing.*;

class HelloWorld {
    public static void main(String[] args) {
        String myString = "Hello World, and hello Mark";
        System.out.println(myString);
        JFrame frame = new JFrame("Simple GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel textLabel = new JLabel(myString,SwingConstants.CENTER); 
        textLabel.setPreferredSize(new Dimension(300, 100));
        frame.getContentPane().add(textLabel, BorderLayout.CENTER); 
        frame.setLocationRelativeTo(null); 
        frame.pack();
        frame.setVisible(true);
    }
}