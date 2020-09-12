@echo off
::Borrar archivos de alguna compilacion anterior
::DEL /F /Q window.o window.exe

::Compilar el archivo.o y crear .exe
for %%i in (*.cpp) do (
	g++ -c -o window.o %%i -I"C:\MinGW\GLUT\include" 
	echo Compilacion completa
	
	g++ -o window.exe window.o -L"C:\MinGW\GLUT\lib" -lglut32 -lopengl32 -Wl,--subsystem,windows	
	echo Ejecutable creado correctamente
	)

exit

