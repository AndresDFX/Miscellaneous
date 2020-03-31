;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname inversa) (read-case-sensitive #t) (teachpacks ((lib "batch-io.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "batch-io.ss" "teachpack" "2htdp")))))
;; ***************************************************************
;; ********************** Inversa ********************************
;; ***************************************************************
;; invierte : (lista de X) -> (lista de X)
;; construir la inversa de uldx
;; recursión estructural
(define (invierte uldx)
  (cond
    [(empty? uldx) empty]
    [else (haz-último-ítem (first uldx) (invierte (rest uldx)))]))

;; haz-último-ítem : X (lista de X) -> (lista de X)
;; agrega una-x al final de uldx
;; recursión estructural
(define (haz-último-ítem una-x uldx)
  (cond
    [(empty? uldx) (list una-x)]
    [else (cons (first uldx) (haz-último-ítem una-x (rest uldx)))]))

(invierte (list 1 2 3 4))