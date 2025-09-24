# Use Java 17
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy everything
COPY . .

# Give execution permission to Maven wrapper
RUN chmod +x mvnw

# Build the JAR
RUN ./mvnw clean package -DskipTests

# Copy the built JAR to app.jar
RUN cp target/*.jar app.jar

# Run the JAR
ENTRYPOINT ["java","-jar","/app.jar"]
