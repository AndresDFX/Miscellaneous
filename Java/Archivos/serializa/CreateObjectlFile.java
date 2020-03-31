package serializa;

// Fig. 17.16: CreateSequentialFile.java
// Writing objects sequentially to a file with class ObjectOutputStream.

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;


public class CreateObjectlFile
{
   private ObjectOutputStream output; // outputs data to file

   // allow user to specify file name
   public void openFile()
   {
      try // open file
      {
         output = new ObjectOutputStream(
            new FileOutputStream( "C:\\seria\\clients1.txt",true));
      } // end try
      catch ( IOException ioException )
      {
         System.err.println( "Error creating file" );
      } // end catch
   } // end method openFile

   // add records to file
   public void addRecords()
   {
      AccountRecordSerializable record; // object to be written to file
      int accountNumber = 0; // account number for record object
      String firstName; // first name for record object
      String lastName; // last name for record object
      double balance; // balance for record object
   for (int i = 0; i < 5; i++) {
      try // output values to file
      {
            accountNumber = 12; // read account number
            firstName = "Estudiante"; // read first name
            lastName = "Interactiva"; // read last name
            balance = 2.5; // read balance
            
            if ( accountNumber > 0 )
            {
               // create new record
               record = new AccountRecordSerializable( accountNumber,
                  firstName, lastName, balance );
               output.writeObject( record ); // output record
            } // end if
            else
            {
               System.out.println(
                  "Account number must be greater than 0." );
            } // end else
         } // end try
         catch ( IOException ioException )
         {
            System.err.println( "Error writing to file." );
            return;
         } // end catch
         catch ( NoSuchElementException elementException )
         {
            System.err.println( "Invalid input. Please try again." );
 //           input.nextLine(); // discard input so user can try again
            System.exit(1);
         } // end catch

         System.out.printf( "%s %s\n%s", "Enter account number (>0),",
            "first name, last name and balance.", "? " );
    } // end while
   } // end method addRecords

   // close file and terminate application 
   public void closeFile() 
   {
      try // close file
      {
         if ( output != null )
            output.close();
      } // end try
      catch ( IOException ioException )
      {
         System.err.println( "Error closing file." );
         System.exit( 1 );
      } // end catch
   } // end method closeFile
} // end class CreateSequentialFile

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