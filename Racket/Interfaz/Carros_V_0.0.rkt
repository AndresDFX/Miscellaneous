;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname Carros) (read-case-sensitive #t) (teachpacks ((lib "universe.ss" "teachpack" "2htdp") (lib "image.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "universe.ss" "teachpack" "2htdp") (lib "image.ss" "teachpack" "2htdp")))))
;****************************************************************************
;*******************   Carro 1  *********************************************
;****************************************************************************
;; Crea la imagen de carro , primera versión. 
;;*********************************************
(define carro1 
(overlay/xy
(ellipse 15 15 "solid" "black")
 -30
 -15
(overlay/xy
 (ellipse 15 15 "solid" "black")
 -5
 -15
 (overlay/xy
   (ellipse 28 18 "solid" "red")
   -10
   8
   (rectangle 50 15 "solid" "red")))))

;****************************************************************************
;*******************   Carro 2  *********************************************
;****************************************************************************
;; Crea la imagen de carro , otra versión del carro anterior. 
;;**************************************************************
(define chasis (overlay/xy
   (ellipse 28 18 "solid" "red")
   -10
   8
   (rectangle 50 15 "solid" "red")))

(define ruedas1 (overlay/xy
  (ellipse 15 15 "solid" "black")
  30
  0
  (ellipse 15 15 "solid" "black")))

(define ruedas2 (underlay/xy ruedas1 10 0 (rectangle 30 15 "solid" "black")))

(define carro2 (underlay/xy chasis 2 15 ruedas2))

;****************************************************************************
;*******************   Tanque  **********************************************
;****************************************************************************
;; Crea la imagen de un tanque, modificación de la versión del carro 2. 
;;************************************************************************

(define tanque (underlay/xy carro2 25 0 (rectangle 30 5 "solid" "red")))

;;***************************************************************************
;;*******************   Carro "libro"  **************************************
;;***************************************************************************
;; Crea la imagen de un carro, este es el carro del libro. 
;;************************************************************************
(define WHEEL-RADIUS 5)

(define WHEEL-DISTANCE (* WHEEL-RADIUS 5))

(define BODY-LENGTH (+ WHEEL-DISTANCE (* 6 WHEEL-RADIUS)))

(define BODY-HEIGHT (* WHEEL-RADIUS 2))

(define WHL (circle WHEEL-RADIUS "solid" "black"))

(define BDY
  (above
    (rectangle (/ BODY-LENGTH 2) (/ BODY-HEIGHT 2)
               "solid" "red")
    (rectangle BODY-LENGTH BODY-HEIGHT "solid" "red")))

(define SPC (rectangle WHEEL-DISTANCE 1 "solid" "white"))
(define WH* (beside WHL SPC WHL))
(define CAR (underlay/xy BDY WHEEL-RADIUS BODY-HEIGHT WH*))


;;*******************************************************************************
;;*******************   Animación  **********************************************
;;*******************************************************************************
;; Animación del carro, se presentan las propuestas realizadas en el texto guía. 
;;*******************************************************************************

;; AnimaImagen -> Image
;; Modifica la imagen conforme la posición
(define (AnimaImagen pos)
  (cond 
    [(< pos 100) CAR]
    [(< pos 200) carro1]
    [(< pos 300) carro2]
    [else tanque]))

;; CarState -> Image
;; place the car into a scene, according to the given world state
(define (pintar ws)
  (place-image (AnimaImagen ws) ws 25  (rectangle 400 50 "solid" "gray"))) 
  ;;(place-image tree ws 25  (rectangle 400 50 "solid" "gray"))) 
  ;;(place-image CAR ws Y-CAR BACKGROUND))

;; AnimationState is a Number
;; interp. the number of clock ticks since the animation started
(animate pintar)