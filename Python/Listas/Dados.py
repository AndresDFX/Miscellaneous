#enconding: utf-8

import random
import numpy

#SIMULACION DE LANZAMIENTO DE DOS DADOS 50000 veces
numpy.set_printoptions(precision=5, suppress=True )
suma_por_cara = numpy.zeros((13,), dtype=int)
contador = numpy.arange(13)
n_lanzamientos = 50000

for i in range(n_lanzamientos):
    dado1 = numpy.random.randint(1, 6)
    dado2 = numpy.random.randint(1, 6)
    suma = dado1 + dado2
    contador[suma] += 1

#Probabilidad de cada combinacion de suma de dos lados
print(contador/n_lanzamientos)





 
