# Utilisez une image de base officielle de Java
FROM openjdk:17-jdk-slim

# Ajoutez un argument pour spécifier le nom du fichier JAR
ARG JAR_FILE=target/*.jar

# Copiez le fichier JAR dans l'image Docker
COPY ${JAR_FILE} app.jar

# Exposez le port sur lequel l'application Spring Boot va tourner
#EXPOSE 8080
EXPOSE 9090

# Commande pour exécuter l'application Spring Boot
ENTRYPOINT ["java", "-jar", "/app.jar"]