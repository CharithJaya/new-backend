# Use Java 17
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml first (for dependency caching)
COPY mvnw mvnw
COPY mvnw.cmd mvnw.cmd
COPY .mvn .mvn
COPY pom.xml pom.xml

# Download dependencies
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src src

# Build the Spring Boot JAR (skip tests)
RUN ./mvnw clean package -DskipTests

# Copy the built JAR to a consistent name
RUN cp target/*.jar app.jar

# Run the JAR
ENTRYPOINT ["java", "-jar", "/app.jar"]
