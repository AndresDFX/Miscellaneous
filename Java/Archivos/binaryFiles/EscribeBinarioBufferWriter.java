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

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
 
public class EscribeBinarioBufferWriter {
    
    public static void main(String args[]) throws java.io.IOException {
        
        FileOutputStream fos = new FileOutputStream("c:\\binario\\datos1.dat");
       
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
         
        BufferedWriter salida = new BufferedWriter(osw);
        
        String texto = "á é í ó ú ñ €n";
        salida.write(texto);
        salida.flush();
        fos.close();
    }
}
