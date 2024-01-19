-- Creación de la tabla Pelicula
CREATE TABLE Pelicula (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT,
    genero VARCHAR(50) NOT NULL,
    FOREIGN KEY (genero) REFERENCES PrecioGenero(genero)
);

-- Creación de la tabla Ejemplar
CREATE TABLE Ejemplar (
    codigo VARCHAR(50) PRIMARY KEY,
    pelicula_id INT NOT NULL,
    estado VARCHAR(50) NOT NULL CHECK (estado IN ('disponible', 'alquilado')),
    FOREIGN KEY (pelicula_id) REFERENCES Pelicula(id)
);

-- Creación de la tabla Cliente
CREATE TABLE Cliente (
    id SERIAL PRIMARY KEY,
    nombres VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    cedula VARCHAR(50) UNIQUE NOT NULL,
    clave VARCHAR(255) NOT NULL
);

-- Creación de la tabla Alquiler
CREATE TABLE Alquiler (
    id SERIAL PRIMARY KEY,
    cliente_id INT NOT NULL,
    ejemplar_codigo VARCHAR(50) NOT NULL,
    fecha_alquiler TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_devolucion TIMESTAMP,
    costo_alquiler INT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id),
    FOREIGN KEY (ejemplar_codigo) REFERENCES Ejemplar(codigo)
);

-- Creación de la tabla PrecioGenero
CREATE TABLE PrecioGenero (
    genero VARCHAR(50) PRIMARY KEY,
    precio INT NOT NULL CHECK (precio > 0)
);
