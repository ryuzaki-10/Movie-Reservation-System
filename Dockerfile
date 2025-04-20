FROM eclipse-temurin:17-jdk

# Set the working directory
WORKDIR /app

# Copy the JAR file to the container
COPY build/libs/ticket-reservation-system-plain.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
