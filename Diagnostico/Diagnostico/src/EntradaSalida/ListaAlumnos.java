package EntradaSalida;
import java.util.ArrayList;
import TDA.Alumno;

public class ListaAlumnos {
    ArrayList <Alumno> Lista;

    public Alumno crearAlumno() {
        Alumno aux = new Alumno();
        aux.setNumControl(Tools.validaCtrl("Ingresa No.Control"));
        aux.setNomAlum(Tools.validaNom("Ingresa el nombre"));
        aux.setEdadAlum(Tools.validaEdad("Ingresa la edad"));
        aux.setSemAlum(Tools.Semestre());
        return aux;
    }

    public ListaAlumnos () {
        Lista = new ArrayList<Alumno>();
    }

    public void añadir (Alumno datos) {

        Lista.add(datos);
    }

    public void eliminar (int pos) {
        Lista.remove(pos);
    }

    public boolean eliminarTodos () {
        return Lista.removeAll(Lista);
    }

    public void mostrar () {
        byte j;
        for (j = 0; j <= Lista.size() -1; j++) {
            System.out.println(Lista.get(j).toString());
        }
    }
}