package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class Gui9 extends JFrame implements ChangeListener {

    private JRadioButton radio1, radio2, radio3,radio4;
    private ButtonGroup grupoBotones;

    public Gui9 () {
        setLayout(null);
        setTitle("Ejemplo 9");
        setSize(350,230);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        grupoBotones = new ButtonGroup();

        radio1 = new JRadioButton("Tamaño del frame 640*480");
        radio1.setBounds(10,20,200,30);
        radio1.addChangeListener(this);
        add(radio1);
        grupoBotones.add(radio1);

        radio2 = new JRadioButton("Tamaño del frame 800*600");
        radio2.setBounds(10,50,200,30);
        radio2.addChangeListener(this);
        add(radio2);
        grupoBotones.add(radio2);

        radio3 = new JRadioButton("Tamaño del frame 1024*768");
        radio3.setBounds(10,80,200,30);
        radio3.addChangeListener(this);
        add(radio3);
        grupoBotones.add(radio3);

        radio4 = new JRadioButton("Salir");
        radio4.setBounds(10,110,200,30);
        radio4.addChangeListener(this);
        add(radio4);
        grupoBotones.add(radio4);

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (radio1.isSelected()) {
            setSize(640,480);
            setTitle("Ejemplo 9/640*480");
            this.getContentPane().setBackground(Color.orange);
        }
        if (radio2.isSelected()) {
            setSize(800,600);
            setTitle("Ejemplo 9/800*600");
            this.getContentPane().setBackground(Color.pink);
        }
        if (radio3.isSelected()) {
            setSize(1024,768);
            setTitle("Ejemplo 9/1024*768");
            this.getContentPane().setBackground(Color.darkGray);
        }
        if (radio4.isSelected()) {
            System.exit(0);
        }
    }

}