
package escribirArchivoTexto;

/**
 *
 * @author pc
 */
import java.io.*;
 
public class EscribirArchivoTexto
{
    public static void main(String[] args)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try
        {
            fichero = new FileWriter("/home/invitado/Escritorio/pruebitaTexto.txt",true);
            pw = new PrintWriter(fichero);
 
            for (int i = 0; i < 100; i++)
                pw.println("Linea " + i);
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
}