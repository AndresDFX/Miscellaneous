/**
Hasta ahora sólo hemos trabajado con los ficheros secuencialmente, es decir, empezamos a leer o a escribir desde el principio, y avanzamos a medida que leemos o escribimos en ellos.
Otra característica importante de los ficheros es la posibilidad de trabajar con ellos haciendo acceso aleatorio, es decir, poder hacer lecturas o escrituras en cualquier punto del fichero. Para eso disponemos de las funciones seekp y seekg, que permiten cambiar la posición del fichero en la que se hará la siguiente escritura o lectura. La 'p' es de put y la 'g' de get, es decir escritura y lectura, respectivamente.
Otro par de funciones relacionadas con el acceso aleatorio son tellp y tellg, que sirven para saber en qué posición del fichero nos encontramos
 **/

#include <fstream>
#include <iostream>

using namespace std;
 
int main() {
   int i;
   int pos;
   char mes[][20] = {"Enero", "Febrero", "Marzo", 
      "Abril", "Mayo", "Junio", "Julio", "Agosto", 
      "Septiembre", "Octubre", "Noviembre", 
      "Diciembre"};
   char cad[20];
      
   ofstream fsalida("meses.dat", 
      ios::out | ios::binary);
   
   // Crear fichero con los nombres de los meses:
   cout << "Crear archivo de nombres de meses:" << endl;
   for(i = 0; i < 12; i++)
      fsalida.write(mes[i], 20);
   fsalida.close();

   ifstream fentrada("meses.dat", ios::in | ios::binary);
   
   // Acceso secuencial:
   cout << "\nAcceso secuencial:" << endl;
   fentrada.read(cad, 20);
   do {
      cout << cad << endl;
      fentrada.read(cad, 20);
   } while(!fentrada.eof());

   fentrada.clear();
   // Acceso aleatorio:
   cout << "\nAcceso aleatorio:" << endl;
   for(i = 11; i >= 0; i--) {
      fentrada.seekg(20*i, ios::beg);
      fentrada.read(cad, 20);
      cout << cad << endl;
   }
 
   // Calcular el número de elementos 
   // almacenados en un fichero:
   // ir al final del fichero
   fentrada.seekg(0, ios::end); 
   // leer la posición actual
   pos = fentrada.tellg(); 
   // El número de registros es el tamaño en 
   // bytes dividido entre el tamaño del registro:
   cout << "\nNúmero de registros: " << pos/20 << endl;
   fentrada.close();

   return 0;
}