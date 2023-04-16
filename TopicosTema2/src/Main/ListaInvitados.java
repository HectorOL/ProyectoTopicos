package Main;

import java.util.ArrayList;

public class ListaInvitados {
    private ArrayList <Asistente> lista;

    public ArrayList<Asistente> getLista() {
        return lista;
    }

    public ListaInvitados(){
        lista = new ArrayList<>();       
    }
    
    public void añadir(Asistente alu){
        lista.add(alu);
    }
    
    public void eliminar(int pos){
        lista.remove(pos);
    }
    
    public void eliminarTodos(){
        lista.removeAll(lista);
    }
    
    public void mostrar(){
        for (Asistente persona : lista) {
            System.out.println(persona.toString());
        }
    }
}
