# Use Eclipse Temurin base image for Java 23
FROM eclipse-temurin:23-jdk

# Set working directory inside container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY target/gli-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 for the Spring Boot application
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
