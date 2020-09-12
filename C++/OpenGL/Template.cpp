#include <GL/glut.h>
#include <string>

//Template de funcion "principal que crea la escena"
void display(void)
{
    glClearColor(0.0, 0.0, 0.0, 0.0);
    glClear(GL_COLOR_BUFFER_BIT);

    //HERE CODE

    glFlush();

}

//Template de funcion que inicializa la interfaz utilizando de GLUT
void iniciarGLUT(){

    glutInitDisplayMode(GLUT_RGB | GLUT_DEPTH | GLUT_DOUBLE);
    glutInitWindowSize(512, 512);
    glutInitWindowPosition(20, 20);
    glutCreateWindow("Title window");
}

int main(int argc, char** argv) {
    
    //Inicializar GLUT
    glutInit(&argc, argv); //Solo necesario en Linux
    iniciarGLUT();

    //Begin FUNCIONES DE UTILERIA

    //Pintar la escena
    glutDisplayFunc(display);
     
    //End FUNCIONES DE UTILERIA

    //Ejecuta los callbacks cada vez que ocurra un "EVENTO"
    glutMainLoop();
    return 0;
}