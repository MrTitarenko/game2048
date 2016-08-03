//20.03.2016

import javax.swing.JFrame;

public class Begin {
    public static void main(String[] args) {
        Window window = new Window("2048");
        window.setVisible(true);                                        // visibility
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(250, 250);
        window.setResizable(false);                                     // do not resize
        window.setLocationRelativeTo(null);                             // in the center of the screen
    }
}