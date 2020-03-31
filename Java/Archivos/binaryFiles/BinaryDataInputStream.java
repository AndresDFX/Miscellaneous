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
public class BinaryDataInputStream {
 
    public static void main(String[] args) {
           
        try(
            DataInputStream dis=new DataInputStream(new FileInputStream("c:\\binario\\fich_binario.ddr"));){
 
            //Leemos un numero y lo mostramos
            System.out.println(dis.readInt());
 
            //Leemos una cadena y lo mostramos
            System.out.println(dis.readUTF());
 
            //Leemos un numero y lo mostramos
            System.out.println(dis.readInt());
 
        }catch(IOException e){
            System.out.println("Error E/S");
        }
        finally{
            
        }
 
    }
 
}
