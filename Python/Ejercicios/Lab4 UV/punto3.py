lista_tiempos = []
lista_ciclistas = []

def leer_ciclistas():
  for i in range(10):
    ciclista = input("Digite el nombre del ciclista: ")
    tiempo = int(input("Digite el tiempo en segundos del ciclista: "))
    lista_ciclistas.append(ciclista)
    lista_tiempos.append(tiempo)

def generar_tabla_clasificacion(tiempos, ciclistas):
  #Ordenar listas
  tiempos, ciclistas = map(list, zip(*sorted(zip(tiempos, ciclistas))))
  print('Tabla de Clasificación\n')
  for i in range(0,len(tiempos)):
    if i == 0:
      segundos = tiempos[i]
      horas=int(segundos/3600)
      segundos-=horas*3600
      minutos=int(segundos/60)
      segundos-=minutos*60
      print(f'{i+1}. {ciclistas[i]} en {horas}h {minutos}m {segundos}s')
    else:
      tiempo = tiempos[i] - tiempos[0]
      print(f'{i+1}. {ciclistas[i]} a {tiempo}.00s')

leer_ciclistas()
generar_tabla_clasificacion(lista_tiempos, lista_ciclistas)