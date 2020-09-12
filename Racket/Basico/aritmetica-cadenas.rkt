;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname aritmetica-cadenas) (read-case-sensitive #t) (teachpacks ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp")) #f)))
; Aritmética de cadenas

; Concatenación de cadenas
(string-append "Que rico es " "aprender los fundamen" "tos de la programación")

; Construya a partir de las dos variables siguientes la cadena "Hola Mundo"
(define prefijo "Hola")
(define sufijo "Mundo")

; Calculando la longitud de una cadena
(string-length "Cuanto mido?")

; Extraer el (i+1)-ésimo caracter de una cadena
(string-ith "1234567" 5)

; Convertir un número en cadena
(number->string 100)

; Extraer una subcadena
(substring "0123456" 1 4)
(substring "0123456" 1)
(substring "0123456" 2)

; Procedimiento que convierte un string a lista dado el valor de sep(en este caso .), funciona como un SPLIT
(define (split-string s (sep #\.))
  (define (rec-split sl sep (acc '()) (h-acc '()))
    (cond ((empty? sl) (reverse (map (lambda (isl) (list->string isl))
                                     (cons (reverse h-acc) acc))))
          ((char=? (car sl) sep) (rec-split (cdr sl) sep (cons (reverse h-acc) acc) '()))
          (else (rec-split (cdr sl) sep acc (cons (car sl) h-acc)))))
  (rec-split (string->list s) sep))