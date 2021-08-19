
def guardar(linea):
    filename = "ecuaciones.txt"
    with open(filename, 'a+') as f:
        f.seek(0)
        data = f.read(100)
        if len(data) > 0:
            f.write("\n")
        f.write(linea)
        f.close
    
def generar_ecuacion(tipo):
    mensaje = 'Ingrese la ecuacion '+ tipo +' y presione ENTER, siguiendo alguno de los ejemplos:\n' \
              ' sin(x)+2 \n'\
              ' sin(x)+cos(2*x) \n'\
              ' tan(x)+arcsin(x**2) \n'\
              ' arctan(x)+arccos(3*x) \n\n'
            

    ecuacion = input(mensaje)
    titulo = input('Ingrese el titulo para el grafico: ')
    ejex = input('Ingrese el titulo para el eje coordenado X: ')
    ejey = input('Ingrese el titulo para el eje coordenado Y: ')
    linea = tipo + "," + ecuacion + "," + titulo + "," + ejex + "," + ejey
    print('Ecuacion guardada correctamente en archivo')
    return linea
    
    
    
def main():
    ans=True
    while ans:
        
        print("""## GENERADOR DE ECUACIONES ##
        1.Generar ecuacion trigonometrica
        2.Generar ecuacion polar
        3.Generar ecuacion en 3 dimensiones
        4.Salir
        """)
        
        ans=input("Seleccione una opcion para continuar: ")
        if ans=="1":
          guardar(generar_ecuacion("trigonometrica"))
        elif ans=="2":
          guardar(generar_ecuacion("polar"))
        elif ans=="3":
          guardar(generar_ecuacion("en tres dimensiones"))
        elif ans=="4":
          print("\n Goodbye") 
          ans = None
        else:
           print("\n No selecciono una opcion valida")

main()
