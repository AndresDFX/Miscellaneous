#include <GL/glut.h> //OpenGL fonksiyonlar kullanmak icin
#include <stdlib.h>
#include <math.h>   // abs mutlak deger fonksiyonu icin
#include <iostream> //cin ve cout icin
#include <stdio.h>  //

using namespace std;
void yansit(int a, int b) //pikselleri ekrana yansitan fonksiyon
{
    glBegin(GL_POINTS); // Ayarladigimiz renk ile bir nokta yansitmak uzere
    glVertex2i(a, b);   //2 boyutlu birsey koy
    glEnd();            //blogu kapat
}
void myinit(void)
{

    glClearColor(0.905, 0, 0, 0.0);   // arka plan rengi
    glMatrixMode(GL_PROJECTION);      //
    glLoadIdentity();                 //
    gluOrtho2D(-500, 500, -500, 500); //sol, sag, yukarı ve asagi noktalarin yerleri
}

void bresenham_algoritmasi(int x1, int y1, int x2, int y2) //iki nokta arasında cizgi cizmemizi saglayan fonksiyon
{
    int x, y, dx, dy, dx1, dy1, px, py, xe, ye, i;
    dx = x2 - x1;
    dy = y2 - y1;
    dx1 = abs(dx);
    dy1 = abs(dy);
    px = 2 * dy1 - dx1; //karar degiskeni baslangic degeri (m<1 icin, x'e gore)
    py = 2 * dx1 - dy1; //karar degiskeni baslangic degeri (m<1 icin, y'ye gore)
    if (dy1 <= dx1)     //egim 1'den kucukse
    {
        if (dx >= 0) //0-45 derece arasinda durum
        {
            x = x1;
            y = y1;
            xe = x2;
        }
        else //135-180 derece arasinda durum
        {
            x = x2;
            y = y2;
            xe = x1;
        }
        yansit(x, y);
        for (i = 0; x < xe; i++)
        {
            x = x + 1;
            if (px < 0)
            {
                px = px + 2 * dy1; //karar degiskeni 0'dan kucukse kuzey doguya git
            }
            else
            {
                if ((dx < 0 && dy < 0) || (dx > 0 && dy > 0))
                {
                    y = y + 1; // kuzeye git
                }
                else
                {
                    y = y - 1; // guneye git
                }
                px = px + 2 * (dy1 - dx1); //karar degiskeninin yeni degerini hesaplamak icin
            }
            yansit(x, y);
        }
    }
    else //egim 1'den buyukse
    {
        if (dy >= 0) // yon kuzeye dogruysa
        {
            x = x1;
            y = y1;
            ye = y2;
        }
        else //yon kuzeye dogru degilse
        {
            x = x2;
            y = y2;
            ye = y1;
        }
        yansit(x, y);
        for (i = 0; y < ye; i++) //
        {
            y = y + 1;
            if (py <= 0)
            {
                py = py + 2 * dx1; //kuzeydoguya git
            }
            else
            {
                if ((dx < 0 && dy < 0) || (dx > 0 && dy > 0))
                {
                    x = x + 1; //doguya git
                }
                else
                {
                    x = x - 1; //batiya git
                }
                py = py + 2 * (dx1 - dy1); //kuzeybatiya git
            }
            yansit(x, y);
        }
    }
}
void display(void)
{
    glClear(GL_COLOR_BUFFER_BIT); // frame buffer'in icerigini(renk ve bit) temizliyor

    glPointSize(6); // her nokta kac piksel kaplıyor

    glColor3f(0.545, 0.27, 0.074);
    bresenham_algoritmasi(-50, -200, 50, -200); // ilk dogrunun foksiyonu
    bresenham_algoritmasi(-50, -200, -50, 0);   //ikinci dogrunun foksiyonu
    bresenham_algoritmasi(50, -200, 50, 0);

    glColor3f(0, 0.635, 0); // RGB sistemi kullanacagiz
    bresenham_algoritmasi(-50, 0, -250, 0);
    bresenham_algoritmasi(-250, 0, -50, 100);
    bresenham_algoritmasi(-50, 100, -190, 100);
    bresenham_algoritmasi(-190, 100, -50, 200);
    bresenham_algoritmasi(-50, 200, -150, 200);
    bresenham_algoritmasi(-150, 200, 0, 300);
    bresenham_algoritmasi(0, 300, 150, 200);
    bresenham_algoritmasi(150, 200, 50, 200);
    bresenham_algoritmasi(50, 200, 190, 100);
    bresenham_algoritmasi(190, 100, 50, 100);
    bresenham_algoritmasi(50, 100, 250, 0);
    bresenham_algoritmasi(250, 0, 50, 0);

    glColor3f(1, 1, 1);
    glPointSize(2);
    bresenham_algoritmasi(-30, 250, 35, 300);
    bresenham_algoritmasi(30, 300, -35, 300);
    bresenham_algoritmasi(-35, 300, 30, 250);
    bresenham_algoritmasi(-30, 250, 0, 330);
    bresenham_algoritmasi(30, 250, 0, 330);

    for (int i = -50; i <= 50; i++)
    {
        glColor3f(0.545, 0.27, 0.074);
        bresenham_algoritmasi(i, 0, i, -200);
    }

    glFlush(); // var olan tumdegerleri frame buffer dan ekrana gonderiyor
}

int main(int argc, char **argv)
{

    glutInit(&argc, argv);
    glutInitWindowSize(600, 600);                           //pencere boyutlari
    glutInitWindowPosition(400, 80);                        //pencere bilgisayarimin ekraninda nerede gorunsun
    glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);            //tek frame buffer, rgb renk sistemi
    glutCreateWindow("Bressenham Dogru Cizme Algoritmasi"); //pencerenin basligi
    myinit();                                               //init fonk cagirma
    glutDisplayFunc(display);                               //display olayini ekranda gözukmesi icin cagiriyoruz
    glutMainLoop();                                         //var olan olayi tekrarla
}