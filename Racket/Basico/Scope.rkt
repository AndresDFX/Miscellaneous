;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname Scope) (read-case-sensitive #t) (teachpacks ((lib "batch-io.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "batch-io.ss" "teachpack" "2htdp")))))
; ************************************************************************
; ************ Alcance Léxico, ejemplo 1 *********************************
; ************************************************************************

;(define (f x) 
;  (+ (* x x) 25))

;(define (g x) 
;  (+ (f (+ x 1)) (f (- x 1))))

; *******************************************
; ************ ¿Es lo mismo? ****************
; *******************************************

;(define (f y) 
;  (+ (* y y) 25))

;(define (g x) 
;  (+ (f (+ x 1)) (f (- x 1))))

; ************************************************************************
; ************ Alcance Léxico, ejemplo 2 *********************************
; ************************************************************************

;(define (h x)
;  (f (* 2 x)))

;(define (f x)
;  (+ (* x x) 25))

;(define (g x)
;  (+ (f (+ x 1)) (f (- x 1))))

; ************************************************************************
; ************ Alcance Léxico, ejemplo 3 *********************************
; ************************************************************************

(lambda (x y) 
  (+ x (* x y))) 

(lambda (x y) 
  (+ x 
     (local ((define x (* y y))) 
       (+ (* 3 x) (/ 1 x)))))

(lambda (x y)
  (+ x 
     ((lambda (x) 
        (+ (* 3 x) (/ 1 x)))  
      (* y y))))