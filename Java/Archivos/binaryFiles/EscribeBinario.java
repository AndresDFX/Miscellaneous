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

import java.io.File;
import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
 
public class EscribeBinario {
    public static void main(String args[]) throws java.io.IOException {
        File archivo=null;
        FileOutputStream salida=null;
        try{
            archivo= new File("c:\\binario\\datos.bin");
            salida = new FileOutputStream(archivo, true);
            for (int i = 0; i < 256; i++) {
                salida.write(i);
            }
        }
        catch(FileNotFoundException e){
                System.out.println(e + " " +  e.getStackTrace());
        }
        finally{
            salida.close();
        }
    }
}

