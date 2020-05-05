#include <stdio.h>


//Inicializa un arreglo de n posiciones iniciando en 0
int iniarray(int n, int *array)
{
    int i;
    for (i = 0; i < n; i++){
        int value;
        printf("¿Cual es el valor de la posicion %d ?: ", i);
        scanf("%d", &value);
        array[i] = value;
    }
    return i;
}

//Imprime todo el arreglo en un formato especifico
void printarray(int n, int *array) {

	printf("[ ");
	for (int i =0; i < n; i++) {
		if (i == n - 1) 
			printf("%d ", array[i]);
		else
			printf("%d, ", array[i]);
	}
	printf("]\n");
}

//Suma los elementos que se encuentren en posiciones pares
int sumaPares(int n, int *array )
{

    int suma = 0;
	for (int i=0; i < n; i++){
		if (i%2 ==0){
			suma += array[i];
		}
	}
	return suma;
}

//Promedio de los elementos que se encuentren en posiciones impares
float promedioImpares(int n, int *array)
{
    int counter = 0;
    int suma = 0;
    float promedio;

    for (int i = 0; i < n; i++)
    {
        if (i% 2 == 1)
        {
            suma += array[i];
            counter += 1;
        }
    }

    promedio = suma / counter;
    return promedio;
}


int main()
{
    int tamanoInicial;
    printf("Introduce el tamano del arreglo: ");
    scanf("%d", &tamanoInicial);
    int *array = new int[tamanoInicial];

    //Inicializar el array
    iniarray(tamanoInicial, array);

    //Imprimir todo el arreglo
    printf("\nEl arreglo es: ");
    printarray(tamanoInicial, array);

    //Suma elementos pares
    printf("La suma de las posiciones pares: %d",sumaPares(tamanoInicial, array));

    //El promedio de los impares
    printf("\nEl promedio de las posiciones impares: %f", promedioImpares(tamanoInicial, array));

    return 0;
}