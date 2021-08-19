CREATE TABLE inventario(
	cod_producto integer NOT NULL,
	nom_producto TEXT NOT NULL,
	imagen_producto TEXT NOT NULL,
	linea TEXT NOT NULL,
	existencia integer NOT NULL,
	precio_compra float NOT NULL,
	precio_venta float NOT NULL,
	PRIMARY KEY(cod_producto)
);
CREATE TABLE productos (
	nom_producto TEXT NOT NULL,
	imagen_producto TEXT NOT NULL
);

CREATE TABLE ventas (
	id_venta integer PRIMARY KEY AUTOINCREMENT,
	cod_producto integer NOT NULL,
	cantidad integer NOT NULL,
	total_venta float NOT NULL
);

CREATE TABLE compras (
	id_compra integer PRIMARY KEY AUTOINCREMENT,
	cod_producto integer NOT NULL,
	cantidad integer NOT NULL,
	total_compra float NOT NULL
);

CREATE TABLE proveedores(
	id_proveedor integer PRIMARY KEY AUTOINCREMENT
);

ALTER TABLE productos ADD COLUMN cod_producto INTEGER REFERENCES inventario(cod_producto);
ALTER TABLE proveedores ADD COLUMN linea TEXT REFERENCES inventario(linea);
