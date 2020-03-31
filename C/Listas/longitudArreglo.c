#include <stdio.h>

int main(int argc, char const *argv[])
{
	double arreglo[2] = {123, 456};

	// Memoria ocupada por todo el arreglo
	int tamanioDelArreglo = sizeof(arreglo);

	// Memoria ocupada por su primer elemento
	int tamanioDeLaPrimeraVariableDelArreglo = sizeof(arreglo[0]);

	// División simple
	int longitud = tamanioDelArreglo / tamanioDeLaPrimeraVariableDelArreglo;
	printf( "El arreglo ocupa %d bytes.\n"
			"La primer variable ocupa %d bytes.\n"
			"Entonces la longitud es: %d", 
			tamanioDelArreglo, tamanioDeLaPrimeraVariableDelArreglo, longitud);
	return 0;
}