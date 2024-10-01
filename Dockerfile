FROM openjdk:21-jdk

MAINTAINER tsuda.com

COPY target/backend-0.0.1-SNAPSHOT.jar backend.jar

ENTRYPOINT ["java", "-jar", "/backend.jar"]