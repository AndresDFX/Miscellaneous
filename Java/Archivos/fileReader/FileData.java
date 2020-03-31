/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fileReader;

import java.io.*;

/**
 *
 * @author USUARIO
 */
public class FileData {
    
    public static void main(String arg[]){
        
    double[] precios={1350, 400, 890, 6200, 8730};
    int[] unidades={5, 7, 12, 8, 30};
    DataInputStream mirar=null;
    DataOutputStream salida= null;
    
  //guardando datos al archivo
    try{
        salida=new DataOutputStream(new FileOutputStream("c://pedido.txt"));
       for (int i=0; i<unidades.length; i ++) {
           salida.writeInt(unidades[i]);
           salida.writeChar('\t');
           salida.writeDouble(precios[i]);
           
       }
       System.out.println("Se creó archivo");
       }catch(IOException ie){

       }finally{
           try{
             salida.close();
           }catch(IOException ioo){
               System.out.println("error al cerrar archivo");
           }
       }
    
    //Leyendo datos del archivo
    String valor;
    try{
        mirar= new DataInputStream(new FileInputStream("c://pedido.txt"));
        while(mirar.available() !=-1){
            System.out.println(mirar.readInt());
            System.out.println(mirar.readChar());
            System.out.println(mirar.readDouble());
        }
        
    }catch(IOException el){
        
    }

}
}
