# Use a lightweight Java runtime
FROM eclipse-temurin:21-jdk-jammy

# Set the working directory in the container
WORKDIR /app

# Copy the jar file into the container
#COPY target/*.jar DiscoveryServer-0.0.1-SNAPSHOT.jar
COPY target/DiscoveryServer-0.0.1-SNAPSHOT.jar discoveryserver.jar
#COPY target/*.jar discoveryserver.jar
# Expose the port your Spring Boot app runs on
EXPOSE 8761
# Command to run the jar file
ENTRYPOINT ["java", "-jar", "discoveryserver.jar"]
