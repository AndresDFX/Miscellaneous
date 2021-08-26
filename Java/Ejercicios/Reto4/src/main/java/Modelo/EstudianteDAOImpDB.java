package Modelo;

import java.sql.*;
import java.util.ArrayList;


public class EstudianteDAOImpDB implements EstudianteDAO{
    
    private Conexion fachada;
    
    public EstudianteDAOImpDB()
    {
        fachada = new Conexion();
    }

    @Override
    public boolean insertarEstudiante(Estudiante est) {
        String sql = "INSERT INTO estudiante VALUES(?,?,?,?,?,?,?,?)";
        boolean existe = existeEstudiante(est);
        
        if(existe == false){
            try {
                Connection conexion = fachada.getConnetion();
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                sentencia.setString(1, est.getNombres());
                sentencia.setString(2, est.getApellidos());
                sentencia.setString(3, est.getFechaNacimiento());
                sentencia.setString(4, est.getCorreoInstitucional());
                sentencia.setString(5, est.getCorreoPersonal());
                sentencia.setLong(6, est.getNumeroCelular());
                sentencia.setLong(7, est.getNumeroFijo());
                sentencia.setString(8, est.getProgramaAcademico()); 
                int resultado = sentencia.executeUpdate();
                if(resultado == 1){
                    return true;
                }
            } catch (SQLException e) {
                System.out.println("Error en el metodo insertarEstudiante-DaoDB: " +e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean actualizarEstudiante(Estudiante est) {
        String sql = "UPDATE estudiante SET "
                + "correoPersonal = ?, numeroCelular = ?, numeroFijo =?, programaAcademico = ? "
                + "WHERE correoInstitucional = ?;";
        boolean existe = existeEstudiante(est); 
        if(existe == true){
            try {
                Connection conexion = fachada.getConnetion();
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                sentencia.setString(1, est.getCorreoPersonal());
                sentencia.setLong(2, est.getNumeroCelular());
                sentencia.setLong(3, est.getNumeroFijo());
                sentencia.setString(4, est.getProgramaAcademico());
                sentencia.setString(5, est.getCorreoInstitucional());
                
                int resultado = sentencia.executeUpdate();
                if(resultado == 1){
                    return true;
                }
            } catch (SQLException e) {
                System.out.println("Error en el metodo actualizarEstudiante-DaoDB: " +e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean borrarEstudiante(Estudiante est) {
        String sql = "DELETE FROM estudiante " 
                    + "WHERE correoInstitucional = ?;";
        boolean existe = existeEstudiante(est); 
        if(existe == true){
            try {
                Connection conexion = fachada.getConnetion();
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                sentencia.setString(1, est.getCorreoInstitucional()); 
                int resultado = sentencia.executeUpdate();
                if(resultado == 1){
                    return true;
                }
            } catch (SQLException e) {
                System.out.println("Error en el metodo borrarEstudiante-DaoDB: " +e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean existeEstudiante(Estudiante est) {
        String sql = "SELECT * FROM estudiante WHERE correoInstitucional = ?";
        try {
            Connection conexion = fachada.getConnetion();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, est.getCorreoInstitucional());
            ResultSet resultado = sentencia.executeQuery();
            if(resultado.next()){
                return true;
            }           
        } catch (SQLException e) {
            System.out.println("Error en el metodo existeEstudiante-DaoDB:" + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return false; 
    }

    @Override
    public int cantidadEstudiantesPrograma(String programa) {
        String sql = "SELECT count(*) AS cuenta FROM estudiante WHERE programaAcademico = ?";
        try {
            Connection conexion = fachada.getConnetion();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, programa);
            ResultSet resultado = sentencia.executeQuery();
            if(resultado.next()){
                int cantidad = resultado.getInt("cuenta");
                return cantidad;
            }           
        } catch (SQLException e) {
            System.out.println("Error en el metodo cantidadEstudiantesPrograma-DaoDB:" + e.getMessage());
            e.printStackTrace();
            return 0;
        }
        return 0; 
    }

    @Override
    public Estudiante obtenerEstudianteCelular(long numeroCelular) {
        String sql = "SELECT * FROM estudiante WHERE numeroCelular = ?;";
        Estudiante estudiante = new Estudiante();
        try {
            Connection conexion = fachada.getConnetion();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setLong(1, numeroCelular);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()) {
                estudiante = EstudianteDTO.getEstudiante();
                estudiante.setNombres(resultado.getString("nombres"));
                estudiante.setApellidos(resultado.getString("apellidos"));
                estudiante.setFechaNacimiento(resultado.getString("fechaNacimiento"));
                estudiante.setCorreoInstitucional(resultado.getString("correoInstitucional"));
                estudiante.setCorreoPersonal(resultado.getString("correoPersonal"));
                estudiante.setNumeroCelular(resultado.getLong("numeroCelular"));
                estudiante.setNumeroFijo(resultado.getLong("numeroFijo"));
                estudiante.setProgramaAcademico(resultado.getString("programaAcademico"));
            }
        }catch (SQLException e) {
            System.out.println("Error en el metodo obtenerEstudianteCelular-DaoDB: " +e.getMessage());
            e.printStackTrace();
            return estudiante;
        }
        return estudiante;
    }

    @Override
    public Estudiante obtenerEstudianteCorreo(String correoInstitucional) {
        String sql = "SELECT * FROM estudiante WHERE correoInstitucional = ?;";
        Estudiante estudiante = new Estudiante();
        try {
            Connection conexion = fachada.getConnetion();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, correoInstitucional);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()) {
                estudiante = EstudianteDTO.getEstudiante();
                estudiante.setNombres(resultado.getString("nombres"));
                estudiante.setApellidos(resultado.getString("apellidos"));
                estudiante.setFechaNacimiento(resultado.getString("fechaNacimiento"));
                estudiante.setCorreoInstitucional(resultado.getString("correoInstitucional"));
                estudiante.setCorreoPersonal(resultado.getString("correoPersonal"));
                estudiante.setNumeroCelular(resultado.getLong("numeroCelular"));
                estudiante.setNumeroFijo(resultado.getLong("numeroFijo"));
                estudiante.setProgramaAcademico(resultado.getString("programaAcademico"));
            }
        }catch (SQLException e) {
            System.out.println("Error en el metodo obtenerEstudianteCorreo-DaoDB: " +e.getMessage());
            e.printStackTrace();
            return estudiante;
        }
        return estudiante;
    }

    @Override
    public Estudiante obtenerEstudianteApellidos(String apellidos) {
        String sql = "SELECT * FROM estudiante WHERE apellidos = ?;";
        Estudiante estudiante = new Estudiante();
        try {
            Connection conexion = fachada.getConnetion();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, apellidos);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()) {
                estudiante = EstudianteDTO.getEstudiante();
                estudiante.setNombres(resultado.getString("nombres"));
                estudiante.setApellidos(resultado.getString("apellidos"));
                estudiante.setFechaNacimiento(resultado.getString("fechaNacimiento"));
                estudiante.setCorreoInstitucional(resultado.getString("correoInstitucional"));
                estudiante.setCorreoPersonal(resultado.getString("correoPersonal"));
                estudiante.setNumeroCelular(resultado.getLong("numeroCelular"));
                estudiante.setNumeroFijo(resultado.getLong("numeroFijo"));
                estudiante.setProgramaAcademico(resultado.getString("programaAcademico"));
            }
        }catch (SQLException e) {
            System.out.println("Error en el metodo obtenerEstudianteApellidos-DaoDB: " +e.getMessage());
            e.printStackTrace();
            return estudiante;
        }
        return estudiante;
    }

    @Override
    public ArrayList<Estudiante> obtenerEstudiantesTodos() {
        String sql = "SELECT * FROM estudiante;";
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        try {
            Connection conexion = fachada.getConnetion();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()) {
                Estudiante estudiante = EstudianteDTO.getEstudiante();
                estudiante.setNombres(resultado.getString("nombres"));
                estudiante.setApellidos(resultado.getString("apellidos"));
                estudiante.setFechaNacimiento(resultado.getString("fechaNacimiento"));
                estudiante.setCorreoInstitucional(resultado.getString("correoInstitucional"));
                estudiante.setCorreoPersonal(resultado.getString("correoPersonal"));
                estudiante.setNumeroCelular(resultado.getLong("numeroCelular"));
                estudiante.setNumeroFijo(resultado.getLong("numeroFijo"));
                estudiante.setProgramaAcademico(resultado.getString("programaAcademico"));
                estudiantes.add(estudiante);
            }
        }catch (SQLException e) {
            System.out.println("Error en el metodo obtenerEstudiantesTodos-DaoDB: " +e.getMessage());
            e.printStackTrace();
            return estudiantes;
        }
        return estudiantes;
    }

    @Override
    public ArrayList<Estudiante> obtenerEstudiantesPrograma(String programa) {
        String sql = "SELECT * FROM estudiante WHERE programaAcademico = ?;";
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        try {
            Connection conexion = fachada.getConnetion();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, programa);
            ResultSet resultado = sentencia.executeQuery();
            
            while(resultado.next()) {
                Estudiante estudiante = EstudianteDTO.getEstudiante();
                estudiante.setNombres(resultado.getString("nombres"));
                estudiante.setApellidos(resultado.getString("apellidos"));
                estudiante.setFechaNacimiento(resultado.getString("fechaNacimiento"));
                estudiante.setCorreoInstitucional(resultado.getString("correoInstitucional"));
                estudiante.setCorreoPersonal(resultado.getString("correoPersonal"));
                estudiante.setNumeroCelular(resultado.getLong("numeroCelular"));
                estudiante.setNumeroFijo(resultado.getLong("numeroFijo"));
                estudiante.setProgramaAcademico(resultado.getString("programaAcademico"));
                estudiantes.add(estudiante);
            }
         
        } catch (SQLException e) {
            System.out.println("Error en el metodo obtenerEstudiantesPrograma-DaoDB:" + e.getMessage());
            e.printStackTrace();
            return estudiantes;
        }
        return estudiantes;    
    }
    
    @Override
    public ArrayList<Estudiante> obtenerEstudiantesFechaNacimiento(String fechaNacimiento) {
        String sql = "SELECT * FROM estudiante WHERE fechaNacimiento = ?;";
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        try {
            Connection conexion = fachada.getConnetion();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, fechaNacimiento);
            ResultSet resultado = sentencia.executeQuery();
            
            while(resultado.next()) {
                Estudiante estudiante = EstudianteDTO.getEstudiante();
                estudiante.setNombres(resultado.getString("nombres"));
                estudiante.setApellidos(resultado.getString("apellidos"));
                estudiante.setFechaNacimiento(resultado.getString("fechaNacimiento"));
                estudiante.setCorreoInstitucional(resultado.getString("correoInstitucional"));
                estudiante.setCorreoPersonal(resultado.getString("correoPersonal"));
                estudiante.setNumeroCelular(resultado.getLong("numeroCelular"));
                estudiante.setNumeroFijo(resultado.getLong("numeroFijo"));
                estudiante.setProgramaAcademico(resultado.getString("programaAcademico"));
                estudiantes.add(estudiante);
            }
         
        } catch (SQLException e) {
            System.out.println("Error en el metodo obtenerEstudiantesFechaNacimiento-DaoDB:" + e.getMessage());
            e.printStackTrace();
            return estudiantes;
        }
        return estudiantes;    
    }


}
