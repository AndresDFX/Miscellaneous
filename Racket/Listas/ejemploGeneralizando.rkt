;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname ejemploGeneralizando) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ())))
;;***************************************************************
;;***** Generalizando funciones *********************************
;;***************************************************************

(require 2htdp/image)
 
; A Polygon is one of:
; – (list Posn Posn Posn)
; – (cons Posn Polygon)
 
(define MT (empty-scene 50 50))
 
; Polygon -> Image
; add the Polygon p into an image in MT
(define (render-polygon p)
  (render-line (connect-dots p) (first p) (last p)))
 
; A NELoP is one of:
; – (cons Posn empty)
; – (cons Posn NELoP)
 
; NELoP -> Image
; connect the Posns in p
(define (connect-dots p)
  (cond
    [(empty? (rest p)) MT]
    [else
      (render-line
        (connect-dots (rest p)) (first p) (second p))]))

(check-expect (connect-dots (list (make-posn 20 0)
                                  (make-posn 10 10)
                                  (make-posn 30 10)))
              (add-line
               (add-line MT 20 0 10 10 "red")
               10 10 30 10 "red"))

; Image Posn Posn -> Image
; draw a red line from Posn p to Posn q into im
(define (render-line im p q)
  (add-line
    im (posn-x p) (posn-y p) (posn-x q) (posn-y q) "red"))
 
; NELoP -> Posn
; extract the last Posn from p
(define (last p)
  (cond
    [(empty? (rest (rest (rest p)))) (third p)]
    [else (last (rest p))]))

;; *******************************************************************************
;; *******************************************************************************

(check-expect
  (render-polygon
    (list (make-posn 20 0) (make-posn 10 10) (make-posn 30 10)))
  (add-line
    (add-line
      (add-line MT 20 0 10 10 "red")
      10 10 30 10 "red")
    30 10 20 0 "red"))

(check-expect
  (render-polygon
    (list (make-posn 10 10) (make-posn 20 10)
          (make-posn 20 20) (make-posn 10 20)))
  (add-line
    (add-line
      (add-line
        (add-line MT 10 10 20 10 "red")
        20 10 20 20 "red")
      20 20 10 20 "red")
    10 20 10 10 "red"))