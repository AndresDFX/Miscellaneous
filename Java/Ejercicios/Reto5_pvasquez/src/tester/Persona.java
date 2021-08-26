package tester;

public class Persona {

    private String nombre;
    private int numeroCedula;
    
    public Persona(String nombre, int numeroCedula) {
        this.nombre = nombre;
        this.numeroCedula = numeroCedula;
    }

    public int getNumeroCedula() {
        return numeroCedula;
    }

    public void setNumeroCedula(int numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    
    
    
}
