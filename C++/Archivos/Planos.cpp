/**
Usar streams facilita mucho el acceso a ficheros en disco, veremos que una vez que creemos un stream para un fichero, podremos trabajar con él igual que lo hacemos con cin o cout.
Mediante las clases ofstream, ifstream y fstream tendremos acceso a todas las funciones de las clases base de las que se derivan estas: ios, istream, ostream, fstreambase, y como también contienen un objeto filebuf, podremos acceder a las funciones de filebuf y streambuf.
En apendice E hay una referencia bastante completa de las clases estándar de entrada y salida.
Evidentemente, muchas de estas funciones puede que nunca nos sean de utilidad, pero algunas de ellas se usan con frecuencia, y facilitan mucho el trabajo con ficheros.

*/

#include <iostream>
#include <fstream>
using namespace std;

int main() {
   char cadena[128];
   // Crea un fichero de salida
   ofstream fs("nombre.txt"); 

   // Enviamos una cadena al fichero de salida:
   fs << "Hola, mundo" << endl;
   // Cerrar el fichero, 
   // para luego poder abrirlo para lectura:
   fs.close();

   // Abre un fichero de entrada
   ifstream fe("nombre.txt"); 

   // Leeremos mediante getline, si lo hiciéramos 
   // mediante el operador << sólo leeríamos 
   // parte de la cadena:
   fe.getline(cadena, 128);

   cout << cadena << endl;

   return 0;
}