/**
Usar streams facilita mucho el acceso a ficheros en disco, veremos que una vez que creemos un stream para un fichero, podremos trabajar con él igual que lo hacemos con cin o cout.
Mediante las clases ofstream, ifstream y fstream tendremos acceso a todas las funciones de las clases base de las que se derivan estas: ios, istream, ostream, fstreambase, y como también contienen un objeto filebuf, podremos acceder a las funciones de filebuf y streambuf.
En apendice E hay una referencia bastante completa de las clases estándar de entrada y salida.
Evidentemente, muchas de estas funciones puede que nunca nos sean de utilidad, pero algunas de ellas se usan con frecuencia, y facilitan mucho el trabajo con ficheros.

*/

#include <iostream>
#include <fstream>

using namespace std;

int escribirEnArchivo(string texto)
{
    ofstream out_file;  // Output File Stream para escribir (writing)
    ifstream in_file;   // Input File Stream  para leer (reading)

    // Escribir el archivo
    out_file.open("Prueba.txt", ios::app); // ios::app es lo paralello a "a" que significa append agregar al final del archivo
    out_file << texto << endl; // agregamos al buffer del stream
    out_file.close();  // flush el buffer y cerramos. flush el buffer basicamente hace write en el archivo.

    // Leer el archivo
    in_file.open("Prueba.txt");
    cout << "[Prueba.txt]  >>>" << endl;
    cout << in_file.rdbuf(); //endl funciona como activador de flush()
    // in_file.close() es llamado automaticamente en el destructor de in_file
    return 1;
}

int main() {
    escribirEnArchivo("1|Hola Mundo!|20.00|true");
    escribirEnArchivo("2|Adios Mundo!|50.00|false");
    escribirEnArchivo("3|Hola Mundo!|75.00|true");
}