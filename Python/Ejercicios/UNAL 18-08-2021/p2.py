from sympy import *
from numpy import *
import matplotlib.pyplot as plt

def generar_grafica(tipo):
    x = symbols('x')
    with open("ecuaciones.txt","r") as archivo:
        for linea in archivo:
            split =  linea.split(sep=',')
            ecuacion = sympify(split[1])
            lam_x = lambdify(x, ecuacion, modules=['numpy'])
            x_vals = arange(-2*pi, 2*pi, 0.01) #Rango de (-2PI,2PI)
            y_vals = lam_x(x_vals)
            plt.grid(True)
            plt.title(split[2])
            plt.xlabel(split[3])
            plt.ylabel(split[4])

            if(split[0] == 'trigonometrica' and tipo == 'trigonometrica'):
                plt.plot(x_vals, y_vals)
                plt.show()

            elif(split[0] == 'polar' and tipo == 'polar'):
                plt.axes(projection='polar')
                plt.plot(x_vals, y_vals)
                plt.show()
                        
            elif(split[0] == 'en tres dimensiones' and tipo == 'en tres dimensiones'):
                plt.axes(projection='3d')
                plt.plot(x_vals, y_vals)
                plt.show()
                                    

            
def main():
    ans=True
    while ans:
        
        print("""## GENERADOR DE GRAFICAS ##
        1.Generar graficas de ecuaciones trigonometrica
        2.Generar graficas de ecuaciones polares
        3.Generar graficas de ecuaciones en 3 dimensiones
        4.Salir
        """)
        
        ans=input("Seleccione una opcion para continuar: ")
        if ans=="1":
          generar_grafica("trigonometrica")
        elif ans=="2":
          generar_grafica("polar")
        elif ans=="3":
          generar_grafica("en tres dimensiones")
        elif ans=="4":
          print("\n Goodbye") 
          ans = None
        else:
           print("\n No selecciono una opcion valida")

main()
