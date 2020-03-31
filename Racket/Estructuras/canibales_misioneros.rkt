;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname canibales_misioneros) (read-case-sensitive #t) (teachpacks ((lib "batch-io.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "batch-io.ss" "teachpack" "2htdp")))))
;;  Comp210 03.spring hw10 solution
;;  Cannibals and Missionaries
;;  Ian Barland, 96.Oct.16
;;  minor touch-ups 01.nov; added boatloads as a function of #miss.

; The total number of missionaries, cannibals:
(define totalCanns  3)
(define totalMisses totalCanns)
(define boat-capacity 2)


;; (map-append f l): (alpha-->list-of-beta),list-of-alpha --> list-of-beta
;; Map f onto each element of l,
;; appending all the results (since f returns a list).
(define (map-append f l)
  (foldr append empty (map f l)))


;;;  =================
;;;  Now, the functions specific to missionary/cannibals
;;;  =================
;;;
;; A state of the game is:
;;
;; (make-state left right boat-side moves2here history)
;; where
;; left, right are groups
;;   (on the left and right banks of the river)
;; boat is a side, and
;; history is a list of states
;; moves2here is a list of moves
;;
;; A side is 'left or 'right.
;;
;; A group is (make-group missus canns),
;; where missus and canns are numbers
;;   (of missionaries and cannibals, respectively)
(define-struct group (missus canns))
(define-struct state (left
                      right
                      boat
                      moves2here
                      history))
(define left-bank  'left)
(define right-bank 'right)

; The initial state:
(define start (make-state (make-group totalMisses totalCanns)
			  (make-group 0 0)
			  left-bank
			  empty
			  empty))

;; (done? g): state --> boolean
;; Return true if nobody on left bank.
(define (done? g)
    (and (zero? (group-canns  (state-left g)))
	 (zero? (group-missus (state-left g)))))
     



;; (other-bank s): side --> side
(define (other-bank s)
    (cond [(eq? s left-bank)  right-bank]
	  [(eq? s right-bank) left-bank]
	  [else (error 'other-bank "bad side ~s~n" s)]))

;; (group-combine op): (num, num --> num) --> (group group --> group)
;; group+ : group, group --> group
;; group- : group, group --> group
;; Given binary function op, return a binary function on groups
;; which just combines the fields (component-wise) using op.
(define (group-combine op)
    (lambda (g1 g2)
      (make-group (op (group-missus g1) (group-missus g2))
		  (op (group-canns  g1) (group-canns  g2)))))

(define group- (group-combine -))
(define group+ (group-combine +))


;; safe-state?: state --> boolean
;; Is state both legal, and non-fatal to missionaries?
;; ;and never-before-seen?
(define (safe-state? state)
    (and (safe-bank? (state-left  state))
	 (safe-bank? (state-right state))))
	 ;  optional: check for repeated state:
         ;(history-never-repeats state (state-history state))))


;; (safe-bank? g)
;; g is a group
;; determine whether that group is safe and legal --
;; no outnumbered missionaries, no negative numbers
(define (safe-bank? g)
    (and (not (negative? (group-missus g)))
	 (not (negative? (group-canns  g)))
	 (or  (zero? (group-missus g))
	      (>= (group-missus g)
		  (group-canns  g)))))


;; my-and:  same as and
;; (except it doesn't short cut, since it's a real function.)
;; For use with "fold", since we can't pass in "and" as a fucntion.
;; NB Really, the write solution is to use "andmap" (see HelpDesk).
(define (my-and x y) (and x y))

;; (history-never-repeats state annals): state,list-of-state --> boolean
;; Return true is annals doesn't contain a state similar
;; to state (I.e., same groups on either side of river, same boat position)
;;
;; You were NOT required to do this filtering.
(define (history-never-repeats state annals)
  (foldl my-and true (map (lambda (past) (dissimilar? state past)) annals)))
  ; or: (andmap (lambda (past) (dissimilar? state past)) annals)


;; (dissimilar? st1 st2): state,state --> boolean
;; Return true iff the two states are different
;; We could actually get by with only checking equality of one bank,
;; since this should determine the other, but doesn't hurt to check.
(define (dissimilar? st1 st2)
    (or (dissimilar-banks? (state-left  st1) (state-left  st2))
	(dissimilar-banks? (state-right st1) (state-right st2))
	(not (eq? (state-boat st1) (state-boat st2)))))

;; (dissimilar-banks? b1 b2): bank,bank --> boolean
;; return true iff the groups b1 and b2 are different
(define (dissimilar-banks? g1 g2)
    (or (not (= (group-missus g1) (group-missus g2)))
	(not (= (group-canns  g1) (group-canns  g2)))))

;; boatloads<= : natNum --> list-of-boatloads
;; Return all boatloads with n or fewer people.
(define (boatloads<= n)
  (cond [(zero? n) empty]
        [(positive? n) (append (boatloads= n n) (boatloads<= (sub1 n)))]))

;; boatloads= : natNum, natNum --> list-of-boatloads
;; Return all boatloads with exactly n people,
;; k or fewer of which are cannibals.
(define (boatloads= n k)
  (cond [(negative? k) empty]
        [(positive? n) (cons (make-group k (- n k))
                             (boatloads= n (sub1 k)))]))

;; all-possible-boatloads
;; A list of all groups that could fit in a boat.
;; Used by next.
(define all-possible-boatloads  (boatloads<= boat-capacity))

;;; ================
;;; Finally, the main functions of the search engine.
;;; ================

;; (next curr-state): state --> list-of-states
;; Return a list of states reachable from curr-state
;; in one boattrip.
(define (next curr-state)
    (map (lambda (mv) (make-move curr-state mv))
	 all-possible-boatloads))

;; (make-move st mv): state, group --> state
;; st is a state, mv is a group
;; move the group mv across the river,
;; returning that new state.

;; N.B. "let*" is a low-tech version of "local".
(define (make-move st mv)
    (let* ((l2r (eq? left-bank (state-boat st)))
	   (new-left  ((if l2r group- group+)
		       (state-left st) mv))
	   (new-right ((if l2r group+ group-)
		       (state-right st) mv)))
      (make-state new-left
		  new-right
		  (other-bank (state-boat st))
		  (cons mv (state-moves2here st))
		  (cons st (state-history st)))))

;; (find-soln states): list-of-states --> list-of-trips or false or (diverge).
;; Given a list of current possible states,
;; search for a solution from any of these states,
;; and return the list of boat-trips to the solution.
;; Return false if there is clearly know solution.
;; It's possible this function could also run forever, if there were
;; no solution.

;; The work-horse of the entire program is the line
;;     (filter safe-state? (map-append next states))
;; which, for each state, finds the next state,
;; filters out all the non-legal states;
;; we can then recur on this new list of states.

;; N.B. "let" is a very low-tech variant of "local".
(define (find-soln states)
    (let [(win-states (filter done? states))]
      (cond [(empty? states) false]
	    [(empty? win-states)
	     (find-soln (filter safe-state?
				(map-append next states)))]
	    [else ; yahoo! a winning state
	     (reverse (state-moves2here (first win-states)))])))

;; (solve): {} --> list-of-trips or false or (diverge).
;; Get those missionary & cannibals going;
;; return a solution (list of boat trips), or false (known no solution),
;; or might run forever if no solution.
(define (solve x) ;; x is bogus parameter to satisfy the Intermediate Language Level requirement.
    (find-soln (list start)))

;;; ========
;;; tests
;;; ========

;(define m0 (make-move start (make-group 0 0)))
;(safe-state? m0)
;(define m1 (make-move start (make-group 1 1)))
;(safe-state? m1)
;(define m2 (make-move m1 (make-group 1 0)))
;(safe-state? m2)
;(define m3 (make-move m2 (make-group 0 1)))
;(safe-state? m3)
;(define m4 (make-move m3 (make-group 1 0)))
;(safe-state? m4)
;(time-apply solve)

(solve 0)