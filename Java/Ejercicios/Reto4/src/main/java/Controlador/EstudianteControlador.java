package Controlador;

import Modelo.*;
import java.util.ArrayList;


public class EstudianteControlador {
    
    private EstudianteDAOImpDB  estudianteImp = EstudianteDTO.getEstudianteDAO();
    
    public boolean insertarEstudiante(Estudiante est) {
        return estudianteImp.insertarEstudiante(est);
    }
    
    public boolean actualizarEstudiante(Estudiante est) {
        return estudianteImp.actualizarEstudiante(est);
    }
    
    public boolean borrarEstudiante(Estudiante est) {
        return estudianteImp.borrarEstudiante(est);
    }
    
    public ArrayList<Estudiante> obtenerEstudiantesTodos(){
        return estudianteImp.obtenerEstudiantesTodos();
    }
    
    public int cantidadEstudiantesPrograma(String programa){
        return estudianteImp.cantidadEstudiantesPrograma(programa);
    }
    
    
    public ArrayList<Estudiante> obtenerEstudiantesPrograma(String programa){
        return estudianteImp.obtenerEstudiantesPrograma(programa);
    }

    public ArrayList<Estudiante> obtenerEstudiantesFechaNacimiento(String fechaNacimiento){
        return estudianteImp.obtenerEstudiantesFechaNacimiento(fechaNacimiento);
    }
    
    
    public Estudiante obtenerEstudianteCelular(long numeroCelular){
        return estudianteImp.obtenerEstudianteCelular(numeroCelular);
    }
    
        
    public Estudiante obtenerEstudianteCorreo(String correoInstitucional){
        return estudianteImp.obtenerEstudianteCorreo(correoInstitucional);
    }
    
    public Estudiante obtenerEstudianteApellidos(String apellidos){
        return estudianteImp.obtenerEstudianteApellidos(apellidos);
    }

}
