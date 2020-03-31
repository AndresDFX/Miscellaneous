;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |Arbol Struct a List|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;EStructura nodo
(define-struct nodo (dat izq der))

;Ejemplo de árbol
(define x(make-nodo 2 
  (make-nodo 7 
    (make-nodo 2 empty empty)
    (make-nodo 6
     (make-nodo 5 empty empty)
     (make-nodo 11 empty empty))) 
  (make-nodo 5
    empty
    (make-nodo 9 
      (make-nodo 4 empty empty)
    empty))))

;Operación principal
(define (es_hoja? un-nodo)
  (cond
   [(and 
     (empty? (nodo-izq un-nodo))
     (empty? (nodo-der un-nodo))) true]
   [else false]))

;CODIGO
(define (Construct A)
        (cond[(empty? A) empty]
             [(es_hoja? A)(list (nodo-dat A))]
             [else (cond [(number? (nodo-dat A)) (list (nodo-dat A) (Construct(nodo-izq A))(Construct(nodo-der A)))]
                         [else (list(Construct (nodo-izq A)) (Construct (nodo-der A)))])]))

;EJEMPLO           
(Construct x) ;-> (cons 2 (cons (cons 7 (cons (cons 2 '())(cons (cons 6 (cons (cons 5 '())(cons (cons 11 '()) '())))'())))(cons(cons 5 (cons '()(cons(cons 9 (cons (cons 4 '()) (cons '() '())))  '()))) '())))
