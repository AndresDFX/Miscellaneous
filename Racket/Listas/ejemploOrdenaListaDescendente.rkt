;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname ejemploOrdenaListaDescendente) (read-case-sensitive #t) (teachpacks ((lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "universe.ss" "teachpack" "2htdp")))))
;;***************************************************************
;;***** Ordena una lista en forma descendente *******************
;;***************************************************************

; ordenar->: Lista-de-números -> Lista-de-números
; Ordena una lista de núemros en forma descendente.
(define (ordenar-> lista)
  (cond
    [(empty? lista) empty]
    [(cons? lista) (insertar (first lista) (ordenar-> (rest lista)))]))

;(check-expect (ordenar-> empty) empty)
;(check-expect (ordenar-> (list 12 20 -5)) (list 20 12 -5))
;(check-expect (ordenar-> (list 3 2 1)) (list 3 2 1))
;(check-expect (ordenar-> (list 1 2 3)) (list 3 2 1))
;(check-expect (ordenar-> (list 7 6 8 9)) (list 9 8 7  6))

; insertar: números Lista-de-números -> Lista-de-números
; insertar n en una lista ordenada de números
(define (insertar n lista)
  (cond
    [(empty? lista) (cons n empty)]
    [else (if (<= n (first lista))
              (cons n lista)
              (cons (first lista) (insertar n (rest lista))))]))

;(check-expect (insertar 5 (list 6)) (list 6 5))
;(check-expect (insertar 5 (list 4)) (list 5 4))
(ordenar-> (list 7 6 8 9))