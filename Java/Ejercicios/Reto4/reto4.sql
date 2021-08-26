CREATE TABLE estudiante(  
	nombres VARCHAR(50),
    apellidos VARCHAR(50),
	fechaNacimiento VARCHAR(50),
    correoInstitucional VARCHAR(50),
    correoPersonal VARCHAR(50),
    numeroCelular INTEGER,
	numeroFijo INTEGER,
    programaAcademico VARCHAR(50),
	
	PRIMARY KEY(correoInstitucional),
	UNIQUE (numeroCelular)
);