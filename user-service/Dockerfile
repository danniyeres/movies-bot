FROM openjdk:21-slim
WORKDIR /app
COPY target/user-service-0.0.1-SNAPSHOT.jar user-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "user-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8081