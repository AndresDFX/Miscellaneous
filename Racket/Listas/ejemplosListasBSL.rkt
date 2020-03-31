;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname ejemplosListasBSL) (read-case-sensitive #t) (teachpacks ((lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "universe.ss" "teachpack" "2htdp")))))
;;******************************************
;;***** Construir una lista ****************
;;******************************************

(make-list 2 "hello")
(make-list 3 true)
(make-list 0 17)


; N String -> List-of-strings
; create a list of n strings s
 
;(check-expect (copier 2 "hello") (cons "hello" (cons "hello" empty)))
(check-expect (copier 0 "hello") empty)

;;*******************************************************
; La primera aproximación para la solución del problema
;;*******************************************************
(define (copier n s)
  empty)

;;*******************************************************
; Una idea más refinada *********************************
;;*******************************************************
(define (copier.v1 n s)
  (cond
    [(zero? n) empty]
    [(positive? n) (cons s (copier.v1 (sub1 n) s))]))

(check-expect (copier.v1 2 "hello") (cons "hello" (cons "hello" empty)))
(check-expect (copier.v1 0 "hello") empty)

;;*******************************************************
; Mejorando la idea anterior ****************************
;;*******************************************************
(define (copier.v2 n s)
  (cond
    [(zero? n) empty]
    [else (cons s (copier.v2 (sub1 n) s))]))

(check-expect (copier.v2 2 "hello") (cons "hello" (cons "hello" empty)))
(check-expect (copier.v2 0 "hello") empty)