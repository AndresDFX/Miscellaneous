package chooser;

// Fig. 17.20: FileDemonstration.java
// Demonstrating JFileChooser.
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;


public class FileFilterChooser extends JFrame
{
   private JTextArea outputArea; // used for output
   private JScrollPane scrollPane; // used to provide scrolling to output
   
   // set up GUI
   public FileFilterChooser()
   {
      super( "Testing class File" );

      outputArea = new JTextArea();

      // add outputArea to scrollPane
      scrollPane = new JScrollPane( outputArea ); 

      add( scrollPane, BorderLayout.CENTER ); // add scrollPane to GUI

      setSize( 400, 400 ); // set GUI size
      setVisible( true ); // display GUI

      //analyzePath(); // create and analyze File object
      
      guardarArchivo();
   } // end FileDemonstration constructor

   // allow user to specify file or directory name
   private File getFileOrDirectory()
   {
      // display file dialog, so user can choose file or directory to open
      JFileChooser fileChooser = new JFileChooser();
       FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
       fileChooser.setFileFilter(filtro);
      fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );

      int result = fileChooser.showOpenDialog( this );

      // if user clicked Cancel button on dialog, return
      if ( result == JFileChooser.CANCEL_OPTION )
         System.exit( 1 );

      File fileName = fileChooser.getSelectedFile(); // get File

      // display error if invalid
      if ( ( fileName == null ) || ( fileName.getName().equals( "" ) ) )
      {
         JOptionPane.showMessageDialog( this, "Invalid Name",
            "Invalid Name", JOptionPane.ERROR_MESSAGE );
         System.exit( 1 );
      } // end if

      return fileName;
   } // end method getFile

   // display information about file or directory user specifies
   public void analyzePath()
   {
      // create File object based on user input
      File name = getFileOrDirectory();
      
      //formato de fecha 
      DateFormat df= DateFormat.getDateInstance(DateFormat.FULL);
    //  System.out.println("mirar el datedormat "+df.format(name.length()));

      if ( name.exists() ) // if name exists, output information about it
      {
         // display file (or directory) information
         outputArea.setText( String.format(
            "%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s",
            name.getName(), " exists",
            ( name.isFile() ? "is a file" : "is not a file" ),
            ( name.isDirectory() ? "is a directory" : 
               "is not a directory" ),
            ( name.isAbsolute() ? "is absolute path" : 
               "is not absolute path" ), "Last modified: ",
            df.format(name.lastModified()), "Length: ", name.length(), 
            "Path: ", name.getPath(), "Absolute path: ",
            name.getAbsolutePath(), "Parent: ", name.getParent() ) );

         
      } // end outer if
      else // not file or directory, output error message
      {
         JOptionPane.showMessageDialog( this, name +
            " does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE );
      } // end else  
   } // end method analyzePath
   
   
   private void guardarArchivo() {
 try
 {
  String nombre="";
  JFileChooser file=new JFileChooser();
  file.showSaveDialog(this);
  File guarda =file.getSelectedFile();
 
  if(guarda !=null)
  {
   /*guardamos el archivo y le damos el formato directamente,
    * si queremos que se guarde en formato doc lo definimos como .doc*/
    FileWriter  save=new FileWriter(guarda+".txt");
    outputArea.setText("Hola!!! \n esto es un texto que se va a guardar en un archivo de texto en una ubicación dada" );
    save.write(outputArea.getText());
    save.close();
    JOptionPane.showMessageDialog(null,
         "El archivo se a guardado Exitosamente",
             "Información",JOptionPane.INFORMATION_MESSAGE);
    }
 }
  catch(IOException ex)
  {
   JOptionPane.showMessageDialog(null,
        "Su archivo no se ha guardado",
           "Advertencia",JOptionPane.WARNING_MESSAGE);
  }
 }

   
   public static void main(String a[]){
       FileFilterChooser obf= new FileFilterChooser();
       
       obf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    }
   
   
} // end class FileDemonstration



/*************************************************************************
* (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
* Pearson Education, Inc. All Rights Reserved.                           *
*                                                                        *
* DISCLAIMER: The authors and publisher of this book have used their     *
* best efforts in preparing the book. These efforts include the          *
* development, research, and testing of the theories and programs        *
* to determine their effectiveness. The authors and publisher make       *
* no warranty of any kind, expressed or implied, with regard to these    *
* programs or to the documentation contained in these books. The authors *
* and publisher shall not be liable in any event for incidental or       *
* consequential damages in connection with, or arising out of, the       *
* furnishing, performance, or use of these programs.                     *
*************************************************************************/