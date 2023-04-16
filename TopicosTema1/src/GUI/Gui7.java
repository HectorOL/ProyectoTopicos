package GUI;

import javax.swing.*;
import java.awt.*;

public class Gui7 extends JFrame {
    public Gui7 () {
        super ("Gui 7");
        setLayout(new BorderLayout(5,10));
        add(new JButton("1"),BorderLayout.EAST);
        add(new JButton("2"),BorderLayout.SOUTH);
        add(new JButton("3"),BorderLayout.WEST);
        add(new JButton("4"),BorderLayout.NORTH);
        add(new JButton("5"),BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
    }

}