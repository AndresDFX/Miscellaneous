import os
import os.path
import ctypes
import pandas as pd
import sqlite3
from sqlite3 import *
from pandas import ExcelWriter

databaseFile = 'data.db'
sqlFile = 'script.sql'

def sql_connection():
    try:
        con = sqlite3.connect(databaseFile)
        return con

    except Error:
        print(Error)
        
def borrar_database():
    if os.path.isfile(databaseFile):
        os.remove(databaseFile)
        
def crear_database():
    qry = open(sqlFile, 'r').read()
    sqlite3.complete_statement(qry)
    conn = sql_connection()
    cursor = conn.cursor()
    try:
        cursor.executescript(qry)
    except Exception as e:
        MessageBoxW = ctypes.windll.user32.MessageBoxW
        errorMessage = databaseFile + ': ' + str(e)
        MessageBoxW(None, errorMessage, 'Error', 0)
        cursor.close()
        raise


def cargar_inventario():

    inventario = pd.read_excel( 'inventario.xlsx',
                                sheet_name='inventario',
                                header=0)
    productos = inventario[['cod_producto', 'nom_producto', 'imagen_producto']]
    proveedores = inventario[['linea']]

    conn = sql_connection()
    inventario.to_sql('inventario', conn, if_exists='replace', index=False)
    productos.to_sql('productos', conn, if_exists='replace', index=False)
    proveedores.to_sql('proveedores', conn, if_exists='replace', index=True, index_label='id_proveedor')
    conn.commit()
    conn.close()


def exportar_tabla_excel(nombre_tabla):
    conn = sql_connection()
    df = pd.read_sql_query("select * from "+nombre_tabla+";", conn)
    writer = ExcelWriter(nombre_tabla+'.xlsx')
    df.to_excel(writer, 'Hoja de datos', index=False)
    writer.save()

def insertar_inv():
    
    cod_producto = int(input("Digite el codigo numerico del producto a ingresar: "))
    conn = sql_connection()
    cursorObj = conn.cursor()
    sql = 'SELECT 1 FROM inventario WHERE cod_producto ='+ str(cod_producto)+';'
    cursorObj.execute(sql)
    row = cursorObj.fetchall()
    
    if row:
        print("No se puede INSERTAR ya existe en el inventario")
    else:
        nom_producto = input("Digite el nombre del producto: ")
        imagen_producto = input("Digite la ruta de la imagen del producto: ")
        linea = input("Digite el nombre de la linea del producto: ")
        existencia = int(input("Digite el numero de productos en stock: "))
        precio_compra = float(input("Digite el precio de compra del producto: "))
        precio_venta = float(input("Digite el precio de venta del producto: "))
        valores_inventario = (cod_producto, nom_producto, imagen_producto, linea, existencia, precio_compra, precio_venta)
        valores_producto = (cod_producto, nom_producto, imagen_producto)
        valores_proveedor = (linea)
        cursorObj.execute('INSERT INTO inventario(cod_producto, nom_producto, imagen_producto, linea, existencia, precio_compra, precio_venta) VALUES(?, ?, ?, ?, ?, ?, ?)', valores_inventario)
        cursorObj.execute('INSERT INTO productos(cod_producto, nom_producto, imagen_producto) VALUES(?, ?, ?)', valores_producto)
        cursorObj.execute('INSERT INTO proveedores(linea) VALUES(?)', valores_proveedor)

    conn.commit()
    conn.close()

def actualizar_inv():
    
    cod_producto = int(input("Digite el codigo numerico del producto a actualizar: "))
    conn = sql_connection()
    cursorObj = conn.cursor()
    sql = 'SELECT 1 FROM inventario WHERE cod_producto ='+ str(cod_producto)+';'
    cursorObj.execute(sql)
    row = cursorObj.fetchall()
    
    if row:
        nom_producto = input("Digite el nombre del producto: ")
        imagen_producto = input("Digite la ruta de la imagen del producto: ")
        linea = input("Digite el nombre de la linea del producto: ")
        existencia = int(input("Digite el numero de productos en stock: "))
        precio_compra = float(input("Digite el precio de compra del producto: "))
        precio_venta = float(input("Digite el precio de venta del producto: "))
        valores_inventario = (nom_producto, imagen_producto, linea, existencia, precio_compra, precio_venta, cod_producto)
        valores_producto = (nom_producto, imagen_producto, cod_producto)
        valores_proveedor = (linea)

        cursorObj.execute(
        """
        UPDATE inventario
        SET 
                nom_producto = ?,
                imagen_producto = ?,
                linea = ?,
                existencia = ?,
                precio_compra = ?,
                precio_venta = ?
        WHERE cod_producto = ?;
        """, valores_inventario)

        cursorObj.execute(
        """
        UPDATE productos
        SET 
                nom_producto = ?,
                imagen_producto = ?
        WHERE cod_producto = ?;
        """, valores_producto)
        
    else:
        print("No se puede ACTUALIZAR no existe en el inventario")

    conn.commit()
    conn.close()

