;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname AterrizajeOvni) (read-case-sensitive #t) (teachpacks ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp")))))
; EstadoMundo es un Number
; Representa la altura del OVNI (desde arriba)
 
; constantes:
(define AMPLITUD 300)
(define ALTURA 500)
(define PROXIMIDAD (/ ALTURA 3))
 
; visual constants:
(define MT (empty-scene AMPLITUD ALTURA))
(define OVNI
  (overlay (circle 10 "solid" "green")
           (rectangle 40 2 "solid" "green")))
 
; EstadoMundo -> EstadoMundo
; calcula la siguiente localización del  OVNI
 
(check-expect (sig 11) 14)
 
(define (sig y)
  (+ y 3))
 
; EstadoMundo -> Image
; coloca el  OVNI a la  altura dada por el estado en el centro de MT
 
(check-expect (graficar 11)
              (place-image OVNI (/ AMPLITUD 2) 11 MT))
 
(define (graficar y)
  (place-image OVNI (/ AMPLITUD 2) y MT))
 
; Programa principal
; EstadoMundo -> EstadoMundo
(define (crear-mundo estado)
  (big-bang estado (on-tick sig) (to-draw graficar)))
