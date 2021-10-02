#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>


main(){

    //punto1_11();
    //punto1_12();
    //punto2_12();
    //punto2_22();
    punto2_31();
    return 0;

}

punto1_11(){

    int a,b,c,d;
    float x,y;

    printf("Ingrese coeficiente a: ");
    scanf("%d",&a);

    while (a == 0) {
        printf("Ingrese coeficiente a: ");
        scanf("%d",&a);
    }

    printf("Ingrese coeficiente b: ");
    scanf("%d",&b);
    printf("Ingrese coeficiente c: ");
    scanf("%d",&c);

    d = b*b-4*a*c;
    if (d > 0) {
        x = (-b+sqrt(d))/(2*a);
        y = (-b-sqrt(d))/(2*a);
        printf("x1 = %.2f\n",x);
        printf("x2 = %.2f\n",y);
    }
    else if (d == 0) {
        x = (-b)/(2*a);
        printf("x1 = %.2f\n",x);
    }
    else
        printf("La ecuacion no tiene solucion");
}

punto1_12(){

    int a,b,c,d;
    float x,y;

    printf("Ingrese coeficiente a: ");
    scanf("%d",&a);
    printf("Ingrese coeficiente b: ");
    scanf("%d",&b);
    printf("Ingrese coeficiente c: ");
    scanf("%d",&c);

    d = b*b-4*a*c;
    if (d == 0) {
        x = (-b)/(2*a);
        printf("x1 = %.2f\n",x);

    }
    else if (d == 0) {
        x = (-b+sqrt(d))/(2*a);
        y = (-b-sqrt(d))/(2*a);
        printf("x1 = %.2f\n",x);
        printf("x2 = %.2f\n",y);
    }
    else
        printf("La ecuacion no tiene solucion");
}

punto2_12(){

int numeros[10] ={};
int entrada=-2;

  while (1){

    printf("Ingrese el valor de la entrada: ");
    scanf("%d",&entrada);
    if (entrada==-1){
        break;
    }
    else{
        numeros[entrada]+=1;
    }
}
    printf("\nLa cantidad de veces que ha digitado cada numero es \n");
    for (int i = 0; i <=9; i++)
      printf("Numero %d = %d\n", i, numeros[i]);


}

punto2_22(){

    int tamano=0;
    float promedio, suma=0;
    printf("Indique el tamaño del arreglo: ");
    scanf ("%i",&tamano);
    int numeros[tamano];
    memset( numeros, 0, tamano*tamano*sizeof(int) );
    for(int i =0 ; i<tamano; i++){
        numeros[i]=0;
    }
    for(int i=0;i<=tamano;i++){
             int temporal;
             printf("Ingrese el numero %d =", i );
             scanf ("%i",&temporal);
             numeros[i]=temporal;

    }

    for (int j = 0; j<tamano; j++){
            suma+=numeros[j];
     }

    promedio = suma/tamano;
    printf("El promedio es: %f",promedio);
}


