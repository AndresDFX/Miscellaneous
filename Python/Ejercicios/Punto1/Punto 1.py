from datetime import datetime


op = {'+': lambda x, y: x + y,
      '-': lambda x, y: x - y}

#Metodo para dividir dos fraccionarios
def division(n1, n2, d1, d2):
    nr = n1 * d2
    dr = n2 * d1
    return str(nr) + "/" + str(dr)

#Metodo para multiplicar dos fraccionarios
def multiplicacion(n1, n2, d1, d2):
    nr = n1 * n2
    dr = d1 * d2
    return str(nr) + "/" + str(dr)

#Metodo para sumar o restar dos fraccionarios
def suma_resta(n1, n2, d1, d2, operador):
    if (d1 == d2):
        return str(op[operador](n1, n2)) + "/" + str(d1)
    else:
        return str(op[operador]((n1*d2), (n2*d1))) + "/" + str(d1*d2)

#Metodo para convertir una fraccion Mixta a una fraccion
def convertiraFraccion(entero, n, d):
    num = (entero * d) + n
    return str(num) + "/" + str(d)

#Metodo para convertir una fraccion a una fraccion Mixta
def convertiraMixto(n, d):
    e = n // d
    nr = n % d
    dr = d
    return str(e) + "(" + str(nr) + "/" + str(dr) + ")"

# Metodo que permite guardar una linea en un archivo de texto
def guardarArchivo(nombre, linea):
    archivo = open(nombre, "a")
    archivo.write(linea)
    archivo.close()

# Metodo principal que ejecuta todo el programa
def main():

    # Abrir el archivo que contiene las operaciones
    archivo = open("[A_AndreaConradoAcosta]01.txt")

    for cadena in archivo.readlines():

        resultado = ""
        arreglo = cadena.strip().split(" ")
        lista1 = arreglo[0].split("(")
        operador = arreglo[1]
        lista2 = arreglo[2].split("(")

        # Obtener cada elemento de la linea: la parte entera, el numerador y denominador
        fraccion1 = lista1[1][:-1].split("/")
        entero1 = int(lista1[0])
        numerador1 = int(fraccion1[0])
        denominador1 = int(fraccion1[1])

        fraccion2 = lista2[1][:-1].split("/")
        entero2 = int(lista2[0])
        numerador2 = int(fraccion2[0])
        denominador2 = int(fraccion2[1])

        # Convertir a fracciones no mixtas
        fraccion1Temp = convertiraFraccion(
            entero1, numerador1, denominador1).split("/")
        fraccion2Temp = convertiraFraccion(
            entero2, numerador2, denominador2).split("/")

        # Obtener cada elemento de la linea: la parte entera, el numerador y denominador
        numerador1Temp = int(fraccion1Temp[0])
        denominador1Temp = int(fraccion1Temp[1])

        numerador2Temp = int(fraccion2Temp[0])
        denominador2Temp = int(fraccion2Temp[1])

        # ========Realizar la operacion indicada, entre las fracciones ==========
        if (operador == "+" or operador == "-"):
            fraccion = suma_resta(numerador1Temp, numerador2Temp,
                                  denominador1Temp, denominador2Temp, operador).split("/")
            numerador = int(fraccion[0])
            denominador = int(fraccion[1])

            # Ahora convertimos nuevamente el resultado a fraccion mixta
            resultado = convertiraMixto(numerador, denominador)

        elif (operador == "*"):
            fraccion = multiplicacion(
                numerador1Temp, numerador2Temp, denominador1Temp, denominador2Temp).split("/")
            numerador = int(fraccion[0])
            denominador = int(fraccion[1])

        # Ahora convertimos nuevamente el resultado a fraccion mixta
            resultado = convertiraMixto(numerador, denominador)

        elif (operador == "/"):
            fraccion = division(numerador1Temp, numerador2Temp,
                                denominador1Temp, denominador2Temp).split("/")
            numerador = int(fraccion[0])
            denominador = int(fraccion[1])

            # Ahora convertimos nuevamente el resultado a fraccion mixta
            resultado = convertiraMixto(numerador, denominador)

        # GUARDAR EL RESULTADO DE LA OPERACION EN LA LINEA CORRESPONDIENTE
        linea = cadena.strip() + " = " + resultado
        hoy = datetime.now()
        nombreArchivo = "[A_AndreaConradoAcosta]01-"+str(hoy.year)+str(hoy.month)+str(hoy.day)+"-"+str(hoy.hour)+str(hoy.minute)+str(hoy.second)+".txt"
        guardarArchivo(nombreArchivo, linea+"\n")

    # Cerrar el archivo de lectura
    archivo.close()


# LLAMADO PRINCIPAL
main()
