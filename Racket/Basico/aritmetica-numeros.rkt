;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname aritmetica-numeros) (read-case-sensitive #t) (teachpacks ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor mixed-fraction #f #t none #f ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp")))))
;Archivo con ejemplos de números y operaciones con números, 
;si lo ejecuta encuentra el resultado de las operaciones

;Números:
;En lenguaje scheme se pueden representar números: naturales,
;enteros, y racionales, de forma exacta, y números reales y complejos de forma inexacta.  
;En principio no hay restricción de la cantidad de números que se pueden representar 
;(más allá de la memoria para almacenarlos)

; Números exactos
; Números naturales:
0 
1 
58 
327

; Números enteros: Además de los naturales, los números negativos 
-5
-38
-567

; Números racionales: p/q, p y q enteros
2/3      
17/3 

; Números inexactos 
; Números irracionales: que no se pueden expresar como cociente de dos enteros

#i3.141592653589793
#i2.718281828459045
#i1.4142135623730951
pi
e

; Números complejos: No los utilizaremos en el curso

;Operaciones básicas con números

;suma
(+ 5 5)      (+ -5 5)     (+ 5 -5)     
;resta
(- 5 5)     
;multiplicación
(* 3 4)      
;división
(/ 8 12)  

; Las expresiones matemáticas pueden ir anidadas 
; (los operadores pueden ser otras expresiones matemáticas)
; se resuelven primero los parentesis internos que estén más 
; a la izquierda

(* (+ 2 2) (/ (* (+ 3 5) (/ 30 10)) 2))
 
; Algunos ejemplos de otras operaciones:

(sqrt 9) ;para raiz cuadrada de 9
(sqrt 2) ;para raiz cuadrada de 2

(expt 2 3) ; para potencias base 2, exponente 3

(remainder 5 2) ; para calcular el residuo de la división entera;
(quotient 5 2) ; para calcular el cociente de la división entera;

(log 2) ; para calcular el logaritmo natural de 2
(log e) ; para calcular el logaritmo natural de e
(sin pi) ; calcula el seno de pi (en radianes)
(sin (/ pi 2)) ; calcula el seno de pi/2 (en radianes)

; Algo de álgebra
; dado un punto (x,y) en el plano, calcule su distancia al origen

(define x 3)
(define y 4)
(sqrt (+ (* x x) (* y y)))
