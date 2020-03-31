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

int main(){

    int *array;
    int tamanoInicial;
    printf("Introduce el tamaño del arreglo: ");
    scanf("%d", tamanoInicial);
    array = (int *)malloc (tamanoInicial*sizeof(int));

    iniarray(tamanoInicial,array);
    printarray(tamanoInicial,array);
    free(array);
    return 0;

}