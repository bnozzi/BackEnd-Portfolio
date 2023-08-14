
FROM eclipse-temurin17-jdk-alpine

VOLUME /tmp

# Copy the jar file to /app directory
COPY target/Portfolio-0.0.1-SNAPSHOT.jar /app/Portfolio-0.0.1-SNAPSHOT.jar
# Fixed typo in the path of the jar file to be copied

# Set the working directory to /app
WORKDIR /app

# Install required dependencies
# Added openjdk11 package to ensure compatibility with Java 17
RUN apk --no-cache add libc6-compat tzdata openjdk11

EXPOSE 8080

# Execute the jar file using the java command
CMD ["java","-jar","Portfolio-0.0.1-SNAPSHOT.jar"]
# Fixed missing "CMD" instruction and removed empty string at the beginning of the command
