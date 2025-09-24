# Use Java 17
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy Maven wrapper and pom.xml first for dependency caching
COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (offline mode)
RUN ./mvnw dependency:go-offline -B

# Copy source code
COPY src src

# Build the Spring Boot JAR
RUN ./mvnw clean package -DskipTests

# Copy the built JAR to app.jar
RUN cp target/*.jar app.jar

# Run the JAR
ENTRYPOINT ["java","-jar","/app.jar"]
