FROM eclipse-temurin:22-jdk-alpine

WORKDIR /app

COPY target/url-shortener-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "app.jar"]