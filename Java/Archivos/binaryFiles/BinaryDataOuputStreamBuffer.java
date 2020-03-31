/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binaryFiles;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author pc
 */
public class BinaryDataOuputStreamBuffer {
    public static void main(String[] args) {
 
        try(
                DataOutputStream dos=new DataOutputStream(new FileOutputStream("c:\\binario\\fich_binario.ddr"));){
 
            //Escribimos un numero
            dos.writeInt(23);
 
            //Escribimos una cadena
            dos.writeUTF("comunicación");
 
            //Escribimos un numero
            dos.writeInt(1990);
            
                       
        }catch(IOException e){
            System.out.println("Error E/S");
        }
 
    }
 
}
