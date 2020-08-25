;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname encontrarcaminografo) (read-case-sensitive #t) (teachpacks ((lib "batch-io.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "batch-io.ss" "teachpack" "2htdp")))))
;; ***************************************************************
;; ***** Encontrar una ruta en una gráfica simple (versión 1)*****
;; ***************************************************************

;; existe-ruta? : nodo nodo gráfica-simple -> bolean
;; para determinar si hay una ruta desde orig a dest en sg
(define (existe-ruta? orig dest sg)
  (cond
    [(symbol=? orig dest) true]
    [else (existe-ruta? (vecino orig sg) dest sg)]))

;; vecino : nodo gráfica-simple -> nodo
;; para determinar el nodo con el cual está conectado un-nodo en sg
(define (vecino un-nodo sg)
  (cond
    [(empty? sg) (error "vecino: imposible")]
    [else (cond
            [(symbol=? (first (first sg)) un-nodo)
             (second (first sg))]
            [else (vecino un-nodo (rest sg))])]))

;(existe-ruta? 'C 'D '((A B) (B C) (C E) (D E) (E B) (F F)))
;(existe-ruta? 'E 'D '((A B) (B C) (C E) (D E) (E B) (F F)))
;(existe-ruta? 'B 'D '((A B) (B C) (C E) (D E) (E B) (F F)))
;(existe-ruta? 'C 'D '((A B) (B C) (C E) (D E) (E B) (F F)))
;(existe-ruta? 'A 'D '((A B) (B C) (C E) (D E)))

;; existe-ruta-acu? : nodo nodo gráfica-simple (listade nodo) -> boolean
;; para determinar si hay una ruta del orig al dest en sg,
;; se asume que los nodos en acu-visto se han examinado ya
;; y falló en entregar una solución
      (define (existe-ruta-acu? orig dest sg acu-visto)
        (cond
         [(symbol=? orig dest) true]
         [else (existe-ruta-acu? (vecino orig sg) dest sg
                          (cons orig acu-visto))]))


;(existe-ruta-acu? 'C 'D '((A B) (B C) (C E) (D E) (E B) (F F)) empty)
;(existe-ruta-acu? 'E 'D '((A B) (B C) (C E) (D E) (E B) (F F)) '(C))
;(existe-ruta-acu? 'B 'D '((A B) (B C) (C E) (D E) (E B) (F F)) '(E C))
;(existe-ruta-acu? 'C 'D '((A B) (B C) (C E) (D E) (E B) (F F)) '(B E C))

;; ***************************************************************
;; ***** Encontrar una ruta en una gráfica simple (versión 2)*****
;; ***************************************************************
;; existe-ruta2? : nodo nodo gráfica-simple -> boolean
;; para determiner si hay una ruta de orig a dest en sg
(define (existe-ruta2? orig dest sg)
  (local ((define (re-accu? orig dest sg acu-visto)
            (cond
              [(symbol=? orig dest) true]
              [(contiene orig acu-visto) false]
              [else (re-accu? (vecino orig sg) dest sg
                              (cons orig acu-visto))])))
    (re-accu? orig dest sg empty)))

(define (contiene orig l)
  (cond
    [(empty? l) false] 
    [(symbol=? (first l) orig) true]
    [else (contiene orig (rest l))]))

(existe-ruta2? 'C 'D '((A B) (B C) (C E) (D E) (E B) (F F)))
;(existe-ruta2? 'E 'D '((A B) (B C) (C E) (D E) (E B) (F F)))
;(existe-ruta2? 'B 'D '((A B) (B C) (C E) (D E) (E B) (F F)))
;(existe-ruta2? 'C 'D '((A B) (B C) (C E) (D E) (E B) (F F)))
(existe-ruta2? 'A 'E '((A B) (B C) (C E) (D E) (E B) (F F)))