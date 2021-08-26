package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    

    private final String driver = "com.mysql.jdbc.Driver";
    protected final String usuario = "root";
    protected final String password = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/bd_estudiantes";
    private Connection conexion = null;
    
//=======================================================================================================    

    public Connection conectarBD()
    {
            try {
                Class.forName(driver);
                //System.out.println( "Driver Cargado" );
            } 
            catch( ClassNotFoundException e ) {
                System.out.println( "No se pudo cargar el driver: "+e.getMessage());
            }

            try{               
                conexion = DriverManager.getConnection(URL, usuario, password);
                //System.out.println("Conexion Abierta" );
                return conexion;
             } 
            
            catch( SQLException e ) 
            {
                System.out.println( "No se pudo abrir la bd: "+e.getMessage() );
                return null;
            }

    }
//=======================================================================================================    

    public Connection getConnetion()
    {
        if (conexion == null) 
        {
            return this.conectarBD();
        }
        
        else
        {
            return conexion;      
        }            
    }
//=======================================================================================================    
}

