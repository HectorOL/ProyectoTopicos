package EntradaSalida;

import java.util.ArrayList;
import Main.Asistente;

public class Calcular {
    ArrayList <Asistente> lista;
    public Calcular(ArrayList<Asistente> lista){
        this.lista = lista;
    }

    public int total(){
        return lista.size();
    }

    public int mayorEdad(){
        int mayor = 0;
        for (Asistente Asistente : lista) {
            if(Asistente.getEdad() > 17){
                mayor++;
            }
        }
        return mayor;
    }

    public int menorEdad() {
        int menor = 0;
        for (Asistente Asistente : lista) {
            if(Asistente.getEdad() < 18){
                menor++;
            }
        }
        return menor;
    }

    public int totalHombres(){
        int total = 0;
        for (Asistente Asistente : lista) {
            if(Asistente.getSexo() == 'M'){
                total++;
            }
        }
        return total;
    }

    public int totalMujeres(){
        int total = 0;
        for (Asistente Asistente : lista) {
            if(Asistente.getSexo() == 'F'){
                total++;
            }
        }
        return total;
    }

    public int totalSolteros(){
        int total = 0;
        for (Asistente Asistente : lista) {
            if(Asistente.getEstadoCivil() == "soltero"){
                total++;
            }
        }
        return total;
    }

    public int totalCasados(){
        int total = 0;
        for (Asistente Asistente : lista) {
            if(Asistente.getEstadoCivil().equals("casado")){
                total++;
            }
        }
        return total;
    }

    public int totalViudos(){
        int total = 0;
        for (Asistente Asistente : lista) {
            if(Asistente.getEstadoCivil().equals("viudo")){
                total++;
            }
        }
        return total;
    }


    public int totalDivorciados(){
        int total = 0;
        for (Asistente Asistente : lista) {
            if(Asistente.getEstadoCivil().equals("divorciado")){
                total++;
            }
        }
        return total;
    }

    public float porcentajeHombres(){
        return ((totalHombres()/(float)total())*100);
    }

    public float porcentajeMujeres(){
        return ((totalMujeres()/(float)total())*100);
    }

    public String estadisticas(){
        return "Total de asistentes : " + total() +
                "\nNumero de Asistentes mayores de edad: " + mayorEdad() +
                "\nNumero de Asistentes menores de edad: " + menorEdad() +
                "\nTotal de Hombres: " + totalHombres() + 
                "\nTotal de Mujeres: " + totalMujeres() +
                "\nTotal de Solteros: " + totalSolteros() +
                "\nTotal de Casados: " + totalCasados() +
                "\nTotal de Viudos: " + totalViudos() +
                "\nTotal de Divorciados: " + totalDivorciados() +
                "\nPorcentaje de Hombres: " + ((Float.isNaN(porcentajeHombres()))? "0%" : String.format("%.2f%s", porcentajeHombres(), "%")) +
                "\nPorcentaje de Mujeres: " + ((Float.isNaN(porcentajeMujeres()))? "0%" : String.format("%.2f%s", porcentajeMujeres(), "%"));
    }
}
