package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui8 extends JFrame implements ActionListener {

    private JTextField textfield1;
    private JLabel label1;
    private JButton boton1, boton2;
    public Gui8 () {
        super("Gui8: Activación Oyente");
        setLayout(null);
        setSize(300,150);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel("Nombre:");
        label1.setBounds(10,10,100,30);
        add(label1);
        textfield1 = new JTextField();
        textfield1.setBounds(80,10,150,30);
        add(textfield1);

        boton1 = new JButton("Saludar");
        boton1.setBounds(10,80,100,30);
        boton1.addActionListener(this);
        add(boton1);

        boton2 = new JButton("Salir");
        boton2.setBounds(170,80,100,30);
        boton2.addActionListener(this);
        add(boton2);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {

            System.out.println("Hola " + textfield1.getText() + " como estas?");
        }
        if (e.getSource() == boton2) {
            System.exit(0);
        }
    }
}