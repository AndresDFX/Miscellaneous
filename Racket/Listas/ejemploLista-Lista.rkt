;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname ejemploLista-Lista) (read-case-sensitive #t) (teachpacks ((lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "universe.ss" "teachpack" "2htdp")))))
;;***************************************************
;;***** Listas en las lista ********************
;;***************************************************

(require 2htdp/batch-io)
(read-file "ttt.txt")

; A LLS is one of:
; – empty
; – (cons Los LLS)
; interp. a list of lines, each line is a list of strings
 
(define line0 (cons "hello" (cons "world" empty)))
(define line1 empty)
 
(define lls0 empty)
(define lls1 (cons line0 (cons line1 empty)))
 
; LLS -> List-of-numbers
; determine the number of words on each line
 
(check-expect (words-on-line lls0) empty)
(check-expect (words-on-line lls1) (cons 2 (cons 0 empty)))
 
(define (words-on-line lls)
  (cond
    [(empty? lls) empty]
    [else (cons (length (first lls))
                (words-on-line (rest lls)))]))

; String -> List-of-numbers
; count the number of words on each line in the given file
(define (file-statistic file-name)
  (words-on-line
    (read-words/line file-name)))

(file-statistic "ttt.txt")