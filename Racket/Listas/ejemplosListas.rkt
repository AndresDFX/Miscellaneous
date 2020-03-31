;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname ejemplosListas) (read-case-sensitive #t) (teachpacks ((lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "universe.ss" "teachpack" "2htdp")))))
;;******************************************
;;Lista de números de 0 a 9
;;******************************************
;(cons 0
;  (cons 1
;    (cons 2
;      (cons 3
;        (cons 4
;          (cons 5
;            (cons 6
;              (cons 7
;                (cons 8
;                  (cons 9 empty))))))))))


;;******************************************
;;***** Si hay un elemento en la lista *****
;;******************************************
; Contiene-nombre-juan?: Lista -> boolean
; Determina si el nonmbre "Juan" esta en una lista de nombres.
 
;(check-expect
;  (Contiene-nombre-Juan? (cons "Victor" (cons "Manuel"  (cons "Francisco" empty))))
;  false)
;(check-expect
;  (Contiene-nombre-Juan? (cons "Victor" (cons "Manuel"  (cons "Juan" empty))))
;  true)
;(check-expect
;  (Contiene-nombre-Juan? (cons "Juan" empty))
;  true)
;(check-expect
;  (Contiene-nombre-Juan? (cons "Victor" empty))
;  false)
;
;(define (Contiene-nombre-Juan? lista-de-nombres)
;  (cond
;    [(empty? lista-de-nombres) false]
;    [(string=? (first lista-de-nombres) "Juan") true]
;    [(empty? (rest lista-de-nombres)) false]
;    [(string=? (first (rest lista-de-nombres)) "Juan") true]
;    [(empty? (rest (rest lista-de-nombres))) false]
;    [(string=? (first (rest (rest lista-de-nombres))) "Juan") true]
;    [else false]))

;;*****************************************
;;***** ¿Que pasa si la lista crece *******
;;*****************************************
;; Contiene-nombre-Juan?: Lista -> Boolean
;; Determina si el nonmbre Juan, esta en una lista de nombres.
;( define Lista1
;(cons "Manuel"
;  (cons "Victor"
;    (cons "Francisco"
;      (cons "Juan"
;        (cons "Estela"
;          (cons "Monica"
;            (cons "Luz" empty))))))))
;
;( define Lista2
;(cons "Pedro"
;  (cons "Victor"
;    (cons "Francisco"
;      (cons "Manuel"
;        (cons "Estela"
;          (cons "Monica"
;            (cons "Luz" empty))))))))
;
;(check-expect (Contiene-nombre-Juan.1? Lista2) false)
;(check-expect (Contiene-nombre-Juan.1? Lista1) true)
;(check-expect (Contiene-nombre-Juan.1? empty) false) 
;
;(define (Contiene-nombre-Juan.1? lista-de-nombres)
;  (cond
;    [(empty? lista-de-nombres) false]
;    [(cons? lista-de-nombres)
;     (or (string=? (first lista-de-nombres) "Juan")
;         (Contiene-nombre-Juan.1? (rest lista-de-nombres)))]))

;;;***************************************************************************
;;;***** ¿Que pasa si la lista crece y debe buscar cualquier elemento? *******
;;;***************************************************************************
;; Contiene-nombre?: Cadena Lista -> Boolean
;; Determina si algún nonmbre, esta en una lista de nombres.
( define Lista
(cons "Juan"
  (cons "Victor"
    (cons "Francisco"
      (cons "Manuel"
        (cons "Estela"
          (cons "Monica"
            (cons "Luz" empty))))))))

(check-expect (Contiene-nombre? "Ana" Lista) false)
(check-expect (Contiene-nombre? "Juan" Lista) true)
 
(define (Contiene-nombre? nombre lista-de-nombres)
  (cond
    [(empty? lista-de-nombres) false]
    [(cons? lista-de-nombres)
     (or (string=? (first lista-de-nombres) nombre)
         (Contiene-nombre? nombre (rest lista-de-nombres)))]))


