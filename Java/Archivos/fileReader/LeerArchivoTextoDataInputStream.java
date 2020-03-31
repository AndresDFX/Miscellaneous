
package fileReader;


import java.io.*;

class LeerArchivoTextoDataInputStream  {
    
    public static void main(String args[]) {
        try{
            // Abrimos el archivo
            FileInputStream fstream = new FileInputStream("c:\\Mapa.txt");
            // Creamos el objeto de entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creamos el Buffer de Lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            String strLinea;
            
            // Leer el archivo linea por linea
            while ((strLinea = buffer.readLine()) != null)   {
                // Imprimimos la línea por pantalla
                System.out.println (strLinea);
            }
                                  
            // Cerramos el archivo
            entrada.close();
        }catch (Exception e){ //Catch de excepciones
            System.err.println("Ocurrio un error: " + e.getMessage());
        }
    }
}
