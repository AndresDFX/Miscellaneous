from itertools import combinations

def posibles_combinaciones():
  letras = []
  for i in range(0,6):
    letra = input('digite el dato a mezclar ')
    letras.append(letra)
  print('La tabla de datos a combinar ingresada es')
  print(letras)
  a = list(combinations(letras, 3))
  print('La matriz de combinaciones resultantes es:')
  print(a)

posibles_combinaciones()