import numpy as np
import time

notas_estudiantes = ([10, -60, 77],
                     [90, 15, 0],
                     [-45, -30, 66],
                     [99, 100, 99])
abs_notas_estudiantes = np.absolute(notas_estudiantes)
mean = np.mean(abs_notas_estudiantes)
std = np.std(np.mean(abs_notas_estudiantes, axis=1))
cantidad_estudiantes = abs_notas_estudiantes.shape[0]

print("Notificando resumen")
time.sleep(1)
print("Resumen enviado")
print("STD {} - MEAN {} para {} students".format(std, mean, cantidad_estudiantes))