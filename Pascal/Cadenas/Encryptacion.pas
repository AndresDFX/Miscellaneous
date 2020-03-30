{Realiza un programa en Pascal que pida al usuario introducir una palabra de siete letras y que éste la codifique letra a letra, restando 20 del valor numérico usado para representar la letra en código ASCII y, finalmente, devuelva por pantalla la palabra encriptada.
Por ejemplo, si se emplea el conjunto de caracteres ASCII, la letra d (representada por el valor 100) se convertirá en P (representada por el valor 80), y así sucesivamente.
Ayuda: usa la función chr (ord (a) – 20).
La función ord (a) devuelve el número entero en código ASCII del carácter pasado por parámetro.
La función chr (n) devuelve el carácter que representa un número entero en código ASCII pasado por parámetro.
}

Program pregunta2_11;

var 
    palabra,palabraEncryptada: string;
begin

    writeln('Digite la palabra que desea encryptar: ');
    readln(palabra);
    palabraEncryptada:= palabra;
    if ((Length(palabra))=7) then
        begin

            palabra[1] := Chr(Ord (palabra[1])- 20);
            palabra[2] := Chr(Ord (palabra[2])- 20);
            palabra[3] := Chr(Ord (palabra[3])- 20);
            palabra[4] := Chr(Ord (palabra[4])- 20);
            palabra[5] := Chr(Ord (palabra[5])- 20);
            palabra[6] := Chr(Ord (palabra[6])- 20);
            palabra[7] := Chr(Ord (palabra[7])- 20);
            writeln('La palabra encryptada es: ' + palabra);
        end
    else
        writeln('La longitud de la palabra no es 7');
    

end.
