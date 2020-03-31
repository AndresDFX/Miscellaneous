;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname ejemploFunciones-Lista) (read-case-sensitive #t) (teachpacks ((lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "universe.ss" "teachpack" "2htdp")))))
;;***************************************************
;;***** Funciones que producen lista ****************
;;***************************************************

; Número -> Número
; Calcula el salario de un empleado por horas de trabajo.
(define (salario horas)
  (* 12000 horas))

;; given:                         expected:
;;  empty                           empty
;;  (cons 28 empty)                 (cons 336000 empty)
;;  (cons 40 (cons 28 empty))       (cons 480000 (cons 336000 empty))

; Lista-de-números -> Lista-de-números
; Calcula el salario semanal de todos los empleados, tomando horas semanales.
(define (salario* lista_salarios)
  (cond
    [(empty? lista_salarios) empty]
    [else (cons (salario (first lista_salarios)) (salario* (rest lista_salarios)))]))

; Pruebas
(check-expect (salario* empty) empty)
(check-expect (salario* (cons 28 empty)) (cons 336000 empty))
(check-expect (salario* (cons 40 (cons 28 empty))) (cons 480000 (cons 336000 empty)))
