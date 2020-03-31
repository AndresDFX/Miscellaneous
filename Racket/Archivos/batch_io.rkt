;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname batch_io) (read-case-sensitive #t) (teachpacks ((lib "world.ss" "teachpack" "htdp") (lib "batch-io.ss" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "world.ss" "teachpack" "htdp") (lib "batch-io.ss" "teachpack" "2htdp")))))
(write-file "sample.dat" "212")
;"sample.dat"
(read-file "sample.dat")
;"212"