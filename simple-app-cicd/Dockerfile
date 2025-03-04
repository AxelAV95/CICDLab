# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Install Maven
RUN apt-get update && apt-get install -y maven

# Copy the pom.xml file to the working directory
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy the rest of the source code
COPY . .

# Build the application
RUN mvn clean install

# Expose the port the app runs on
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/simple-app-cicd-0.0.1-SNAPSHOT.jar"]

