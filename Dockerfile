# Use Java 17 runtime
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Copy project files
COPY . .

# Package the application (skip tests for speed)
RUN ./mvnw clean package -DskipTests

# -----------------------------
# Final lightweight image
# -----------------------------
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# Copy the built JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Run the JAR
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
