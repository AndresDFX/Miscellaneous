package Modelo;

import Controlador.Control;


public class Paciente extends Persona{
    
    private int cedulaMedico;
    private String diagnostico;
    private String sintomas;
    String Staphylococcus_aureus = "diarrea,dolorabdominal,fiebre,nauseas,vomitos,";
    String Bacillus_cereus = "nauseas,vomitos,";
    String Taenia_saginata = "dolorabdominal,fiebre,";
    String Norovirus = "diarrea,fiebre,nauseas,vomitos,";
    String Rotavirus = "diarrea,vomitos,";
    

    public Paciente(String nombre, int numeroCedula, int cedulaMedico, String diagnostico, String sintomas) {
        super(nombre, numeroCedula);
        this.cedulaMedico = cedulaMedico;
        this.diagnostico = diagnostico;
        this.sintomas = sintomas;
    }
    
 
    public int getCedulaMedico() {
        return cedulaMedico;
    }

    public void setCedulaMedico(int cedulaMedico) {
        this.cedulaMedico = cedulaMedico;
    }
    
        public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public void diagnosticar(String sintomas, int posicion){
        if(sintomas.equalsIgnoreCase(Staphylococcus_aureus)){
            Control.cuentaEnfermedades[0] += 1;
            Control.pacientes.get(posicion).setDiagnostico("Staphylococcus aureus");        
        }
        else if(sintomas.equalsIgnoreCase(Bacillus_cereus)){
            Control.cuentaEnfermedades[1] += 1;
            Control.pacientes.get(posicion).setDiagnostico("Bacillus cereus");
        }
        else if(sintomas.equalsIgnoreCase(Taenia_saginata)){
            Control.cuentaEnfermedades[2] += 1;
            Control.pacientes.get(posicion).setDiagnostico("Taenia saginata");
        }
        else if(sintomas.equalsIgnoreCase(Norovirus)){
            Control.cuentaEnfermedades[3] += 1;
            Control.pacientes.get(posicion).setDiagnostico("Norovirus");
        }
        else if(sintomas.equalsIgnoreCase(Rotavirus)){
            Control.cuentaEnfermedades[4] += 1;
            Control.pacientes.get(posicion).setDiagnostico("Rotavirus");
        }
        else{
            Control.cuentaEnfermedades[5] += 1;
            Control.pacientes.get(posicion).setDiagnostico("Sin");
        }
        
    }
    
    
    
}
