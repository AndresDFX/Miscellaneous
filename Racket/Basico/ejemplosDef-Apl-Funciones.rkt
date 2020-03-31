;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname ejemplosDef-Apl-Funciones) (read-case-sensitive #t) (teachpacks ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp")))))
;; Ejemplos de definición de funciones

(define (f x) 1)

(define (g x y) (+ 1 1))

(define (h x y z) (+ (* 2 2) 3))

(define (ff a)
  (* 10 a))

;; Ejemplos de Aplicación de funciones
(f 1)
(f 2)
(f "hello world")
(f true)
(f (circle 3 "solid" "red"))
(f)
(+)
(f (+ 1 1))
(ff (+ 1 1))
(+ (ff 3) 2)
(* (ff 4) (+ (ff 3) 2))
(string-append "hello" " " "world")
