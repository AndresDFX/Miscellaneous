;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname ejemploFuncionList) (read-case-sensitive #t) (teachpacks ((lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "universe.ss" "teachpack" "2htdp")))))
;;***************************************************
;;***** Ejemplo función list ************************
;;***************************************************

;short-hand                 long-hand
;(list "ABC")               (cons "ABC" empty)
;(list false true)          (cons false (cons true empty))
;(list 1 2 3)               (cons 1 (cons 2 (cons 3 empty)))

(list (list "bob" 0 "a")
      (list "carl" 1 "a")
      (list "dana" 2 "b")
      (list "erik" 3 "c")
      (list "frank" 4 "a")
      (list "grant" 5 "b")
      (list "hank" 6 "c")
      (list "ian" 8 "a")
      (list "john" 7 "d")
      (list "karel" 9 "e"))
