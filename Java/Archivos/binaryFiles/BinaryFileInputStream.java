/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binaryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class BinaryFileInputStream {
  
   public static void main(String[] args) { 
	File file = new File("c:\\binario\\datos.bin");
 	try (
                FileInputStream fis = new FileInputStream(file)) {
 		System.out.println("Total file size to read (in bytes) : "+ fis.available());
 
		int content;
		while ((content = fis.read()) != -1) {
			
		   System.out.println((char) content );
		}
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

