# --- ETAPA 1: Compilación ---
# Usa una imagen oficial de Maven con Java 17 para compilar el código
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build

# Define el directorio de trabajo dentro del contenedor para la compilación
WORKDIR /app

# Copia el archivo de configuración de Maven
COPY pom.xml .

# Copia la carpeta con todo tu código fuente
COPY src ./src

# Compila el proyecto generando el archivo .jar (omitiendo los tests para acelerar el proceso)
RUN mvn clean package -DskipTests

# --- ETAPA 2: Ejecución ---
# Usa una imagen ligera que solo contiene el entorno de ejecución de Java (JRE)
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copia el archivo .jar generado en la etapa anterior (Etapa 1) hacia esta nueva imagen limpia
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto 8080 (puerto por defecto de Spring Boot / servidores web Java)
EXPOSE 8080

# Comando para arrancar tu aplicación Java
ENTRYPOINT ["java", "-jar", "app.jar"]
