package EntradaSalida;

import javax.swing.JOptionPane;
public class Tools {
    //Métodos de lectura
    public static String validaNom(String msj) {
        String cad;
        boolean bandera;
        do {
            cad = JOptionPane.showInputDialog(null, msj, "Lectura String", JOptionPane.QUESTION_MESSAGE);
            bandera = (cad != null && cad.matches("([a-z A-Z ñ, á]|\\s)+"));
            if (bandera) {
                return cad;
            } else {
                JOptionPane.showMessageDialog(null,"Contiene caracteres no validos");
            }
        } while (!bandera);
        return cad;
    }

    public static String  validaCtrl(String numControl) {
     String num;
     boolean band;
     do {
         num = JOptionPane.showInputDialog(null, numControl, "No. Control", JOptionPane.QUESTION_MESSAGE);
         band = (num != null && num.matches("[0-9]{8}"));
         if (band) {
             return num;
         } else {
             JOptionPane.showMessageDialog(null,"Contiene caracteres no validos");
         }
     }while (!band);
     return num;
    }

    public static byte validaEdad(String msj) {
        byte edad;
        boolean band;
        do {
            edad = Byte.parseByte(JOptionPane.showInputDialog(null, msj, "Lectura edad", JOptionPane.QUESTION_MESSAGE));
            band = (edad >= 17 && edad <= 60);
            if (band) {
                return edad;
            } else {
                JOptionPane.showMessageDialog(null, "Edad no valida");
            }
        } while (!band);
        return edad;
    }

    //Métodos de validación
    public static boolean validarCtrl(String numControl) {
        numControl = numControl.trim();
        return numControl.matches("[0-9]{8}");
    }

    public static byte Semestre(){
        String valores []= {"1","2","3","4","5","6","7","8","9","10","11","12"};
        return Byte.parseByte((String) JOptionPane.showInputDialog(null, "Selecciona","Semestre", JOptionPane.QUESTION_MESSAGE, null,valores,valores[0]));
    }
}