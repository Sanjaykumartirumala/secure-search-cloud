# ---------- Stage 1: Build ----------
FROM eclipse-temurin:17-jdk-alpine AS builder
# Install Maven & CA certificates
RUN apk add --no-cache maven ca-certificates
WORKDIR /app
COPY . .
RUN chmod +x mvnw || true
RUN ./mvnw clean package -DskipTests || mvn clean package -DskipTests

# ---------- Stage 2: Run ----------
FROM eclipse-temurin:17-jdk-alpine
# Ensure CA certificates are available for SSL
RUN apk add --no-cache ca-certificates
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
