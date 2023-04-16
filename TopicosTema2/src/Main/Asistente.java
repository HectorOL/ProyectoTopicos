package Main;

public class Asistente {
    private String nombre;
    private char sexo;
    private int edad;
    private String estadoCivil;

    public Asistente(String nombre, char sexo, int edad, String estadoCivil){
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.estadoCivil = estadoCivil.toLowerCase();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNombre() {
        return nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public int getEdad() {
        return edad;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    @Override
    public String toString() {
        return("Nombre: " + this.nombre + "\n" +
        "Edad: " + this.edad + "\n" +
        "Sexo: " + (this.sexo == 'H' ? "Masculino" : "Femenino") + "\n" +
        "Estado Civil: " + this.estadoCivil + "\n" 
        );
    }

    public String getDatos(){
        return(this.nombre + 
        " " + this.edad + 
        " " + (this.sexo == 'M' ? "Masculino" : "Femenino") + 
        " " + this.estadoCivil);
    }
}
