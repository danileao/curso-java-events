FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/events-1.0.0.jar events-1.0.0.jar
EXPOSE 8080
CMD [ "java", "-jar", "events-1.0.0.jar" ]