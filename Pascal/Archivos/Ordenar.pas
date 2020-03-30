{
    Dados dos ficheros de entrada que contengan registros formados por apellido, nombre y teléfono , crea un programa en Pascal que lea los datos de cada fichero, los junte, los ordene y cree un fichero resultante con los datos de ambos ficheros de entrada ordenados por apellido. Para facilitar el trabajo con arrays trabajaremos con estos ficheros acotados a 4 registros de entrada por fichero.
    •	Por ejemplo, dado un fichero de entrada ficheroUno.txt
    Barcia Daniel 654545214
    Soriano Joaquín 666554455
    Martínez Sergio 669885574
    Vázquez David 666554411
    •	Y otro fichero de entrada ficheroDos.txt
    Aranda Marta 654654554
    Díaz Juan 666998877
    González Laura 665874874
    Zorrilla Sebastián 666552244
    •	El fichero resultante (ficheroSalida.txt) debería ser
    Aranda Marta 654654554
    Barcia Daniel 654545214
    Díaz Juan 666998877
    González Laura 665874874
    Martínez Sergio 669885574
    Soriano Joaquín 666554455
    Vázquez David 666554411
    Zorrilla Sebastián 666552244


}


Program pregunta1_31;

var
    datos: array[1..8] of String;
    i,j,f1,f2: integer;
    temporal,linea: String;
    fichero1, fichero2, ficheroSalida: text;

begin
    i:=1;  
    assign( fichero1, 'ficheroUno.txt' ); 
    assign( fichero2, 'ficheroDos.txt' ); 
    assign( ficheroSalida, 'ficheroSalida.txt' ); 

    reset(fichero1);
    reset(fichero2);
    rewrite(ficheroSalida);

  while not eof( fichero1 ) do           
     begin
        readln( fichero1, linea );            
        datos[i]:=linea;                    
        i:=i+1;
     end;
   close(fichero1); 

   while not eof( fichero2 ) do           
     begin
        readln( fichero2, linea );            
        datos[i]:=linea;                    
        i:=i+1;
     end;
   close(fichero2); 

    for i :=8 downto 2 do
        for j := 0 to i - 1 do
            if datos[j] > datos[j + 1] then
            begin
                temporal := datos[j];
                datos[j] := datos[j + 1];
                datos[j + 1] := temporal;
            end;


    { Ahora escribimos los datos }
    for i := 1 to 8 do

        writeln(ficheroSalida,datos[i]);
    close(ficheroSalida);
    write('Se organizaron los datos en el ficheroSalida.txt'); 
   
end.