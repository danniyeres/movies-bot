FROM openjdk:21-slim
WORKDIR /app
COPY target/storage-service-0.0.1-SNAPSHOT.jar storage-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "storage-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8082