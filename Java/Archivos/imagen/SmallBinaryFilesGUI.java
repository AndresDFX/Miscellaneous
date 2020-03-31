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
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

/** JDK 7+. */
public class SmallBinaryFilesGUI extends JFrame implements ActionListener{
    
    JComboBox combo;
    JTextField campo;
    MiPanel panel;
    static String FILE_NAME = "c:\\imagenes\\imagenC.jpg";
    static String OUTPUT_FILE_NAME="";
    
    
    public SmallBinaryFilesGUI(){
        
        panel= new MiPanel(new ImageIcon(getClass().getResource("javaFondo.png")).getImage());
        combo= new JComboBox();
        combo.addItem("PNG");
        combo.addItem("ICO");
        combo.addItem("GIF");
        combo.addItem("BIN");
        
        campo= new JTextField("El archivo se convirtuó a: ");
        panel.add(combo, BorderLayout.NORTH);
        panel.add(campo, BorderLayout.SOUTH);
                
        combo.addActionListener(this);
        
        getContentPane().add(panel);
        pack();
        setVisible(true);
    }
    
  
  
  public static void main(String aArgs[]) {
    SmallBinaryFilesGUI binary = new SmallBinaryFilesGUI();
   // byte[] bytes = binary.readSmallBinaryFile(FILE_NAME);
    //log("Small - size of file read in:" + bytes.length);
   // binary.writeSmallBinaryFile(bytes, OUTPUT_FILE_NAME);
    binary.setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  
  
  byte[] readSmallBinaryFile(String aFileName) throws IOException {
    Path path = Paths.get(aFileName);
    return Files.readAllBytes(path);
  }
  
  void writeSmallBinaryFile(byte[] aBytes, String aFileName) throws IOException {
    Path path = Paths.get(aFileName);
    Files.write(path, aBytes); //creates, overwrites
 
  }
  
//  private static void log(Object aMsg){
//    System.out.println(String.valueOf(aMsg));
//  }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(combo.getSelectedItem().equals("PNG")){
            OUTPUT_FILE_NAME = "c:\\imagenes\\imagenPng.png";
            try{
                 byte[] bytes = readSmallBinaryFile(FILE_NAME);
                 writeSmallBinaryFile(bytes, OUTPUT_FILE_NAME);
         
            }catch(IOException e){
                e.printStackTrace();
            }
        campo.setText("convertido a png");
        }
        if(combo.getSelectedItem().equals("ICO")){
            OUTPUT_FILE_NAME = "c:\\imagenes\\imagenIco.ico";
            try{
                 byte[] bytes = readSmallBinaryFile(FILE_NAME);
                 writeSmallBinaryFile(bytes, OUTPUT_FILE_NAME);
         
            }catch(IOException e){
                e.printStackTrace();
            }
            campo.setText("convertido a ico");
        }
        if(combo.getSelectedItem().equals("GIF")){
            OUTPUT_FILE_NAME = "c:\\imagenes\\imagenGif.gif";
            try{
                 byte[] bytes = readSmallBinaryFile(FILE_NAME);
                 writeSmallBinaryFile(bytes, OUTPUT_FILE_NAME);
         
            }catch(IOException e){
                e.printStackTrace();
            }
            campo.setText("convertido a gif");
        }
        if(combo.getSelectedItem().equals("BIN")){
            OUTPUT_FILE_NAME = "c:\\imagenes\\imagenBin.bin";
            try{
                 byte[] bytes = readSmallBinaryFile(FILE_NAME);
                 writeSmallBinaryFile(bytes, OUTPUT_FILE_NAME);
         
            }catch(IOException e){
                e.printStackTrace();
            }
            campo.setText("convertido a Bin");
        }
    }
  
}  
