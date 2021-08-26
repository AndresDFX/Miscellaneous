package Modelo;

import Vista.*;
import Controlador.*;


public class EstudianteDTO {

	public static Estudiante getEstudiante() {
            return new Estudiante();
	}
	
	public static EstudianteDAOImpDB getEstudianteDAO(){
		return new EstudianteDAOImpDB();
	}
	
	public static EstudianteControlador getEstudianteControlador() {
		return new EstudianteControlador();
	}
	
	public static EstudianteVistaConsola getEstudianteVista() {
		return new EstudianteVistaConsola();
	}
}
