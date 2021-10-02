#Require pip install tabulate

import statistics as stas
from tabulate import tabulate

#Pedir datos iniciales
print("\t"+"**********Instituto tecnico de contaduria**********")
print("\n")        
nume=int(input("Digite la cantidad de estudiantes de la carrera Tecnico en Contaduria: "))           
numa=int(input("Digite la cantidad de asignaturas: "))
print("\n")
e=[None]*nume
m=[None]*numa

for j in range (nume):
    e[j]=input("ingrese el nombre completo del estudiante: ")
    
print("\n")         
for i in range (numa):
    m[i]=input("Digite el nombre de la asignatura: ")
print("\n")
nota=[]
sumatoria=0
for i in range(nume):
    print('\n*********Digite las notas del estudiante', e[i], end=""+'*********\n')
    nota.append([])
    for j in range(numa):
        n=float(input("ingrese la nota de {}:  ".format(m[j],end="")))
        nota[i].append(n)
        
#Calcular los valores 
print("\n")   
"for fila in nota:"
"print(fila)"

prome=[]*nume    
for i in range(nume):
    suma=sum(nota[i])
    prom=(suma/numa)
    prome.append(prom)
    print("el promedio de {} ".format(e[i],end=""),prom)
    nota[i].append(prom)
print("\n")    
for j in range(numa):
    suma=sum([nume[j] for nume in nota])
    prom=(suma/nume)
    print("el promedio de {} ".format(m[j],end=""),prom)
print("\n")    
mayor=max(prome)
pos=prome.index(mayor)
name=e[pos]
print("el estudiante con el promedio mas alto es: ",name," y su nota es: ",mayor)

minimo=min(prome)
posmi=prome.index(minimo)
name=e[posmi]
print("el estudiante con el promedio mas bajo es: ",name," y su nota es: ",minimo)
sumapromedio=sum(prome)
promedio=(sumapromedio/nume)
print("la nota promedio del grupo fue: ",promedio)

numinicial=0
for i in prome:
    x=i
    if promedio>x:
        numinicial=numinicial+1
print("el numero de alumnos con una nota mas baja a",promedio," son: ",numinicial)

nombre=input("la desviacion estandar de las notas de: ")
x=e.index(nombre)
suman=sum(nota[x])
desviacion=stas.stdev(nota[x])
print("la desviacion estandar de las notas obtenidas por el estudiante",nombre," es: ",desviacion)
print("\n")
m.insert(0,"Estudiantes")
m.extend(["Promedio"])

#Mostrar la matriz tabulada
print(tabulate(nota, headers=m, showindex=e))

    
















    

