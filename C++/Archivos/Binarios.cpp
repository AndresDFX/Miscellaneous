/**
Muchos sistemas operativos distinguen entre ficheros de texto y ficheros binarios. Por ejemplo, en MS-DOS, los ficheros de texto sólo permiten almacenar caracteres.
En otros sistemas no existe tal distinción, todos los ficheros son binarios. En esencia esto es más correcto, puesto que un fichero de texto es un fichero binario con un rango limitado para los valores que puede almacenar.
En general, usaremos ficheros de texto para almacenar información que pueda o deba ser manipulada con un editor de texto. Un ejemplo es un fichero fuente C++. Los ficheros binarios son más útiles para guardar información cuyos valores no estén limitados. Por ejemplo, para almacenar imágenes, o bases de datos. Un fichero binario permite almacenar estructuras completas, en las que se mezclen datos de cadenas con datos numéricos.
En realidad no hay nada que nos impida almacenar cualquier valor en un fichero de texto, el problema surge cuando se almacena el valor que el sistema operativo usa para marcar el fin de fichero en un archivo de texto. En MS-DOS ese valor es 0x1A. Si abrimos un fichero en modo de texto que contenga un dato con ese valor, no nos será posible leer ningún dato a partir de esa posición. Si lo abrimos en modo binario, ese problema no existirá.
Los ficheros que hemos usado en los ejemplos anteriores son en modo texto, veremos ahora un ejemplo en modo binario:
**/

#include <iostream>
#include <fstream>
#include <cstring>

using namespace std;
 
struct tipoRegistro {
   char nombre[32];
   int edad;
   float altura;
};

int main() {
   tipoRegistro pepe;
   tipoRegistro pepe2;
   ofstream fsalida("prueba.dat", 
      ios::out | ios::binary);
   
   strcpy(pepe.nombre, "Jose Luis");
   pepe.edad = 32;
   pepe.altura = 1.78;
   
   fsalida.write(reinterpret_cast<char *>(&pepe), 
      sizeof(tipoRegistro));
   fsalida.close();

   ifstream fentrada("prueba.dat", 
      ios::in | ios::binary);
   
   fentrada.read(reinterpret_cast<char *>(&pepe2), 
      sizeof(tipoRegistro));
   cout << pepe2.nombre << endl;
   cout << pepe2.edad << endl;
   cout << pepe2.altura << endl;
   fentrada.close();

   return 0;
}