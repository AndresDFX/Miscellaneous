profesores = ['Pedro', 'María', 'Juan', 'Martha', 'Johanna', 'Tomas', 'Pedro', 'Claudia', 'Diego', 'Andres']
salarios = [1565348, 2300000, 2287945, 5454670, 4835678, 5643568, 2745345, 4345667, 2843200, 2900000]

def datos_profesores():
  total_nomina = 0
  promedio_nomina = 0.0
  menor = salarios[0]
  mayor = salarios[0]
  indice_menor = 0
  indice_mayor = 0
  cantidad_profesores = len(profesores)
  print('Salarios por profesor\n')
  for i in range(0,len(profesores)-1):
    print(f'{profesores[i]} = {salarios[i]}')
    total_nomina += salarios[i]
    if salarios[i] > mayor:
        mayor = salarios[i]
        indice_mayor = i
    if salarios[i] < menor:
        menor = salarios[i]
        indice_menor = i
  

  promedio_nomina = total_nomina / cantidad_profesores
  print(f'\nTotal nomina: {total_nomina}')
  print(f'\nPromedio salarios: {promedio_nomina}')
  print(f'\nMayor salario: {profesores[indice_mayor]} - {salarios[indice_mayor]}')
  print(f'\nMenor salario: {profesores[indice_menor]} - {salarios[indice_menor]}')


datos_profesores()