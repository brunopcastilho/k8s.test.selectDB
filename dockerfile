FROM openjdk:8-jdk-alpine
COPY selectDB-0.0.1-SNAPSHOT.jar selectDB-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "/selectDB-0.0.1-SNAPSHOT.jar"]