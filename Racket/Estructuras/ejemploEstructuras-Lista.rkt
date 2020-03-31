;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname ejemploEstructuras-Lista) (read-case-sensitive #t) (teachpacks ((lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "universe.ss" "teachpack" "2htdp")))))
;;***************************************************
;;***** Estructuras en las lista ********************
;;***************************************************

(define-struct trabajo (nombreEmpleado valorHora Horas))
; Trabaja es una Estructura: (make-trabaja Cadana Número Número).
; donde. (make-make-trabaja n v h) contiene el nombre del empleado (n)
; con un valor por hora (r) y el número de horas trabajadas (h).


; Salario*: Lista_trabajo -> Lista-de-números
; Calcula el salario semanal para todos los empleados de la lista.

(check-expect (Salario* empty)
              empty)
(check-expect (Salario* (cons (make-trabajo "Victor" 10000 40) 
                              (cons (make-trabajo "Juan" 20000 20) empty)))
              (cons 400000 (cons 400000 empty)))

(check-expect (Salario* (cons (make-trabajo "Juan" 10000 50) (cons (make-trabajo "Victor" 10000 40) empty)))
              (cons 500000 (cons 400000 empty)))

(define (Salario* lista)
  (cond
    [(empty? lista) empty]
    [(cons? lista) (cons (Salario (first lista))
                          (Salario* (rest lista)))]))
 
; Salario: trabajo -> Número
; Calcula el salario de un empleado multiplicando el valor de la hora por las horas de trabajo.
(define (Salario t)
  (* (trabajo-valorHora t) (trabajo-Horas t)))