package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controlador.Controlador;

public class Gui extends JFrame {
    private JPanel contenedor;
    private Controlador controlador;

    public Gui() {
        super("Examen");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        inicializaComponentes();
        setVisible(true);
    }

    private void inicializaComponentes() {
        contenedor = new JPanel();
        contenedor.setLayout(null);

        controlador = new Controlador(900, 700);
        contenedor.add(controlador);
        add(contenedor);
    }
    
}
