package Modelo;

public class Estudiante {
    
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private String correoInstitucional;
    private String correoPersonal;
    private long numeroCelular;
    private long numeroFijo;
    private String programaAcademico;
    
    public Estudiante(){
    }
    

    public Estudiante(String nombres, String apellidos, String fechaNacimiento, String correoInstitucional, String correoPersonal, long numeroCelular, long numeroFijo, String programaAcademico) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.correoInstitucional = correoInstitucional;
        this.correoPersonal = correoPersonal;
        this.numeroCelular = numeroCelular;
        this.numeroFijo = numeroFijo;
        this.programaAcademico = programaAcademico;
    }
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public long getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(long numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public long getNumeroFijo() {
        return numeroFijo;
    }

    public void setNumeroFijo(long numeroFijo) {
        this.numeroFijo = numeroFijo;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + ", correoInstitucional=" + correoInstitucional + ", correoPersonal=" + correoPersonal + ", numeroCelular=" + numeroCelular + ", numeroFijo=" + numeroFijo + ", programaAcademico=" + programaAcademico + '}';
    }
    
    
}
