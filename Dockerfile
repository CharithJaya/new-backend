# Stage 1: Build the app with Maven
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Copy only Maven files first for caching
COPY pom.xml mvnw ./
COPY .mvn .mvn

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Build the JAR (skip tests)
RUN ./mvnw clean package -DskipTests

# Stage 2: Create the runtime image
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (matching Fly.io configuration)
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
