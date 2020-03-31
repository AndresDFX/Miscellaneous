;; The first three lines of this file were inserted by DrScheme. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-advanced-reader.ss" "lang")((modname arbin_listas) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #t #t none #f ())))
;; The first three lines of this file were inserted by DrScheme. They record metadata
;; about the language level of this file in a form that our tools can easily process.

;Un nodo es:
;1. empty
;2. (list  <nombre>  <madre>  <padre>)

; Nodo Ejemplo
(define x (list 2
  (list 7
    (list 2 empty empty)
    (list 6
      (list 5 empty empty)
      (list 11 empty empty)))
  (list 5
    empty
    (list 9
      (list 4 empty empty)
      empty))))
;Operaciones principales
(first (rest x))
(first (rest (first (rest x))))

;es-hoja?
(define (es-hoja? nodo)
 (cond
   [(and 
      (empty? (izquierdo nodo))
      (empty? (derecho nodo))) true]
   [else false]))

;árbol-izquierdo
(define (izquierdo nodo)
 (first (rest nodo)))
;árbol-derecho
(define (derecho nodo)
  (first (rest (rest nodo))))

;Cuantos nodos tiene un arbol
;cuantos: arbol -> numero
;Propósito: contar cuantos nodos tiene un árbol
;Análisis de datos:
;1. Si el árbol es vacío: la cantidad de nodos es cero
;2. Si el árbol es una hoja: la cantidad de nodos es uno
;3. De lo contrario: la cantidad de nodos es 1+cantidad_nodos_izq+ cantidad_nodos_der
;Ejemplos: 

; (cuantos (list 11 
;           (list 12 
;                      (list 4 empty empty)
;                      (list 16 empty empty))
;           (list 3
;                      (list 7 empty empty)
;                      (list 8 empty empty)))) "debe retornar 7"

;******************************************************************

;(cuantos (list 2 
;  (list 7 
;    (list 2 empty empty)
;    (list 6
;     (list 5 empty empty)
;     (list 11 empty empty))) 
;  (list 5
;    empty
;    (list 9 
;      (list 4 empty empty)
;    empty))))) "debe retornar 9"
;******************************************************************
;(cuantos (list 18
;           (list 2 
;                      (list 6 
;                                 (list 21 empty empty)
;                                 (list 5 empty empty))
;                      (list 3 
;                                 (list 15 
;                                            (list 24 empty empty)
;                                            empty)
;                                 empty))
;           (list 3
;                      (list 7 empty empty)
;                      (list 12 
;                                 (list 2 empty empty)
;                                 (list 3 empty empty)))) ) "debe retornar 13"
;******************************************************************
(define (cuantos arbol)
  (cond
    [(empty? arbol) 0]
    [(es-hoja? arbol) 1]
    [else (+  1 (cuantos (izquierdo arbol)) (cuantos (derecho arbol)))]
    ))

;********************************************************************
;Pruebas: 
(cuantos empty) "Debe retornar 0"
;********************************************************************
(cuantos (list 4 empty empty)) "Debe retornar 1"
;********************************************************************
(cuantos (list 2
  (list 7
    (list 2 empty empty)
    (list 6
      (list 5 empty empty)
      (list 11 empty empty)))
  (list 5
    empty
    (list 9
      (list 4 empty empty)
      empty)))) "Debe retornar 9"
;********************************************************************
 (cuantos (list 11 
           (list 12 
                      (list 4 empty empty)
                      (list 16 empty empty))
           (list 3
                      (list 7 empty empty)
                      (list 8 empty empty)))) "debe retornar 7"
;******************************************************************
(cuantos (list 18
           (list 2 
                      (list 6 
                                 (list 21 empty empty)
                                 (list 5 empty empty))
                      (list 3 
                                 (list 15 
                                            (list 24 empty empty)
                                            empty)
                                 empty))
           (list 3
                      (list 7 empty empty)
                      (list 12 
                                 (list 2 empty empty)
                                 (list 3 empty empty)))) ) "debe retornar 13"

