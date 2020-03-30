{
 Autor : Luis Del aguila
 Version : 1.0
 Descripcion del programa : Escribe un programa en Pascal que lea una serie de palabras de una línea introducidas por teclado e imprima el acrónimo formado 
 por la primera letra de cada una de las palabras.
    Ejemplos:
        Compact Disc => CD
        Documento Nacional Identidad => DNI

}

Program pregunta1_21;
    
    Var
        palabra: String; 
        acronimo: String;
        contador: Integer;
        iterador: Integer;
      
        Procedure saltaBlancos(Var cadena: String); 
            Begin
                iterador:=2;
                acronimo:=cadena[1];
                For contador:=1 to Length(cadena) do
                    Begin
                      If (Ord(cadena[contador])=32) Then
                        Begin                          
                            Insert(cadena[contador+1],acronimo,iterador);
                            iterador:=iterador+1;
                        End;
                    End;
            End;

Begin
    
    writeln('Introduzca la palabra que desea hallar el acronimo: '); 
    readln(palabra);
    saltaBlancos(palabra);
    writeln('El acronimo de la palabra introducida es'+acronimo);
  
End.
