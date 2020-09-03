
#include <GL/glut.h>
#include <math.h>

#define PI 3.14159f

float ang, x, y;
int up, down;
float zoom = 2.5f;

void IniciarGLUT()
{
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
    glutInitWindowSize(600, 600);
    glutInitWindowPosition(100, 100);
    glutCreateWindow("Practica III,3 de OpenGL");
}

void PintarEscena()
{
    glMatrixMode(GL_MODELVIEW);
    glClear(GL_COLOR_BUFFER_BIT);
    glLoadIdentity();

    glBegin(GL_LINES);
    for (ang = 0.0f; ang < PI * 2.0f; ang = ang + 0.1f)
    {
        x = zoom * cosf(ang);
        y = zoom * sinf(ang);
        glVertex3f(0.0f, 0.0f, 0.0f);
        glVertex3f(x, y, 0.0f);
    }
    glEnd();

    glutSwapBuffers();
}

void ReProyectar(int w, int h)
{
    GLfloat formato;

    if (h == 0)
        h = 1;

    glViewport(0, 0, w, h);

    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();

    formato = (GLfloat)w / (GLfloat)h;

    if (w <= h)
        glOrtho(-10.0f, 10.0f, -10.0f / formato, 10.0f / formato, 1.0f, -1.0f);
    else
        glOrtho(-10.0f * formato, 10.0f * formato, -10.0f, 10.0f, 1.0f, -1.0f);
}

void Flechas(int key, int x, int y)
{
    if (key == GLUT_KEY_UP)
        up = 1;
    if (key == GLUT_KEY_DOWN)
        down = 1;
}

void FlechasUp(int key, int x, int y)
{
    if (key == GLUT_KEY_UP)
        up = 0;
    if (key == GLUT_KEY_DOWN)
        down = 0;
}

void Zoomizar(int value)
{
    if (up)
        zoom = zoom * 1.01f;
    if (down)
        zoom = zoom / 1.01f;

    glutTimerFunc(33, Zoomizar, 1);
}

int main(int argc, char **argv)
{
    glutInit(&argc, argv); //Solo necesario en Linux
    IniciarGLUT();

    //  glutReshapeFunc(ReProyectar);
    glutDisplayFunc(PintarEscena);
    glutSpecialFunc(Flechas);
    glutSpecialUpFunc(FlechasUp);
    glutTimerFunc(33, Zoomizar, 1);
    glutIdleFunc(PintarEscena);

    glutMainLoop();
    return 0;
}