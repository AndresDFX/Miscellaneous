#lang racket

;Funcion que retorna la lista de archivos del directorio actual
(define lista (map path->string (directory-list)))

;Definicion de procedimiento que filtra los archivos .rkt
(define procedimiento
  (lambda (L)
    (cond [(empty? L) empty]
          [(equal? (cadr(split-string (car L))) "rkt") (cons (car L) (procedimiento (cdr L)) )]
          [else (procedimiento (cdr L))])))

;Rtornar la lista de archivos .rkt del directorio actual
(define lista1 (procedimiento lista))