def insertar_venta():
    
    cod_producto = int(input("Digite el codigo numerico del producto que quiere vender: "))
    conn = sql_connection()
    cursorObj = conn.cursor()
    sql = 'SELECT 1 FROM inventario WHERE cod_producto ='+ str(cod_producto)+';'
    cursorObj.execute(sql)
    row = cursorObj.fetchall()
    
    if row:
        cantidad = int(input("Digite la cantidad de productos que quiere vender: "))
        sql = 'SELECT precio_venta, existencia FROM inventario WHERE cod_producto ='+ str(cod_producto)+';'
        cursorObj.execute(sql)
        rows = cursorObj.fetchall()
        precio_venta = rows[0][0]
        existencia = rows[0][1]
        if cantidad>existencia:
            print("No se puede VENDER el producto, no hay existencia para cumplir el requerimiento")
        else:
            existencia = existencia - cantidad
            total_venta = precio_venta * cantidad
            valores_venta = (cod_producto, cantidad, total_venta)
            valores_inventario = (existencia, cod_producto)
            cursorObj.execute('INSERT INTO ventas(cod_producto, cantidad, total_venta) VALUES(?, ?, ?)', valores_venta)
            cursorObj.execute('UPDATE inventario SET existencia = ? WHERE cod_producto = ?', valores_inventario)    
    else:
        print("No se puede VENDER el producto no existe")

    conn.commit()
    conn.close()

def insertar_venta():
    
    cod_producto = int(input("Digite el codigo numerico del producto que quiere vender: "))
    conn = sql_connection()
    cursorObj = conn.cursor()
    sql = 'SELECT 1 FROM inventario WHERE cod_producto ='+ str(cod_producto)+';'
    cursorObj.execute(sql)
    row = cursorObj.fetchall()
    
    if row:
        cantidad = int(input("Digite la cantidad de productos que quiere vender: "))
        sql = 'SELECT precio_venta, existencia FROM inventario WHERE cod_producto ='+ str(cod_producto)+';'
        cursorObj.execute(sql)
        rows = cursorObj.fetchall()
        precio_venta = rows[0][0]
        existencia = rows[0][1]
        if cantidad>existencia:
            print("No se puede VENDER el producto, no hay existencia para cumplir el requerimiento")
        else:
            existencia = existencia - cantidad
            total_venta = precio_venta * cantidad
            valores_venta = (cod_producto, cantidad, total_venta)
            valores_inventario = (existencia, cod_producto)
            cursorObj.execute('INSERT INTO ventas(cod_producto, cantidad, total_venta) VALUES(?, ?, ?)', valores_venta)
            cursorObj.execute('UPDATE inventario SET existencia = ? WHERE cod_producto = ?', valores_inventario)
            print("Producto vendido correctamente")
            exportar_tabla_excel("ventas")
    else:
        print("No se puede VENDER el producto no existe")

    conn.commit()
    conn.close()

def insertar_compra():
    
    cod_producto = int(input("Digite el codigo numerico del producto que quiere comprar: "))
    conn = sql_connection()
    cursorObj = conn.cursor()
    sql = 'SELECT 1 FROM inventario WHERE cod_producto ='+ str(cod_producto)+';'
    cursorObj.execute(sql)
    row = cursorObj.fetchall()
    
    if row:
        cantidad = int(input("Digite la cantidad de productos que quiere comprar: "))
        sql = 'SELECT precio_compra, existencia FROM inventario WHERE cod_producto ='+ str(cod_producto)+';'
        cursorObj.execute(sql)
        rows = cursorObj.fetchall()
        precio_compra = rows[0][0]
        existencia = rows[0][1] + cantidad
        total_compra = precio_compra * cantidad
        valores_compra = (cod_producto, cantidad, total_compra)
        valores_inventario = (existencia, cod_producto)
        cursorObj.execute('INSERT INTO compras(cod_producto, cantidad, total_compra) VALUES(?, ?, ?)', valores_compra)
        cursorObj.execute('UPDATE inventario SET existencia = ? WHERE cod_producto = ?', valores_inventario)
        print("Producto comprado correctamente")
        exportar_tabla_excel("compras")
    else:
        print("No se puede COMPRAR el producto no existe")

    conn.commit()
    conn.close()

def main():
    ans=True
    while ans:
        
        print("""## GENERADOR DE INVENTARIO ##
        1.Cargar inventario inicial
        2.Insertar en inventario
        3.Actualizar en inventario
        4.Vender
        5.Comprar
        6.Exportar inventario a excel
        7.Salir
        """)
        
        ans=input("Seleccione una opcion para continuar: ")

        if ans=="1":
            borrar_database()
            crear_database()
            cargar_inventario()
            print("Inventario cargado correctamente")
        elif ans=="2":
            insertar_inv()
        elif ans=="3":
            actualizar_inv()
        elif ans=="4":
            insertar_venta()
            exportar_tabla_excel("ventas")
        elif ans=="5":
            insertar_compra()
            exportar_tabla_excel("compras")
        elif ans=="6":
            exportar_tabla_excel("inventario")
            print("Inventario exportado correctamente")
          
        elif ans=="7":
          print("\n Goodbye") 
          ans = None
        else:
           print("\n No selecciono una opcion valida")

main()
