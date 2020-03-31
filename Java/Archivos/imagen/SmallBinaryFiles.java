/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imagen;

/**
 *
 * @author pc
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/** JDK 7+. */
public class SmallBinaryFiles {
  final static String FILE_NAME = "c:\\imagenes\\palanca.jpg";
  final static String OUTPUT_FILE_NAME = "c:\\imagenes\\palanca2.gif";
  
  public static void main(String... aArgs) throws IOException{
      
    SmallBinaryFiles binary = new SmallBinaryFiles();
    
    byte[] bytes = binary.readSmallBinaryFile(FILE_NAME);
    log("Small - size of file read in:" + bytes.length);
    binary.writeSmallBinaryFile(bytes, OUTPUT_FILE_NAME);
  }

  
  
  byte[] readSmallBinaryFile(String aFileName) throws IOException {
    Path path = Paths.get(aFileName);
    return Files.readAllBytes(path);
  }
  
  void writeSmallBinaryFile(byte[] aBytes, String aFileName) throws IOException {
    Path path = Paths.get(aFileName);
    Files.write(path, aBytes); //creates, overwrites
 
  }
  
  private static void log(Object aMsg){
    System.out.println(String.valueOf(aMsg));
  }
  
}  
