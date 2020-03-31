;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname EjemploClase) (read-case-sensitive #t) (teachpacks ((lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "universe.ss" "teachpack" "2htdp")))))
(require 2htdp/batch-io)

;definición:

(define (descuento lista)
  (cond
    [(empty? lista) empty]
    [else (cons (* (string->number (first (first lista))) 0.10) 
                (cons (* (string->number (first (rest (first lista)))) 0.10)                       
                (descuento (rest lista))))]))


(define (nuevo archivo)
  (descuento
           (read-words/line archivo)))

(nuevo "vectorSalarios.txt")