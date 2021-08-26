
package Controlador;

import Modelo.Medico;
import Modelo.Paciente;
import java.util.ArrayList;


public class Control {
      
    public static ArrayList<Medico> medicos = new ArrayList<>();
    public static ArrayList<Paciente> pacientes = new ArrayList<>();
    public static int[] cuentaEnfermedades = {0,0,0,0,0,0};
    public static String[] listaEnfermedades = {"Staphylococcus aureus",  "Bacillus cereus", 
                                                "Taenia_saginata", "Norovirus", "Rotavirus"};
    
    public static String diagnosticoMasComun(){
        int valorTemporal = cuentaEnfermedades[0];
        int posicion = 0;
        for(int i=1; i<cuentaEnfermedades.length; i++){
            if(cuentaEnfermedades[i]>valorTemporal){
                valorTemporal = cuentaEnfermedades[i];
                posicion = i;
            }
        }
        return listaEnfermedades[posicion];
    }
    
    
    public static String diagnosticoPorPaciente(){
        String cadena = "";
        for(int i=0; i<pacientes.size(); i++){
            if(!pacientes.get(i).getDiagnostico().equals("Sin")){
                cadena += pacientes.get(i).getNombre() + " " + pacientes.get(i).getDiagnostico() +"\n";
            }
        }
        return cadena;
    }
    
    
    public static int pacientesSinDiagnostico(){
        return cuentaEnfermedades[5];
    }
    
    
    
}
