# Etapa 1: Compilación y empaquetado
FROM maven:3.9.0-eclipse-temurin-17 AS build

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo pom.xml y las dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el código fuente
COPY src ./src

# Compilar y empaquetar la aplicación
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final de la aplicación
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copiar el jar compilado desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto 8081 (como se requiere)
EXPOSE 8081

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
