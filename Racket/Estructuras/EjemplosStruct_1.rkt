;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname EjemplosStruct_1) (read-case-sensitive #t) (teachpacks ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp")))))
; Contrato: 

; Propósito: A partir de un punto, un color a sustituir y un color sustituto, 
; retornar un punto donde en lugar del color a sustituir aparezca el color sustituto.  
; Si el color a sustituir no está, se retorna el mismo punto.

; Análisis y Definición de Datos 
(define-struct punto (x y color)) 
; Un punto es una estructura:(make-punto a b c)
; donde a y b son números, y c es un símbolo.

; La firma es: punto, símbolo1 símbolo2 -> punto 
; Los símbolos corresponden al color que se desea sustituir y al color actual.
; El encabezado es (define (sustitución punto colorSustituir colorSustituto)

; Ejemplos:
; (sustitución (make-punto 3 4 'rojo) 'rojo 'azul) 
;  debe producir (make-punto 3 4 'azul)
; (sustitución (make-punto 3 4 'verde) 'azul 'rojo) 
;  debe producir (make-punto 3 4 'verde)

; Bosquejo o plantilla de solución.
; (define (funcion unPunto) 
;  ... (punto-x unPunto) ... 
;  ... (punto-y unPunto) ...
;  ... (punto-color unPunto) ... ) 

;;Definición
(define (sustitución unPunto colorAnterior colorPosterior) 
  (cond 
    [(symbol=? (punto-color unPunto) colorAnterior) 
     (make-punto (punto-x unPunto) 
                 (punto-y unPunto) 
                 colorPosterior)] 
    [else unPunto]))

;; Pruebas: 
(check-expect (sustitución (make-punto 3 4 'rojo) 'rojo 'azul) (make-punto 3 4 'azul))
(check-expect (sustitución (make-punto 5 6 'verde) 'azul 'amarillo) (make-punto 5 6 'verde))
