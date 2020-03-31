;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname ejemploLista-Estructuras-Editor) (read-case-sensitive #t) (teachpacks ((lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "universe.ss" "teachpack" "2htdp")))))
;;****************************************************
;;***** Listas en las Estructuras ********************
;;****************************************************

(require 2htdp/image)
(define-struct editor (pre post))
; An Editor is (make-editor Lo1S Lo1S)
; An Lo1S is one of:
; – empty
; – (cons 1String Lo1S)

(define good
  (cons "g" (cons "o" (cons "o" (cons "d" empty)))))
(define all
  (cons "a" (cons "l" (cons "l" empty))))
(define lla
  (cons "l" (cons "l" (cons "a" empty))))
 
; data example 1:
(make-editor all good)
 
; data example 2:
(make-editor lla good)

; Lo1s -> Lo1s
; produce a reverse version of the given list
 
(check-expect
  (rev (cons "a" (cons "b" (cons "c" empty))))
  (cons "c" (cons "b" (cons "a" empty))))

(define (rev l)
  (cond
    [(empty? l) empty]
    [else (add-at-end (rev (rest l)) (first l))]))

; Lo1s 1String -> Lo1s
; create a new list by adding s to the end of l
(define (add-at-end l s)
  (cond
    [(empty? l) (cons s empty)]
    [else (cons (first l) (add-at-end (rest l) s))]))

(check-expect
  (add-at-end (cons "c" (cons "b" empty)) "a")
  (cons "c" (cons "b" (cons "a" empty))))

; constants
(define HEIGHT 20) ; the height of the editor
(define WIDTH 200) ; its width
(define FTSZ 11) ; the font size
(define FTCL "black") ; the font color
 
; graphical constants
(define MT (empty-scene WIDTH HEIGHT))
(define CU (rectangle 1 HEIGHT "solid" "red"))

; Editor -> Image
; render an editor as an image of the two texts separated by the cursor
;(define (editor-render e)
;  (place-image/align
;    (beside (editor-text (reverse (editor-pre e)))
;            CU
;            (editor-text (editor-post e)))
;    1 1
;    "left" "top"
;    MT))
 
; Editor -> Image
(define (editor-render e)
  (place-image/align
    (beside (editor-text (editor-pre e))
            CU
            (editor-text (editor-post e)))
    1 1
    "left" "top"
    MT))

; Editor KeyEvent -> Editor
; deal with a key event, given some editor
(define (editor-kh ed k)
  (cond
    [(key=? k "left") (editor-lft ed)]
    [(key=? k "right") (editor-rgt ed)]
    [(key=? k "\b") (editor-del ed)]
    [(key=? k "\t") ed]
    [(key=? k "\r") ed]
    [(= (string-length k) 1) (editor-ins ed k)]
    [else ed]))

;(check-expect (editor-kh (create-editor "" "") "e")
;              (create-editor "e" ""))
;(check-expect (editor-kh (create-editor "cd" "fgh") "e")
;              (create-editor "cde" "fgh"))

; main : String -> Editor
; launch the editor given some initial string
(define (main s)
   (big-bang (create-editor s "")
             (on-key editor-kh)
             (to-draw editor-render)))

; insert the 1String k between pre and post
(define (editor-ins ed k)
  (make-editor (cons k (editor-pre ed)) (editor-post ed)))


(check-expect
  (editor-ins (make-editor empty empty) "e")
  (make-editor (cons "e" empty) empty))
 
(check-expect
  (editor-ins (make-editor (cons "d" empty)
                           (cons "f" (cons "g" empty)))
              "e")
  (make-editor (cons "e" (cons "d" empty))
               (cons "f" (cons "g" empty))))

; Editor -> Editor
; move the cursor position one 1String left, if possible
(define (editor-lft ed)
  ed)
 
; Editor -> Editor
; move the cursor position one 1String right, if possible
(define (editor-rgt ed)
  ed)
 
; Editor -> Editor
; delete one 1String to the left of the cursor, if possible
(define (editor-del ed)
  ed)

; Lo1s -> Image
; render a list of 1Strings as a text image
(define (editor-text s)
  (text (implode s) FTSZ FTCL))


(define (create-editor pre post)
(place-image/align
  ;(beside (text "pre" FTSZ FTCL) CU (text "post" FTSZ FTCL))
  (beside (text pre FTSZ FTCL) CU (text post FTSZ FTCL))
  1 1
  "left" "top"
  MT))

