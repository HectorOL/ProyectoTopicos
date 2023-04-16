package GUI;

import javax.swing.*;

public class Gui1 extends JFrame {
    //Constantes y componenetes(objeto)
    public Gui1 () {
        super("Ventana usando Herencia"); //Establece el titulo de la ventana
        setSize(370,450); //Establece el tamaño de la ventana
        setLocationRelativeTo(null); // Se posiciona en el centro de la pantalla con el null

        //Establece que el boton de cerrar permita salir de la aplicacion
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); //El tamaño de la ventana no se puede cambiar
        setVisible(true); //Para que la ventana se pueda visibilizar
    }
}