# Stage 1 — Build the app
FROM maven:3.9.11-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .

# ✅ Give execute permission to the Maven wrapper
RUN chmod +x mvnw

# ✅ Then build
RUN ./mvnw clean package -DskipTests || mvn clean package -DskipTests

# Stage 2 — Run the app
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
