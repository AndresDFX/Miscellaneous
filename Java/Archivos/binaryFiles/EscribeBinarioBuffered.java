/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binaryFiles;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;

/**
 *
 * @author pc
 */
public class EscribeBinarioBuffered {
    
 

    public static void main(String args[]) throws java.io.IOException {
        
        FileOutputStream fos = new FileOutputStream("c:\\binario\\datos.dat",true);
         DataOutputStream dos=new DataOutputStream(fos);
        
        BufferedOutputStream salida=new BufferedOutputStream(dos);
     
        for (int i = 0; i < 512; i++) {
            salida.write(i);
        }
        salida.flush();
        fos.close();
    }
}

