;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname EjemplosStruct_3) (read-case-sensitive #t) (teachpacks ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp")))))
; Un partido de fútbol americano está dividido en cuatro periodos.

; Durante cada periodo, ambos equipos buscan alcanzar el mayor
; número  de  puntos,  de  tal  manera  que  al  final  de  partido  el
; número total de puntos del equipo sea superior al número total
; de puntos del equipo contrario.

; Nuestro   objetivo   es  obtener   información   estadística  de   un
; equipo en un juego.

; Análisis y Definición de Datos
(define-struct juego (primero segundo tercero cuarto))
; Un juego es una estructura: (make-juego a b c d)
; donde a, b, c, d son números que representan los
; puntos obtenidos durante el periodo 1,2,3 y 4
; respectivamente.

; Contrato: 
; Propósito: Propósito: A partir de un juego determinar el 
; número promedio de puntos obtenido por el equipo en el juego.
; La firma es:  juego --> número  
; El encabezado es (define (promedio-juego juego))

; Ejemplos:
;(promedio-juego (make-juego 7 0 14 3))
; debe producir 6
; (promedio-juego (make-juego 7 7 0 14))
; debe producir 7
; (promedio-juego (make-juego 0 0 0 0))
; debe producir 0

; Bosquejo o plantilla de solución.
; (define (función unJuego)
; ... (juego-primero unJuego)...
; ... (juego-segundo unJuego)...
; ... (juego-tercero unJuego)...
; ... (juego-cuarto unJuego)...)

; Definición:
(define (promedio-juego unJuego)
  (/
   (+ (juego-primero unJuego)
      (juego-segundo unJuego)
      (juego-tercero unJuego)
      (juego-cuarto unJuego)) 4))

; Pruebas:
(check-expect (promedio-juego (make-juego 7 0 14 3)) 6)
(check-expect (promedio-juego (make-juego 7 7 0 14)) 7)
(check-expect (promedio-juego (make-juego 0 0 0 0)) 0)