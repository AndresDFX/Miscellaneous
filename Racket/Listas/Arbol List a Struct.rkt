;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |Arbol List a Struct|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;========Definicion de Estructura;=========
(define-struct nodo (dat izq der))

;Nodo Ejemplo
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

;CODIGO
(define (Construct A)
        (cond[(empty? A) empty]
             [(es-hoja? A)(make-nodo (first A) empty empty)]
             [else (cond [(number? (first A)) (make-nodo (first A) (Construct(izquierdo A))(Construct(derecho A)))]
                         [else (Construct (rest A))])]))

;EJEMPLO
(Construct x) ;->(make-nodo 2 (make-nodo 7 (make-nodo 2 '() '())(make-nodo 6 (make-nodo 5 '() '())(make-nodo 11 '() '())))(make-nodo 5 '()(make-nodo 9 (make-nodo 4 '() '()) '())))