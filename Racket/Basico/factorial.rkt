;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname factorial) (read-case-sensitive #t) (teachpacks ((lib "batch-io.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "batch-io.ss" "teachpack" "2htdp")))))
;; ***************************************************************
;; ********************** Sin acumulación ************************
;; ***************************************************************
;; ! : N -> N
;; calcular n · (n - 1) · ... · 2 · 1
;; recursión estructural
 (define (fact! n)
  (cond
    [(zero? n) 1]
    [else 
     (* n (fact! (sub1 n)))]))

;(fact! 4)
 
 ;; ***************************************************************
;; ********************** Con acumulación ************************
;; ***************************************************************
 
;; ! : N -> N
;; calcular n · (n - 1) · ... · 2 · 1
(define (! n0)
  (local (;; acumulador es el producto de los números naturales en [n0, n)
          ;; n0 (inclusive) y n (exclusivo)
        (define (!-a n acumulador)
         (cond
           [(zero? n) acumulador]
           [else (!-a (sub1 n) (* n acumulador))])))
        (!-a n0 1)))

(! 3)

