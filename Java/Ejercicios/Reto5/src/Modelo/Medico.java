
package Modelo;

import Controlador.Control;
import java.util.ArrayList;


public class Medico extends Persona{
    
    public Medico(String nombre, int numeroCedula) {
        super(nombre, numeroCedula);
    }
    

    
    public ArrayList<Paciente> pacientes (){
        ArrayList<Paciente> pacientes = Control.pacientes;
        ArrayList<Paciente> pacientesAtendidos = new ArrayList<>();

        for(int i=0; i<pacientes.size(); i++){
           if(pacientes.get(i).getCedulaMedico() == super.getNumeroCedula()){
               pacientesAtendidos.add(pacientes.get(i));
           }
        }
        return pacientesAtendidos;       
    }
    
}
