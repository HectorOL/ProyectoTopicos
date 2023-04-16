package TDA;

public class Alumno {
    private String numControl;
    private String nomAlum;
    private byte semAlum;
    private  byte edadAlum;

    public Alumno() {
    }

    public Alumno(String numControl, String nomAlum, byte semAlum, byte edadAlum) {
        this.numControl = numControl;
        this.nomAlum = nomAlum;
        this.semAlum = semAlum;
        this.edadAlum = edadAlum;
    }

    public String getNumControl() {
        return numControl;
    }

    public void setNumControl(String numControl) {
        this.numControl = numControl;
    }

    public String getNomAlum() {
        return nomAlum;
    }

    public void setNomAlum(String nomAlum) {
        this.nomAlum = nomAlum;
    }

    public byte getSemAlum() {
        return semAlum;
    }

    public void setSemAlum(byte semAlum) {
        this.semAlum = semAlum;
    }

    public byte getEdadAlum() {
        return edadAlum;
    }

    public void setEdadAlum(byte edadAlum) {
        this.edadAlum = edadAlum;
    }

    @Override
    public String toString() {
        return "Alumno:\n" +
                "No.Control: " + numControl + "\n" +
                "Nombre: " + nomAlum + "\n" +
                "Semestre: " + semAlum + "\n"+
                "Edad: " + edadAlum + "\n";
    }
}