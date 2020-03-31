;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname ejemploLista-Estructuras) (read-case-sensitive #t) (teachpacks ((lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "universe.ss" "teachpack" "2htdp")))))
;;****************************************************
;;***** Listas en las Estructuras ********************
;;****************************************************

(define-struct trabajo (nombreEmpleado valorHora Horas))
; Trabaja es una Estructura: (make-trabaja Cadana Número Número).
; donde. (make-make-trabaja n v h) contiene el nombre del empleado (n)
; con un valor por hora (r) y una lista del número de horas trabajadas en la semana(h).


; Salario*: Lista_trabajo -> Lista-de-números
; Calcula el salario semanal para todos los empleados de la lista.

(check-expect (Salario* empty)
              empty)

(check-expect (Salario* (cons (make-trabajo "Victor" 10000 (cons 8 empty)) empty))
              (cons 80000 empty))

(check-expect (Salario* (cons (make-trabajo "Victor" 10000 (cons 7 (cons 8 empty))) empty))
              (cons 150000 empty))

(define (Salario* lista)
  (cond
    [(empty? lista) empty]
    [(cons? lista) (cons (Salario (first lista))
                          (Salario* (rest lista)))]))
 
; Salario: trabajo -> Número
; Calcula el salario de un empleado multiplicando el valor de la hora por las horas de trabajo.
(define (Salario t)
  (* (trabajo-valorHora t) (totalHoras (trabajo-Horas t) 0)))

; totalHoras: ListaHoras -> Número
; Suma el total de las horas trabajas en una semana.
(define (totalHoras lht horas)
  (cond
    [(empty? lht) horas]
    [(cons? lht) (totalHoras (rest lht) (+ (first lht) horas))]))