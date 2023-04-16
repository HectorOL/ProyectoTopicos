package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui12 extends JFrame implements ActionListener {

    private JLabel texto1, texto2, texto3, texto4;
    private JTextField txt1, txt2, txt3, txt4;
    private JButton btn1, btn2, btn3;
    
    public Gui12 () {
        super("Practica 12");
        setLayout(null);
        setSize(350,350);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        texto1 = new JLabel("Nombre del alumno: ");
        texto1.setBounds(10,10,100,30);
        add(texto1);
        txt1 = new JTextField();
        txt1.setBounds(80,10,150,30);
        add(txt1);

        texto2 = new JLabel("No. Control: ");
        texto2.setBounds(10,40,100,30);
        add(texto2);
        txt2 = new JTextField();
        txt2.setBounds(80,40,150,30);
        add(txt2);

        texto3 = new JLabel("Edad: ");
        texto3.setBounds(10,70,100,30);
        add(texto3);
        txt3 = new JTextField();
        txt3.setBounds(80,70,150,30);
        add(txt3);

        texto4 = new JLabel("Semestre: ");
        texto4.setBounds(10,100,100,30);
        add(texto4);
        txt4 = new JTextField();
        txt4.setBounds(80,100,150,30);
        add(txt4);

        btn1 = new JButton("Añadir");
        btn1.setBounds(10,230,80,30);
        btn1.addActionListener(this);
        add(btn1);

        btn2 = new JButton("Eliminar");
        btn2.setBounds(120,230,80,30);
        btn2.addActionListener(this);
        add(btn2);

        btn3 = new JButton("MENSAJE");
        btn3.setBounds(230,230,100,30);
        btn3.addActionListener(this);
        add(btn3);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn3) {
            System.out.println("BUENAS TARDES");
        }
        if (e.getSource() == btn2) {
            System.exit(0);
        }
    }
}