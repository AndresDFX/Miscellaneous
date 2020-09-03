#include <stdlib.h>
#include <iostream>
#include <GL/glut.h>

using namespace std;

GLfloat x1 = 0, y1 = 0, x2 = 0, y2 = 0;

void display(void)
{
    glClear(GL_COLOR_BUFFER_BIT);

    glBegin(GL_POINTS);
    glVertex2f(x1, y1);
    glVertex2f(x2, y2);
    glEnd();
    glFlush();
}

int main(int argc, char *argv[])
{
    string titulo = "(" + string(argv[1]) + "," + string(argv[2]) + ") - (" + string(argv[3]) + "," + string(argv[4]) + ")";

    x1 = atof(argv[1]);
    y1 = atof(argv[2]);
    x2 = atof(argv[3]);
    y2 = atof(argv[4]);

    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_RGB | GLUT_SINGLE);
    glutInitWindowSize(50, 500);
    glutCreateWindow(titulo.c_str());
    glutDisplayFunc(display);
    glutMainLoop();

    return 0;
}
