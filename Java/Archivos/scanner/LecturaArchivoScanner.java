
package scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

 
public class LecturaArchivoScanner {
   
    public static void main(String[] args) {
        File f = new File("/home/invitado/Escritorio/texto.txt");
        Scanner entrada = null;
        
        try {
            entrada = new Scanner(f);
            while (entrada.hasNext()) {
                 System.out.println(entrada.nextInt());
                                
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally{
            entrada.close();
        }  
    }
}  

