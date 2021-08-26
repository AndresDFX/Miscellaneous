package Modelo;
import java.util.ArrayList;


public interface EstudianteDAO {
        boolean insertarEstudiante(Estudiante est);
        boolean actualizarEstudiante(Estudiante est);
        boolean borrarEstudiante(Estudiante est);
        boolean existeEstudiante(Estudiante est);
        int cantidadEstudiantesPrograma(String programa);
        Estudiante obtenerEstudianteCelular(long numeroCelular);
	Estudiante obtenerEstudianteCorreo(String correoInstitucional);
        Estudiante obtenerEstudianteApellidos(String apellidos);
        ArrayList<Estudiante> obtenerEstudiantesTodos();
        ArrayList<Estudiante> obtenerEstudiantesPrograma(String programa);
	ArrayList<Estudiante> obtenerEstudiantesFechaNacimiento(String fechaNacimiento);
        
        
        
}
    

