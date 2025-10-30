# Use official Java runtime as base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the jar from the target folder
COPY target/secure-search-cloud-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Render will map this automatically)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
