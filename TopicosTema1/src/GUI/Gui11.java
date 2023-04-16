package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Gui11 extends JFrame implements ItemListener {

    private final JCheckBox sistemas;
    private final JCheckBox informatica;
    private final JCheckBox electronica;
    private final JTextArea areaTexto;
    private JTextField prueba;

    public Gui11() {
        setTitle("JCheckBox11");
        setSize(300,200);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        sistemas = new JCheckBox("Sistemas");
        add(sistemas);
        sistemas.addItemListener(this);

        informatica = new JCheckBox("Informatica");
        add(informatica);
        informatica.addItemListener(this);

        electronica = new JCheckBox("Electronica");
        add(electronica);
        electronica.addItemListener(this);

        areaTexto = new JTextArea(0,15);
        add(areaTexto);

        prueba = new JTextField("Masculino");
        add(prueba);
        prueba.setBounds(10,150,100,30);

        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent event) {
        String nuevaLinea = "\r\n";
        areaTexto.setText("");
        if (sistemas.isSelected()) {
            areaTexto.append("Se selecciono Ing. en Sistemas" + nuevaLinea);
        }
        if (informatica.isSelected()) {
            areaTexto.append("Se selecciono Ing. Informatica" + nuevaLinea);
        }
        if (electronica.isSelected()) {
            areaTexto.append("Se selecciono Ing. Electronica" + nuevaLinea);
        }
    }
}