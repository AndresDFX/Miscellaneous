;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname canibales_misioneros_1) (read-case-sensitive #t) (teachpacks ((lib "batch-io.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "batch-io.ss" "teachpack" "2htdp")))))
;; This is the missionaries & cannibals problem solved in Scheme.
;; The code is not as elegant as it could have been 
;; (lacking recursion, in the spirit of Scheme, in many places).
;; It is also not very generic. Also does no optimization and 
;; will apply search paths back and forth.

;; It works however, and should be relatively readable.

(use srfi-1)

(define m car)
(define c cadr)

(define (party? mc)
  (and (>= (c mc) 0)
       (>= (m mc) 0)
       (or (<= (m mc) 0)                ; no missionaries or
           (<= (c mc) (m mc))           ; m not outnumbered
           )))



(define (boat? sym)
  (any eq?
       `(L R l r)
       (make-list 4 sym)))

(begin (assert (boat? 'L))
       (assert (boat? 'l))
       (assert (boat? 'R))
       (assert (boat? 'r))
       (assert (not (boat? 'B))))

(define (L? b) (or (eq? 'L b)
                   (eq? 'l b)))

(define (state? state)
  (and (boat? (car state))
       (every party? (cdr state))))

(begin (assert (state? `(L (6 6) (0 0))))
       (assert (state? `(R (6 5) (0 1))))
       (assert (not (state? `(L (5 6) (1 0)))))
       (assert (not (state? `(R (0 0) (3 4)))))
       (assert (not (state? `(L (0 -1) (0 0))))))

(define left-side cadr)
(define right-side caddr)

(begin (assert (equal? `(1 1) (left-side  `(L (1 1) (0 0)))))
       (assert (equal? `(0 0) (right-side `(L (1 1) (0 0))))))

;; TODO check that applying action twice for any state has no effect
(define (apply-action state action)
  (define boat (car state))
  
  (or (state? state) (error "invalid state" state))

  `(,(if (L? boat) 'R 'L)
    ,(map (if (L? boat) - +) (left-side state) action)
    ,(map (if (L? boat) + -) (right-side state) action)))

(begin
  (assert (equal? `(R (5 5) (1 1))
                  (apply-action `(L (6 6) (0 0)) `(1 1))))
  (assert (equal? `(L (6 4) (2 0))
                  (apply-action `(R (5 3) (3 1)) `(1 1)))))


;; hard-coded solution taken from
;; http://www.aiai.ed.ac.uk/~gwickler/images/mc-search-space.png
(assert
 (equal? `(R (0 0) (3 3))
         (fold (lambda (a st)
                 (let ((s (apply-action st a)))
                   (and (state? s) s)))
               `(L (3 3) (0 0))
               `((0 2) (0 1) (0 2)
                 (0 1) (2 0) (1 1)
                 (2 0) (0 1) (0 2)
                 (1 0) (1 1) ))))

(define possible-actions `((0 1) (1 0) (1 1) (0 2) (2 0)))

;; reachable paths from `path`
(define (paths path)
  (define actions (cddr path))
  (define state (car path))
  (filter (lambda (st/a) (state? (car st/a)))
          (map (lambda (action)                  
                 (cons (apply-action state action)
                       (cons actions: 
                             (cons action actions))))
               possible-actions)))

;; input: list of paths. output: list of paths whose new state is
;; reachable from paths. no optimization (goes back and forth etc)
(define (search current-paths)
  (fold (lambda (path sum)
          (append (paths path) sum))
        '()
        current-paths))

(assert (equal?
         `(((R (0 0) (1 0)) actions: (1 0)))
         (search `(((L (1 0) (0 0)) actions:)))))

(define (goal? state)
  (equal? (left-side state) `(0 0)))

(begin (assert (goal? `(R (0 0) (3 3))))
       (assert (not (goal? `(R (0 1) (6 5)))))
       (assert (not (goal? `(R (6 6) (6 6))))))

(define initial-state `(L (3 3) (0 0)))

;; search repeatedly until goal-state found
(pp
 (let loop ((ps `((,initial-state actions:))))
   (let ((solutions (filter (compose goal? car) ps)))
     (if (null? solutions)
         (loop (search ps))
         solutions))))
