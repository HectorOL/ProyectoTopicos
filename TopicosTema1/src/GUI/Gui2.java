package GUI;

import javax.swing.*;

public class Gui2 {
    public Gui2() {
        JFrame frame = new JFrame("Ventana sin Herencia");
        //Configurar componentes
        frame.setSize(370,470);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}