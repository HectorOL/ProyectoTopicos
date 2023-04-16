package GUI;

import javax.swing.*;
import java.awt.*;

public class Gui3 extends JFrame {
    //Constantes y componenetes
    private Container panel;
    private JButton miBoton;

    public Gui3() {
        super("Ventana / Herencia"); // Establece el titulo de la ventana
        //Configurar componentes
        miBoton = new JButton("Aceptar");
        panel = getContentPane();
        panel.add(miBoton);
        setSize(200, 200); // Establece el tamaño de la ventana
        setLocationRelativeTo(null); // Se posiciona en el centro con el null
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar la ventana al darle al boton
        setResizable(false); // El tamaño de la ventana no puede cambiar
        setVisible(true);
    }
}