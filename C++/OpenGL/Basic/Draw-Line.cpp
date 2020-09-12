#include <iostream>
#include <GL/glut.h>

using namespace std;

//METODO INCREMENTAL DIRECTO
void directLine(GLfloat x_1, GLfloat y_1, GLfloat x_2, GLfloat y_2)
{

    //Mostrar puntos inicial
    glVertex2f(x_1, y_1);
    glVertex2f(x_2, y_2);

    double m = (y_2 - y_1) / (x_2 - x_1);
    double b = y_1 - (m * x_1);

    double increment = 0.1;

    GLfloat y = y_1;
    for (GLfloat i = x_1; i < x_2; i += increment)
    {
        //cout << i << " " << y / length << endl;
        glVertex2f(i, i);
        y = y + m;
    }
}

//Template de funcion "principal que crea la escena"
void display(void)
{
    glClearColor(0.0, 0.0, 0.0, 0.0);
    glClear(GL_COLOR_BUFFER_BIT);

    //YOUR CODE HERE

    glBegin(GL_POINTS);
        drawLine(0.0, 0.0, 0.8, 0.8);

    //drawLine(-0.8, 0.8, 0.0, 0.0, l);
    //drawLine(-0.8, -0.8, 0.0, 0.0, l);
    glEnd();
    glFlush();
}

//Template de funcion que inicializa la interfaz utilizando de GLUT
void iniciarGLUT()
{
    glutInitDisplayMode(GLUT_RGB | GLUT_SINGLE);
    glutInitWindowSize(512, 512);
    glutInitWindowPosition(20, 20);
    glutCreateWindow("Draw Lines simple");
}

int main(int argc, char *argv[])
{

    //Inicializar GLUT
    glutInit(&argc, argv);
    iniciarGLUT();

    //Begin FUNCIONES DE UTILERIA

    //Pintar la escena
    glutDisplayFunc(display);

    //End FUNCIONES DE UTILERIA

    //Ejecuta los callbacks cada vez que ocurra un "EVENTO"
    glutMainLoop();
    return 0;
}