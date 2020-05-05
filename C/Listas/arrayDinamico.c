#include <stdio.h>
#include <stdlib.h>


int iniarray(int n, int *array) {
	int i;
	for (i = 0; i < n; i++) 
		array[i] = i;
	return i;
}

void printarray(int n, int *array) {
	int i = 0;
	printf("[ ");
	for (; i < n; i++) {
		if (i == n - 1) 
			printf("%d ", array[i]);
		else
			printf("%d, ", array[i]);
	}
	printf("]\n");
}

int sumaPares(int *array, int n) {
	int i = 0;
	int suma = 0;
	for (; i < n; i++){
		if (array[i]%2 ==0){
			suma += array[i];
		}
	}
	return suma;
}


	int main()
	{

		

		int *array;
		int tamanoInicial;
		printf("Introduce el tamaño del arreglo: ");
		scanf("%d", tamanoInicial);
		array = (int *)malloc(tamanoInicial * sizeof(int));
		
		//Inicializar el array
		iniarray(tamanoInicial, array);
		
		//Imprimir el array
		printf("Introduce el tamaño del arreglo: ");
		printarray(tamanoInicial, array);

		
		printf("\nLa suma del arreglo es: %i" ,sumaPares(array, tamanoInicial) );

		//Liberar la memoria
		free(array);
		return 0;

}