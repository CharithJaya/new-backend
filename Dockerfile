# Use Java 17
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy project files
COPY . .

# Make Maven wrapper executable
RUN chmod +x mvnw

# Build the JAR
RUN ./mvnw clean package -DskipTests

# Rename JAR inside /app
RUN cp target/*.jar app.jar

# Expose port
EXPOSE 8080

# Run JAR (path relative to WORKDIR)
ENTRYPOINT ["java","-jar","app.jar"]
