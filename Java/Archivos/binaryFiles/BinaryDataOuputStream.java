/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binaryFiles;

/**
 *
 * @author pc
 */
  import java.io.*;
public class BinaryDataOuputStream {
  

 
    public static void main(String[] args) {
 
        try{
           
           FileOutputStream fo= new FileOutputStream("c:\\binario\\fich_binario.ddr");
           DataOutputStream dos=new DataOutputStream(fo);
           dos.writeInt(23);
           
           dos.writeInt(1990);
           dos.writeDouble(1.74);
           dos.writeChars("Lucero");
           dos.writeUTF("texto");
 
        }catch(IOException e){
            System.out.println("Error E/S");
        }
 
    }
 

}
