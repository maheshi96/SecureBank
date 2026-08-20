# Stage 1: Build the SecureBank application
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy Maven configuration first for dependency caching
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application and run tests
RUN mvn clean package -DskipTests

# Stage 2: Create a smaller runtime image
FROM eclipse-temurin:17-jre

WORKDIR /app

# Create a non-root user for better container security
RUN useradd --create-home --shell /bin/bash securebank

# Copy the packaged JAR from the build stage
COPY --from=build /app/target/SecureBank.jar app.jar

# Change ownership to the non-root user
RUN chown securebank:securebank /app/app.jar

USER securebank

# Application port
EXPOSE 8080

# Start SecureBank
ENTRYPOINT ["java", "-jar", "app.jar"]