;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname ejemplo-Carta) (read-case-sensitive #t) (teachpacks ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.ss" "teachpack" "2htdp") (lib "universe.ss" "teachpack" "2htdp")))))
;; Función principal
(define (carta nombre apellido firmante)
  (string-append
    (saludo nombre)
    "\n"
    (texto nombre apellido)
    "\n"
    (despedida firmante)))
 
(define (saludo nombre)
  (string-append "Estimado " nombre ","))
 
(define (texto nombre apellido)
  (string-append
   "hemos descubierto que todas las personas de apellido "
   "\n"
   apellido " han ganado nuestra lotería. Así que, " nombre ", "
   "\n"
   "apúrese y reclame su premio."))
 
(define (despedida firmante)
  (string-append
   "Atentamente,"
   "\n"
   firmante))

(carta "Fulano" "De Tal" "Fulanito")