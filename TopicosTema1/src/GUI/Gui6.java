package GUI;

import javax.swing.*;
import java.awt.*;

public class Gui6 extends JFrame {
    // Constantes y componentes
    public Gui6() {
        super("Gui 6");
        getContentPane().setLayout(new GridLayout(4,3,5,5));
        for (int i = 1; i <= 10; i++) {
            add(new JButton(Integer.toString(i)));
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack();
            setVisible(true);
        }
    }

}
