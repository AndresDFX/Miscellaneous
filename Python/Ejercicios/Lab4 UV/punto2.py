datos = [[None] * 4] * 6

departamentos = ["Bolívar", "Magdalena", "Atlántico", "Guajira", "Córdoba", "Sucre"]
anhos = ["2014", "2015", "2016", "2017"]

def pedir_datos():
  matriz = [[None] * 4] * 6
  for fila in range(0,5):
    for columna in range(0,3):
      matriz[fila][columna] = int(input(f'Digite el valor de damnificado en la posicion [{fila}][{columna}]: '))
  datos = matriz


#PUNTO 1
def total_damnificados_por_ahno(matriz):
  total_damnificados = lambda matriz: [sum(i) for i in zip(*matriz)]
  totales = total_damnificados(matriz)
  print("Damnificados por Año")
  for i in range(0, len(totales)):
    print(f'Año {anhos[i]} = {totales[i]}')

#PUNTO 2
def departamento_menos_afectado(matriz):
  suma_por_dpto = lambda matriz: [sum(i) for i in matriz]
  totales = suma_por_dpto(matriz)
  indice = 0
  menor = totales[0]
  for i in range(1,len(totales)-1):
    if (totales[i] < menor):
      indice = i
  print('Depto menos damnificado')
  print(f'{departamentos[indice]} = {totales[indice]}')

#PUNTO 3
def departamento_menor_incremento(matriz):
  incremento = matriz[0][2] - matriz[0][1]
  indice = 0
  for i,fila in enumerate(matriz):
      for j,valor in enumerate(fila):
        incremento_actual =  matriz[i][2] - matriz[i][1]
        if (incremento_actual <= incremento):
          indice = i
          incremento = incremento_actual
  print('Depto con menor incremento de damnificados')
  print(f'{departamentos[indice]} = {incremento}')


pedir_datos()
total_damnificados_por_ahno(datos)
departamento_menos_afectado(datos)
departamento_menor_incremento(datos)