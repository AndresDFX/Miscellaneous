;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname ColocarImagen) (read-case-sensitive #t) (teachpacks ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp")))))
; Firma: Number String Image -> Image
; Propósito: añadir la cadena  s a la imágen img, y pixeles a partir de arriba, 
; 10 pixeles hacia la izquierda
; Encabezado: (define (agregar-imagen y s img) (empty-scene 100 100))

; ejemplos:
; dados:
; y igual a 5,
; s igual a "hola", y
; img igual a la escena vacía (empty-scene 100 100) 
; la respuesta esperada es:
; (place-image (text "hola" 10 "red") 10 5 (empty-scene 100 100))

; Plantilla de la solución
; (define (agregar-imagen y s img) (... y ... s ... img ...))

; Código de la solución
(define (agregar-imagen y s img)
  (place-image (text s 10 "red") 10 y img))

; Pruebas
(check-expect (agregar-imagen 5 "hola" (empty-scene 100 100))
        (place-image (text "hola" 10 "red") 10 5 (empty-scene 100 100)))
