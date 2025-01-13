# Usa una imagen base de Java
FROM arm64v8/eclipse-temurin:21-jdk


# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el JAR generado por Maven o Gradle
COPY target/example-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
