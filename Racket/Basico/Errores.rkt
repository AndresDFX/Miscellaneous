;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname Errores) (read-case-sensitive #t) (teachpacks ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp")))))
; Errores sintácticos

;(con 1 empty)

;(plus 5 6)

;(cons empty 1)

;; errores gramaticales
;(+ 1)

;(+ 1 "a") 

;(/ 4 0)

;(define (discriminante a b c) (/ (- (* b b)(* 4 a c)) (* 2 a)))
;(discriminante 0 2 4)

; errores de lógica

;(define (par n) (= (remainder n 2) 1))
;
;(check-expect (par 5) false)
;(check-expect (par 2) true)