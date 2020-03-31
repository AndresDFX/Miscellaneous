;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname aritmetica-booleanos) (read-case-sensitive #t) (teachpacks ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp")))))
; Aritmética booleana

true
false

; La negación
(not true)
(not false)

; La conjunción
(and true true)
(and true false)
(and false true)
(and false false)

; La disyunción
(or true true)
(or true false)
(or false true)
(or false false)

; Combinaciones
(define b1 true)
(define b2 false)

(or (not b1) b2) 
