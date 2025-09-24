#
# A correct multi-stage Dockerfile for a Spring Boot application
#

# --- Stage 1: Build the application ---
# Use a full JDK image to build the application.
FROM eclipse-temurin:17-jdk as build

# Set the working directory inside the container.
WORKDIR /app

# Copy the Maven project files first to leverage Docker's build cache.
# This ensures that dependencies are only downloaded when the pom.xml changes.
COPY pom.xml .
COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn

# Download all dependencies. The '-B' flag makes the build non-interactive.
# This step is cached as long as the pom.xml file doesn't change.
RUN ./mvnw dependency:go-offline -B

# Copy the rest of the source code.
COPY src src

# Build the Spring Boot application, creating a runnable JAR file.
# The '-DskipTests' flag skips the tests for a faster build.
RUN ./mvnw clean package -DskipTests

# --- Stage 2: Create the final, lightweight image ---
# Use a minimal JRE (Java Runtime Environment) to run the application.
# This image does not contain the build tools, making it much smaller and more secure.
FROM eclipse-temurin:17-jre

# Set the working directory for the final image.
WORKDIR /app

# Copy the built JAR file from the 'build' stage into this new image.
# We are only copying the final artifact, not the source code or build tools.
COPY --from=build /app/target/*.jar app.jar

# Expose the port on which the application will run.
EXPOSE 8080

# Define the command to run the application when the container starts.
# CMD is preferred over ENTRYPOINT for ease of overriding.
CMD ["java", "-jar", "app.jar"]
