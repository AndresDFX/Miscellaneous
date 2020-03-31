;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname EjemplosStruct_EjemplosClase) (read-case-sensitive #t) (teachpacks ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp")))))
; Se requiere construir un programa que calcule el promedio de las notas
; de un estudiante universitario. El estudiante, este semestre tiene 3 asignaturas.
; La asignatura se define por el nombre de la asignatura y su nota.

; Análisis y Definición de Datos
(define-struct nota (nombreAsignatura calificación)) 
; Una nota es una estructura: (make-nota a b)
; donde a es el nombre de la asignatura y b es su calificación.

(define-struct estudiante (nombre nota1 nota2 nota3))
; Un estudiante es una estructura: (make-estudiante a b c d)
; donde a es el nombre del estudiantes y b, c, d son estructura
; de tipo nota.

; Contrato: 
; Propósito: Calcular la nota definitiva de un estudiante con tres asignaturas.
; La firma es:  estudiante --> número  
; El encabezado es (define (promedio-nota estudiante))

; Ejemplos:
; (promedio-nota (make-estudiante "victor" (make-nota "Español" 3) (make-nota "Programación" 1) (make-nota "Dibujo" 5))) 
; debe producir 3
; (promedio-nota (make-estudiante "victor" (make-nota "Programación" 1) (make-nota "Ingles" 2) (make-nota "Español" 3)))
; debe producir 2

; Bosquejo o plantilla de solución.
; (define (función unEstudiante)
; ... (nota-calificación (estudiante-nota1 unEstudiante))...
; ... (nota-calificación (estudiante-nota2 unEstudiante))...
; ... (nota-calificación (estudiante-nota3 unEstudiante))...

; Definición:
(define (promedio-nota unEstudiante)
  (/
   (+ (nota-calificación (estudiante-nota1 unEstudiante))
      (nota-calificación (estudiante-nota2 unEstudiante))
      (nota-calificación (estudiante-nota3 unEstudiante))) 3))

; Pruebas:
(check-expect (promedio-nota (make-estudiante "victor" (make-nota "Español" 3) (make-nota "Programación" 1) (make-nota "Dibujo" 5))) 3)
(check-expect (promedio-nota (make-estudiante "victor" (make-nota "Programación" 1) (make-nota "Ingles" 2) (make-nota "Español" 3))) 2)