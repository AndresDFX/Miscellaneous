CREATE DOMAIN TENSION_DATA AS INTEGER 
NOT NULL CHECK (value >= 20 AND value <= 240);

CREATE DOMAIN MAQUINA_DATA VARCHAR(10)
NOT NULL CHECK (UPPER(VALUE) IN ('MAQUINA X', 'MAQUINA Y', 'MAQUINA Z'));

CREATE TABLE maquina(
	
	nombre VARCHAR(50) NOT NULL,
	serial_maquina INTEGER NOT NULL,
	marca VARCHAR(50) NOT NULL,
	tension TENSION_DATA,
	tipo_maquina MAQUINA_DATA,
	anho_fabricacion INTEGER NOT NULL,
	indice_salud FLOAT,
	PRIMARY KEY (serial_maquina)

);

INSERT INTO maquina (nombre,serial_maquina,marca,tension,tipo_maquina,anho_fabricacion) 
VALUES('XT123',123,'Ford',20,'Maquina X',2020);
INSERT INTO maquina (nombre,serial_maquina,marca,tension,tipo_maquina,anho_fabricacion) 
VALUES('XT123',12343,'Ford',50,'Maquina X',2020);


CREATE TABLE medicion_maquina(
	
	serial_maquina INTEGER NOT NULL,
	tipo_medicion VARCHAR (20),
	valor_medicion INTEGER CHECK (CASE WHEN tipo_medicion='Agua' AND (valor_medicion>= 0 AND valor_medicion<= 100) THEN TRUE
								 	   WHEN tipo_medicion='Fuego' AND (valor_medicion>= 0 AND valor_medicion<= 50) THEN TRUE
								  	   WHEN tipo_medicion='Aire' AND (valor_medicion>= 0 AND valor_medicion<= 20) THEN TRUE
								  ELSE FALSE
								  END),
	
	FOREIGN KEY (serial_maquina) REFERENCES maquina(serial_maquina)
	
);

INSERT INTO medicion_maquina(serial_maquina,tipo_medicion,valor_medicion) VALUES (123,'Agua',50);
INSERT INTO medicion_maquina(serial_maquina,tipo_medicion,valor_medicion) VALUES (123,'Fuego',50);
INSERT INTO medicion_maquina(serial_maquina,tipo_medicion,valor_medicion) VALUES (123,'Fuego',40);
INSERT INTO medicion_maquina(serial_maquina,tipo_medicion,valor_medicion) VALUES (12343,'Fuego',30);

---Para buscar el Agua se cambia el where y listo
SELECT  maquina.serial_maquina, tipo_medicion, SUM(valor_medicion) AS suma FROM maquina 
LEFT JOIN medicion_maquina ON maquina.serial_maquina = medicion_maquina.serial_maquina GROUP BY maquina.serial_maquina, tipo_medicion ORDER BY tipo_medicion ASC;
