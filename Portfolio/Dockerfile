FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

COPY target/*.jar /app/Portfolio-0.0.1-SNAPSHOT.jar # Copy the jar file to /app directory

WORKDIR /app # Set the working directory to /app

# Install required dependencies

RUN apk --no-cache add libc6-compat tzdata

EXPOSE 8080

ENTRYPOINT ["java","-jar","Portfolio-0.0.1-SNAPSHOT.jar"] # Execute the jar file
