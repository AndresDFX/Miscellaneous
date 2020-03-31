;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname funciones) (read-case-sensitive #t) (teachpacks ((lib "batch-io.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "batch-io.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp")))))
;En esta función el parámetro de entrada no interviene.
(define (f x) 1)
;En esta función los parámetros hacen parte del cuerpo de la función.
(define (suma x y) (+ x y))
;De la misma forma que la función anterior, los parámetros hacen parte del cuerpo de la función.
(define (calcular x y z) (+ (* x y) z))
