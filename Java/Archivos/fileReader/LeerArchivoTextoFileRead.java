/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fileReader;


/**
 *
 * @author pc
 */
import java.io.*;
class LeerArchivoTextoFileRead  {
    
        
  public static void main(String [] arg) {
      
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
     
     try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("c://prueba.txt");
         archivo = new File ("/home/invitado/Escritorio/texto.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
                 
      
         // Lectura del fichero
         String linea="";
              
//         while((fr.read())!=-1){
//                  System.out.println(fr.read());
//         }
         
       while((linea=br.readLine())!=null){
           String arreglo[] = linea.split("-");
           System.out.println("tamaño del arreglo"+arreglo.length);
           
           for (int i = 0; i < arreglo.length; i++) {
               System.out.println(arreglo[i]);              
           }
            
      }
     }catch(IOException e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si aparece
         // una excepcion.
         try{                   
            if( null != fr ){  
               fr.close();    
            }                 
         }catch (Exception e2){
            e2.printStackTrace();
         }
      }
   }
}