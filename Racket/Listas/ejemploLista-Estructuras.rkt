;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname ejemploLista-Estructuras) (read-case-sensitive #t) (teachpacks ((lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "universe.ss" "teachpack" "2htdp")))))
;;****************************************************
;;***** Listas en las Estructuras ********************
;;****************************************************

(define-struct trabajo (nombreEmpleado valorHora Horas))
; Trabaja es una Estructura: (make-trabaja Cadena Número Número).
; donde. (make-make-trabaja n v h) contiene el nombre del empleado (n)
; con un valor por hora (r) y una lista del número de horas trabajadas en la semana(h).


; Salario*: Lista_trabajo -> Lista-de-boolean
; Determina cuales trabajadores trabajan más de 8 horas.

(check-expect (Salario* empty)
              empty)

(check-expect (Salario* (cons (make-trabajo "Victor" 10000 (cons 8 empty)) empty))
              (cons false empty))

(check-expect (Salario* (cons (make-trabajo "Victor" 10000 (cons 7 (cons 9 empty))) empty))
              (cons true empty))

(check-expect (Salario* (cons (make-trabajo "Victor" 10000 (cons 7 (cons 9 empty)))  
                (cons (make-trabajo "Manuel" 10000 (cons 3 (cons 2 (cons 3 empty)))) empty)) )
	            (cons true (cons false empty))) 
 
(define (Salario* lista)
  (cond
    [(empty? lista) empty]
    [(cons? lista) (cons (TrabajaMas8Horas (trabajo-Horas (first lista)))
                        (Salario* (rest lista)) )]))
 
; TrabajaMas8Horas: trabajo-Horas -> boolean
; Verifica si un usuario trabaja más de 8 horas al día.
(define (TrabajaMas8Horas lht)
  (cond 
    [(empty? lht) false]
    [(> (first lht) 8) true]
    [else (TrabajaMas8Horas (rest lht))]))
