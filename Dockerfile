# Use Java 17
FROM eclipse-temurin:17-jdk

# Set working directory inside the container
WORKDIR /app

# Copy Maven wrapper and project files
COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (offline)
RUN ./mvnw dependency:go-offline -B# Use Java 17 JDK
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml first to leverage Docker cache
COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies offline
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src src

# Build the Spring Boot application
RUN ./mvnw clean package -DskipTests

# Copy the built JAR to app.jar
RUN cp target/*.jar app.jar

# Run the JAR
ENTRYPOINT ["java", "-jar", "/app/app.jar"]


# Copy the source code
COPY src src

# Build the JAR (skip tests for faster build)
RUN ./mvnw clean package -DskipTests

# Copy the built JAR to a simple name
RUN cp target/*.jar app.jar

# Run the JAR
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
