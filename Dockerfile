#
# A correct multi-stage Dockerfile for a Spring Boot application
#

# --- Stage 1: Build the application ---
# Use a full JDK image to build the application.
FROM eclipse-temurin:17-jdk as build

# Set the working directory inside the container.
WORKDIR /app

# Copy the Maven project files first to leverage Docker's build cache.
COPY pom.xml .
COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn

# Download all dependencies.
RUN ./mvnw dependency:go-offline -B

# Copy the rest of the source code.
COPY src src

# Build the Spring Boot application, creating a runnable JAR file.
RUN ./mvnw clean package -DskipTests

# --- Stage 2: Create the final, lightweight image ---
# Use a minimal JRE (Java Runtime Environment) to run the application.
FROM eclipse-temurin:17-jre

# Set the working directory for the final image.
WORKDIR /app

# Copy the built JAR file from the 'build' stage into this new image.
COPY --from=build /app/target/*.jar app.jar

# Expose the port on which the application will run.
EXPOSE 8080

# Define the command to run the application when the container starts.
CMD ["java", "-jar", "app.jar"]
