package EntradaSalida;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class Tools {
    public static boolean validaNombre(String cad){
        if (cad != null && cad.matches("([a-z A-Z]|\\s)+")) {
            return true;
        }
        JOptionPane.showMessageDialog(null,"El nombre contiene caracteres invalidos");
        return false;        
    }

    public static boolean validaEdad(String cad){
        boolean band;
        cad = cad.trim();
        band = (cad != null && cad.matches("[0-9]+"));
        if (!band) {
            JOptionPane.showMessageDialog(null, "La edad contiene caracteres no validos");
        }else{
            int edad = Integer.parseInt(cad);
            if (edad >= 0 && edad <= 150) {
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "La edad esta fuera del rango");
            }
        }
        return false;
    }

    public static boolean validarSeleccion(ButtonGroup botones , String cad) {
        Enumeration<AbstractButton> listaBotones = botones.getElements();
        while(listaBotones.hasMoreElements()){
            AbstractButton boton = listaBotones.nextElement();
            if(boton.isSelected()){
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Debe seleccionar alguna opcion en el apartado " + cad);
        return false;
    }
}
