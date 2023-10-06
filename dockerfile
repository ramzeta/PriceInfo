# Utilizar una imagen base de Java
FROM openjdk:17-ea-jdk

# Metadata como el mantenedor del Dockerfile
LABEL maintainer="ramiroperezsanz13@gmail.com"

# Puerto en el que se ejecutará la aplicación
EXPOSE 8001

# Crear un directorio en la imagen para guardar la aplicación
WORKDIR /app

# Copiar el archivo JAR de tu aplicación al directorio de trabajo en la imagen Docker
COPY target/priceinfo-0.0.1-SNAPSHOT.jar /app/priceinfo-0.0.1-SNAPSHOT.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/priceinfo-0.0.1-SNAPSHOT.jar"]
