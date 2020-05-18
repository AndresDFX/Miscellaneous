import math
from tabulate import tabulate
#pìp install tabulate

#Definicion de arreglos inicial
numeroSucursales = int(input("Digite la cantidad de sucursales iniciales: "))
numeroProductos =  int(input("Digite la cantidad de productos que tendra cada sucursal: "))
e = [None] * numeroSucursales
m = [None] * numeroProductos
inventario=[]


#Metodo para ingresar una sucursal y todos los productos de la misma
def ingresarDatos(nS, nP, ingresoInicial):

    for j in range(nS):
        if(ingresoInicial):
            e[j] = input("ingrese el nombre de la sucursal: ")
        else:
            e.append(input("ingrese el nombre de la sucursal: ")) 
    print("\n")
         
    for i in range(nP):
        if(ingresoInicial):
            m[i] = input("Digite el nombre del producto: ")


    print("\n")

   
    for i in range(nS):
        print('\n*********Digite la cantidad de existencias de la sucursal', e[i], end=""+'*********\n')
        inventario.append([])
        for j in range(nP):
            n=float(input("ingrese la cantidad de {}:  ".format(m[j],end="")))
            inventario[-1].append(n)


#Metodo para imprimir la matriz de inventario
def imprimirMatriz():
      print(tabulate(inventario, headers=m, showindex=e))


#Metodo para obtener el indice de un producto dado el nombre
def buscarProducto(producto):
    indice = -1

    for i in range(len(m)):
        if (producto == m[i]):
            indice = i
    return indice

#Metodo para obtener el indice de una sucursal dado el nombre
def buscarSucursal(sucursal):
    indice = -1

    for i in range(len(e)):
        if (sucursal == e[i]):
            indice = i

    return indice

#Metodo para obtener las sucursales que contienen ese producto
def buscarProductoSucursal(producto):

    indice = buscarProducto(producto)
    cadena = ""

    if (indice != -1):
        for j in range(len(e)):
            cadena += e[j]+", "   
        print("\nLas sucursales que contienen el producto", producto, ":", cadena)


#Metodo para descontar de la matriz inventario un articulo vendido
def realizarVenta(sucursal, producto):
    indiceProducto = buscarProducto(producto)
    indiceSucursal = buscarSucursal(sucursal)

    inventario[indiceSucursal][indiceProducto] -= 1
    print("\nSe realizo correctamente la venta")

#Metodo para obtener el total de unidades de una sucursal mostrando que productos tiene
def totalUnidades():
    totalSucursal = [0 for x in range(len(e))]
    for i in range(len(e)):
        for j in range(len(m)):
            totalSucursal[i] += inventario [i][j]
    
    print(tabulate(e, totalSucursal,showindex=e))

#Metodo para imprimir un arreglo unidimensional separado por ","
def imprimirArray(arreglo):
    print(*arreglo, sep = ", ") 


#Definicion del Menu principal de ejecucion
def menu():

    #Ingreso de datos inicial
    ingresarDatos(numeroSucursales, numeroProductos, True)
    opcionMenu = 0
    while opcionMenu != 1:
        print("********************************")
        print("*                              *")
        print("*       MENU PRINCIPAL         *")
        print("*                              *")
        print("********************************")
        print("Selecciona una opción")
        print("\t1 - Imprimir inventario")
        print("\t2 - Mostrar sucursales")
        print("\t3 - Mostrar productos")
        print("\t4 - Ingresar nueva sucursal")
        print("\t5 - Realizar venta")
        print("\t6 - Buscar un producto")
        print("\t7 - Total unidades")
        print("\t8 - Salir")

        opcionMenu = input("Inserta un numero valor >> ")
        if opcionMenu == "1":
            imprimirMatriz()
        
        elif opcionMenu == "2":
            imprimirArray(e)
        
        elif opcionMenu == "3":
            imprimirArray(m)
            
        elif opcionMenu == "4":
            ingresarDatos(1, numeroProductos, False)

        elif opcionMenu == "5":
            sucursal = input("Ingrese el nombre de la sucursal: ")
            producto = input("Ingrese el nombre del producto: ")
            realizarVenta(sucursal, producto)
            
        elif opcionMenu == "6":
            buscarProductoSucursal(input("Ingrese el nombre del producto que desea vender: "))
        
        elif opcionMenu == "7":
            totalUnidades()

        elif opcionMenu == "8":
            input("Usted a salido del programa, presione una tecla para continuar")
            exit()
        else:
            input("Ha seleccionado una opcion invalida, presione una tecla para continuar")


#Ejecucion principal
menu()

