# Use a lightweight Java runtime
FROM eclipse-temurin:21-jdk-jammy

# Set the working directory in the container
WORKDIR /app

# Copy the jar file into the container
#COPY target/*.jar DiscoveryServer-0.0.1-SNAPSHOT.jar
COPY target/userServices-0.0.1-SNAPSHOT.jar userservices.jar
#COPY target/*.jar userservices.jar
# Expose the port your Spring Boot app runs on
EXPOSE 8080
# Command to run the jar file
ENTRYPOINT ["java", "-jar", "userservices.jar"]
