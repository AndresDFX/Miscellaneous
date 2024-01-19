
# Support REST service

## Prerrequisitos

Antes de comenzar, asegúrate de cumplir con los siguientes requisitos:

- **Python**: Debe estar instalado en tu sistema. Puedes descargarlo desde [python.org](https://www.python.org/downloads/) o instalarlo utilizando un gestor de paquetes como `brew` (para macOS) o `apt` (para Linux).

- **Docker**: Debes tener Docker instalado. Puedes descargarlo desde [Docker's official website](https://www.docker.com/get-started) e instalarlo siguiendo las instrucciones para tu sistema operativo.

- **Docker Compose**: Asegúrate de tener Docker Compose instalado. Por lo general, ya viene incluido con la instalación de Docker. Puedes verificar su versión con el comando `docker-compose --version`.

- **Editor de Código**: Utiliza un editor de código de tu elección. Algunas opciones populares incluyen Visual Studio Code, PyCharm o Sublime Text.

## Configuración del Entorno

1. **Clonar el Repositorio de GitHub**:

   ```bash
   git clone https://github.com/AndresDFX/test-app.git
   cd tu-proyecto
   ```

Modificar el .env:

Modifica .env en la raíz del proyecto y configura las variables de entorno según tus necesidades. Puedes tomar como referencia el archivo .env.que ya existe.


Instalar Dependencias de Python:

```bash
pip install -r requirements.txt
```

Realizar Migraciones de la Base de Datos:

```bash
python manage.py migrate
```

Ejecutar en Local
Para ejecutar el proyecto en tu entorno local, sigue estos pasos:

Iniciar el Servidor de Desarrollo de Django:

```bash
python manage.py runserver
```

Acceder a la Aplicación:

Abre tu navegador web y accede a http://localhost:8000/ para ver la aplicación en funcionamiento.

Ejecutar con Docker
Si prefieres ejecutar el proyecto en un contenedor Docker, sigue estos pasos:

Asegurarse de que Docker esté en Funcionamiento:

Asegúrate de que Docker esté en funcionamiento en tu sistema.

Construir y Ejecutar los Contenedores Docker:

```bash
docker-compose up --build
```

Acceder a la Aplicación desde el Contenedor Docker:

Abre tu navegador web y accede a http://localhost:8000/ para ver la aplicación en funcionamiento desde el contenedor Docker.

Detener y Limpiar
Para detener y limpiar los contenedores Docker, ejecuta:

```bash
docker-compose down
```

Esto detendrá y eliminará los contenedores, pero mantendrá los datos de la base de datos persistente si has configurado un volumen para ello.


# Uso de GNU Make para la Gestión del Proyecto

## Definición del Shell en GNU Make
SHELL := /bin/bash

## Comandos Disponibles

- **up**: Construir y levantar el contenedor.
  ```
  make up
  ```
- **down**: Detener el contenedor.
  ```
  make down
  ```
- **up-detached**: Ejecutar el contenedor en modo 'detached'.
  ```
  make up-detached
  ```
- **logs**: Ver los logs del contenedor.
  ```
  make logs
  ```
- **status**: Ver el estado de los contenedores.
  ```
  make status
  ```
- **test**: Realizar pruebas.
  ```
  make test
  ```
- **test-coverage**: Realizar pruebas con cobertura.
  ```
  make test-coverage
  ```
- **migrate**: Realizar migraciones.
  ```
  make migrate
  ```
- **makemigrations**: Crear migraciones basadas en cambios de modelos.
  ```
  make makemigrations
  ```
- **collectstatic**: Recolectar archivos estáticos.
  ```
  make collectstatic
  ```
- **shell**: Acceder al shell dentro del contenedor.
  ```
  make shell
  ```
- **django-shell**: Acceder a la consola de Django.
  ```
  make django-shell
  ```
- **createsuperuser**: Crear un superusuario.
  ```
  make createsuperuser
  ```
- **clean**: Limpiar contenedores, redes, volúmenes e imágenes.
  ```
  make clean
  ```
- **pip-compile**: Actualizar dependencias con pip-compile.
  ```
  make pip-compile
  ```
- **manage**: Ejecutar comandos Django dentro del contenedor. Uso: `make manage cmd="comando"`
  ```
  make manage cmd="comando"
  ```
- **start**: Iniciar el proyecto. Uso: `make start mode=docker` o `make start mode=local`
  ```
  make start mode=docker
  ```
  ```
  make start mode=local
  ```
- **help**: Mostrar información sobre los comandos disponibles.
  ```
  make help
  ```
