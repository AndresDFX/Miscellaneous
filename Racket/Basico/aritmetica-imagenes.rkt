;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname aritmetica-imagenes) (read-case-sensitive #t) (teachpacks ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp")))))
; Aritmética de imágenes

; Funciones para crear figuras básicas 
; circle, elipse, line, rectangle, text, triangle, regular-polygon

(circle 5 "solid" "black")

(rectangle (/ 55 2) (/ 10 2) "solid" "red")
(rectangle 55 10 "solid" "red")
(rectangle 25 1 "solid" "white")

(ellipse 40 40 "outline" "maroon")

(line 30 30 "black")
(line -30 30 "red")

(text "Bienvenidos" 36 "indigo")

(triangle 40 "solid" "tan")

; Funciones para componer figuras
(above (rectangle (/ 55 2) (/ 10 2) "solid" "red")
      (rectangle 55 10 "solid" "red"))

(beside (circle 5 "solid" "black") 
       (rectangle 25 1 "solid" "white") 
       (circle 5 "solid" "black"))

(underlay (above (rectangle (/ 55 2) (/ 10 2) "solid" "red")
                (rectangle 55 10 "solid" "red"))
         (beside (circle 5 "solid" "black") 
                (rectangle 25 1 "solid" "white") 
                (circle 5 "solid" "black")))  

(underlay/xy  (above (rectangle (/ 55 2) (/ 10 2) "solid" "red")
                    (rectangle 55 10 "solid" "red"))
             5 
             10 
             (beside (circle 5 "solid" "black") 
                    (rectangle 25 1 "solid" "white") 
                    (circle 5 "solid" "black")))

; Funciones para escenas animadas y juegos

(empty-scene 500 100)

(place-image (underlay/xy  (above (rectangle (/ 55 2) (/ 10 2) "solid" "red")
                                 (rectangle 55 10 "solid" "red"))
                          5 
                          10 
                          (beside (circle 5 "solid" "black") 
                                 (rectangle 25 1 "solid" "white") 
                                 (circle 5 "solid" "black")))
            250
            50
            (empty-scene 500 100))

(add-line (empty-scene 500 100) 20 99 400 99 "red")

(add-line (rectangle 40 40 "solid" "gray")
            -10 50 50 -10 "maroon")

; Funciones que extraen propiedades de las figuras

(image-width (ellipse 30 40 "solid" "orange"))
(image-width (circle 30 "solid" "orange"))
(image-height (ellipse 30 40 "solid" "orange"))
(image-height (circle 30 "solid" "orange"))
(image-height (overlay (circle 20 "solid" "orange")
                         (circle 30 "solid" "purple")))