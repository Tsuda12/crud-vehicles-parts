FROM openjdk:17-alpine

COPY target/*.jar parts-registration.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "parts-registration.jar"]