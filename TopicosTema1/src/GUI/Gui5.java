package GUI;

import javax.swing.*;
import java.awt.*;

public class Gui5 extends JFrame {
    public Gui5() {
        super("Ventana / Herencia");
        getContentPane().setLayout(new FlowLayout());
        //Se instalan los componentes
        JButton boton = new JButton("Boton");
        JLabel etiqueta = new JLabel("Dato:");
        JTextField textField = new JTextField(10);
        JCheckBox checkBox = new JCheckBox("Check box");

        //Se añaden los componentes a la ventana
        getContentPane().add(boton);
        getContentPane().add(etiqueta);
        getContentPane().add(textField);
        getContentPane().add(checkBox);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}