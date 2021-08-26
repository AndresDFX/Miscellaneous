package Vista;

import Modelo.*;
import Controlador.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EstudianteVistaConsola {
    
    private EstudianteControlador estudianteControlador = EstudianteDTO.getEstudianteControlador();
    Scanner sc;

    public void menuPrincipal(){
        try{
            int opcion = 0;
            boolean salir = false;
            sc = new Scanner(System.in);

            while(!salir){
                System.out.println("INSTITUTO LA FLORESTA");
                System.out.println("Seleccione tarea a realizar:");
                System.out.println("1. Ingresar estudiante");
                System.out.println("2. Consultas");
                System.out.println("3. Modificar estudiante");
                System.out.println("4. Eliminar Estudiante");
                System.out.println("5. Ver directorio de estudiantes");
                System.out.println("6. Salir");
                System.out.println("Opción:");
                opcion = sc.nextInt();

                switch(opcion){
                    case 1:
                        insertarEstudiante();
                        break;
                    case 2:
                        submenuConsultas();
                        break;
                    case 3:
                        actualizarEstudiante();
                        break;
                    case 4:
                        borrarEstudiante();
                        break;
                    case 5:
                        obtenerEstudiantesTodos();
                        break;
                    case 6:
                        salir=true;
                        System.out.println("Hasta pronto");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Seleccione una opcion valida"); 
                }
            }
        }catch(InputMismatchException e){
            System.out.println("La opcion debe ser un numero");
            obtenerEstudianteApellidos();
        }
    }
    
    
    public void submenuConsultas() {
        try{
            int opcion = 0;
            boolean salir = false;
            sc = new Scanner(System.in);
            
            while(!salir){
                System.out.println("Consultas");
                System.out.println("Seleccione consulta a realizar:");
                System.out.println("1. Buscar estudiante por correo electrónico");
                System.out.println("2. Buscar estudiante por apellidos");
                System.out.println("3. Buscar por programa ");
                System.out.println("4. Buscar cantidad de estudiantes por programa ");
                System.out.println("5. Buscar por fecha de nacimiento ");
                System.out.println("6. Buscar por número de celular ");
                System.out.println("7. Volver al menu principal ");
                System.out.println("8. Salir ");
                System.out.println("Opción: ");
                System.out.println(opcion);
                opcion = sc.nextInt();

                switch(opcion){
                    case 1:
                        obtenerEstudianteCorreo();
                        break;
                    case 2:
                        obtenerEstudianteApellidos();
                        break;
                    case 3:
                        obtenerEstudiantesPrograma();
                        break;
                    case 4:
                        cantidadEstudiantesPrograma();
                        break;
                    case 5:
                        obtenerEstudiantesFechaNacimiento();
                        break;
                    case 6:
                        obtenerEstudianteCelular();
                        break;
                    case 7:
                        menuPrincipal();
                        break;   
                    case 8:
                        salir=true;
                        System.out.println("Hasta pronto");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Seleccione una opcion valida"); 
                }
            }
        }catch(InputMismatchException e){
            System.out.println("La opcion debe ser un numero");
            obtenerEstudianteApellidos();
        }
    }
    
    
    public void insertarEstudiante() {
        try{
            sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            Estudiante estudiante;
            String nombres, apellidos, fechaNacimiento, correoInstitucional, correoPersonal, programaAcademico;
            long numeroCelular, numeroFijo;
            boolean estado = false;

            System.out.println("Ingresar estudiante");
            System.out.println("Ingresar nombres:");
            nombres = sc.nextLine();
            System.out.println("Ingresar apellidos:");
            apellidos = sc.nextLine();
            System.out.println("Ingresar fecha de nacimiento (YYYY-MM-DD):");
            fechaNacimiento = sc.nextLine();
            System.out.println("Ingresar correo institucional:");
            correoInstitucional = sc.nextLine();
            System.out.println("Ingresar correo personal:");
            correoPersonal = sc.nextLine();
            System.out.println("Ingresar número de celular:");
            numeroCelular = sc.nextLong();
            System.out.println("Ingresar número fijo:");
            numeroFijo = sc.nextLong();
            System.out.println("Ingresar programa:");
            programaAcademico = sc.next();

            estudiante = new Estudiante(nombres, apellidos, fechaNacimiento, correoInstitucional, correoPersonal, numeroCelular, numeroFijo, programaAcademico); 
            estado = estudianteControlador.insertarEstudiante(estudiante);

            if(estado){
                System.out.println("Se agregó el estudiante");
            }else{
                System.out.println("No se pudo agregar el estudiante");
            }
        }catch(InputMismatchException e){
            System.out.println("Se ingreso un tipo de dato mal intente nuevamente");
            insertarEstudiante();
        }
        
    }
    
    public void actualizarEstudiante() {
        try{
            sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            Estudiante estudiante;
            String correoInstitucional, correoPersonal, programaAcademico;
            long numeroCelular, numeroFijo;

            System.out.println("Modificar estudiante");
            System.out.println("Ingresar correo institucional:");
            correoInstitucional = sc.nextLine();
            System.out.println("Ingresar correo personal:");
            correoPersonal = sc.nextLine();
            System.out.println("Ingresar número de celular:");
            numeroCelular = sc.nextLong();
            System.out.println("Ingresar número fijo:");
            numeroFijo = sc.nextLong();
            System.out.println("Ingresar programa:");
            programaAcademico = sc.next();

            estudiante = new Estudiante("", "", "", correoInstitucional, correoPersonal, numeroCelular, numeroFijo, programaAcademico); 
            boolean estado = estudianteControlador.actualizarEstudiante(estudiante);

            if(estado){
                System.out.println("Se modifico el estudiante");
            }else{
                System.out.println("No se pudo modificar el estudiante");
            }
        }catch(InputMismatchException e){
            System.out.println("Se ingreso un tipo de dato mal intente nuevamente");
            actualizarEstudiante();
        }
        
    }
    
    public void borrarEstudiante() {
        try{
            sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            Estudiante estudiante;
            String correoInstitucional;

            System.out.println("Eliminar estudiante");
            System.out.println("Ingresar correo institucional:");
            correoInstitucional = sc.next();


            estudiante = new Estudiante("", "", "", correoInstitucional, "", 123, 123, ""); 
            boolean estado = estudianteControlador.borrarEstudiante(estudiante);

            if(estado){
                System.out.println("Se eliminó el estudiante");
            }else{
                System.out.println("El estudiante no se encuentra registrado en el instituto");
            }
        }catch(InputMismatchException e){
            System.out.println("Se ingreso un tipo de dato mal intente nuevamente");
            borrarEstudiante();
        }
        
    }
    
    
    public void obtenerEstudiantesTodos(){
        ArrayList<Estudiante> estudiantes;
        estudiantes = estudianteControlador.obtenerEstudiantesTodos();
        if(estudiantes.size() != 0){
            System.out.println("El directorio de los estudiantes");
            for (int i=0; i<estudiantes.size(); i++){
                Estudiante estudianteActual = estudiantes.get(i);
                System.out.println("Nombres: "+ estudianteActual.getNombres());
                System.out.println("Apellidos: "+ estudianteActual.getApellidos());
                System.out.println("Fecha nacimiento: "+ estudianteActual.getFechaNacimiento());
                System.out.println("Correo institucional: "+ estudianteActual.getCorreoInstitucional());
                System.out.println("Correo personal: "+ estudianteActual.getCorreoPersonal());
                System.out.println("Número de teléfono celular: "+ estudianteActual.getNumeroCelular());
                System.out.println("Número de teléfono fijo: "+ estudianteActual.getNumeroFijo());
                System.out.println("Programa académico: "+ estudianteActual.getProgramaAcademico());
                System.out.println("");
            }
        }else{
            System.out.println("No hay estudiantes en el instituto");
        }
        
    }
    
    public void cantidadEstudiantesPrograma() {
        try{
            sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            String programaAcademico;
            int cantidad = 0;

            System.out.println("Cantidad estudiantes");
            System.out.println("Ingresar el programa academico:");
            programaAcademico = sc.next();
            cantidad = estudianteControlador.cantidadEstudiantesPrograma(programaAcademico);

            if(cantidad != 0){
                System.out.println("La cantidad de estudiantes del programa: "+cantidad);
            }else{
                System.out.println("No hay estudiantes en el programa");
            }
        }catch(InputMismatchException e){
            System.out.println("Se ingreso un tipo de dato mal intente nuevamente");
            cantidadEstudiantesPrograma();
        }
    }
    
    public void obtenerEstudiantesPrograma(){
        try{
            sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            String programaAcademico;
            ArrayList<Estudiante> estudiantes;
            System.out.println("Estudiantes por programa academico");
            System.out.println("Ingresar el programa academico:");
            programaAcademico = sc.next();
            estudiantes = estudianteControlador.obtenerEstudiantesPrograma(programaAcademico);
            if(estudiantes.size() != 0){
                System.out.println("El directorio de los estudiantes");
                for (int i=0; i<estudiantes.size(); i++){
                    Estudiante estudianteActual = estudiantes.get(i);
                    System.out.println(estudianteActual.getApellidos() + " " + estudianteActual.getNombres());
                    System.out.println("");
                }
            }else{
                System.out.println("No hay estudiantes en el programa");
            }
        }catch(InputMismatchException e){
            System.out.println("Se ingreso un tipo de dato mal intente nuevamente");
            obtenerEstudiantesPrograma();
        }
    }
        
    public void obtenerEstudiantesFechaNacimiento(){
        try{
            sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            String fechaNacimiento;
            ArrayList<Estudiante> estudiantes;
            System.out.println("Estudiantes por fecha de nacimiento");
            System.out.println("Ingresar la fecha de nacimiento:");
            fechaNacimiento = sc.next();
            estudiantes = estudianteControlador.obtenerEstudiantesFechaNacimiento(fechaNacimiento);
            if(estudiantes.size() != 0){
                System.out.println("El directorio de los estudiantes");
                for (int i=0; i<estudiantes.size(); i++){
                    Estudiante estudianteActual = estudiantes.get(i);
                    System.out.println(estudianteActual.getApellidos() + " " + estudianteActual.getNombres());
                    System.out.println("");
                }
            }else{
                System.out.println("No hay estudiantes con esa fecha de nacimiento");
            }
        }catch(InputMismatchException e){
            System.out.println("Se ingreso un tipo de dato mal intente nuevamente");
            obtenerEstudiantesFechaNacimiento();
        }
    }
    
    
    public void obtenerEstudianteCelular(){
        try{
            sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            long numeroCelular;
            Estudiante estudiante;
            System.out.println("Estudiante por numero celular");
            System.out.println("Ingresar el numero celular:");
            numeroCelular = sc.nextLong();
            estudiante = estudianteControlador.obtenerEstudianteCelular(numeroCelular);
            if(estudiante.getNumeroCelular() != 0){
                System.out.println("La informacion del estudiante");
                System.out.println(estudiante.getApellidos() + " " + estudiante.getNombres());
                System.out.println(""); 
            }else{
                System.out.println("No hay estudiante con ese numero celular");
            }
        }catch(InputMismatchException e){
            System.out.println("Se ingreso un tipo de dato mal intente nuevamente");
            obtenerEstudianteCelular();
        }
    }
    
    public void obtenerEstudianteCorreo(){
        try{
            sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            String correoInstitucional;
            Estudiante estudiante;
            System.out.println("Estudiante por correo institucional");
            System.out.println("Ingresar el correo institucional:");
            correoInstitucional = sc.next();
            estudiante = estudianteControlador.obtenerEstudianteCorreo(correoInstitucional);
            if(estudiante.getCorreoInstitucional() != null){
                System.out.println("La informacion del estudiante");
                System.out.println(estudiante.getApellidos() + " " + estudiante.getNombres());
                System.out.println(""); 
            }else{
                System.out.println("No hay estudiante con ese correo institucional");
            }
        }catch(InputMismatchException e){
            System.out.println("Se ingreso un tipo de dato mal intente nuevamente");
            obtenerEstudianteCorreo();
        }
    }
    
    
    public void obtenerEstudianteApellidos(){
        try{
            sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            String apellidos;
            Estudiante estudiante;
            System.out.println("Estudiante por apellidos");
            System.out.println("Ingresar los apellidos:");
            apellidos = sc.next();
            estudiante = estudianteControlador.obtenerEstudianteApellidos(apellidos);
            if(estudiante.getApellidos() != null){
                System.out.println("La informacion del estudiante");
                System.out.println(estudiante.getApellidos() + " " + estudiante.getNombres());
                System.out.println(""); 
            }else{
                System.out.println("No hay estudiante con esos apellidos");
            }
        }catch(InputMismatchException e){
            System.out.println("Se ingreso un tipo de dato mal intente nuevamente");
            obtenerEstudianteApellidos();
        }
    }

}
