;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-advanced-reader.ss" "lang")((modname distancias) (read-case-sensitive #t) (teachpacks ((lib "draw.ss" "teachpack" "htdp"))) (htdp-settings #(#t constructor repeating-decimal #t #t none #f ((lib "draw.ss" "teachpack" "htdp")))))
;; ***************************************************************
;; ********************** Sin acumulación ************************
;; ***************************************************************
;; relativa-a-absoluta : (listade número) -> (listade número)
;; para convertir una lista de distancias relativas a una lista de distancias absolutas
;; el primer ítem en la lista representa la distancia al origen
(define (relativa-a-absoluta uldn)
  (cond
    [(empty? uldn) empty]
    [else (cons (first uldn)
                (agrega-a-todos (first uldn) 
                                (relativa-a-absoluta (rest uldn))))]))
;; agrega-a-todos : número (listade número) -> (listade número)
;; para agregar n a cada número en uldn
(define (agrega-a-todos n uldn)
  (cond
    [(empty? uldn) empty]
    [else (cons (+ (first uldn) n) 
                (agrega-a-todos n (rest uldn)))]))



;; ***************************************************************
;; ********************** Con acumulación ************************
;; ***************************************************************
;; relativa-a-absoluta2 : (listade número) -> (listade número)
;; para convertir una lista de distancias relativas a una lista de distancias absolutas
;; el primer ítem en la lista representa la distancia al origen
(define (relativa-a-absoluta2 uldn)
  (local ((define (rel-a-abs uldn dist-acu)
            (cond
              [(empty? uldn) empty]
              [else (cons (+ (first uldn) dist-acu)
                          (rel-a-abs (rest uldn) 
                                     (+ (first uldn) dist-acu)))])))
    (rel-a-abs uldn 0)))


