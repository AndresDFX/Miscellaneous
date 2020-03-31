package internet;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class Internet {
    
    public static void main(String arg[]){
        InputStream is=null;
        InputStreamReader isr=null;
        BufferedReader br;
        String s,html="";
        
        try{
                URL direccion = new URL("http://docs.oracle.com/javase/7/docs/api/java/net/URL.html");
                is=direccion.openConnection().getInputStream();
                isr= new InputStreamReader(is);
                br= new BufferedReader(isr);
              
                while((s=br.readLine())!=null){
                    html+=br.readLine()+"\n"; 
                }
                System.out.println(html);
        }catch(IOException ex){
                ex.printStackTrace();
        }              
    }
}
