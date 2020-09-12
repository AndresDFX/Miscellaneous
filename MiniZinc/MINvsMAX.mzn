%Distancia mas corta entre un punto (x,y) y una linea a0 + a1x1 + a2y1 = 0

%Declarar constantes
int: x = 2;
int: y = 6;

%Declarar variables
var 0..100: x_1;
var 0..100: y_1;

%Declarar restricciones
constraint y_1 - 2*x_1 - 5 = 0;

%Funcion objetivo
solve minimize pow((x_1 - x), 2) + pow((y_1 - y),2);
%solve maximize -pow((x_1 - x), 2) - pow((y_1 - y),2); //Negacion de la funcion objetivo para maximizar

output ["x_1=", show(x_1), "\n y_1=", show(y_1), "" ];