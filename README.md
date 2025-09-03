# springboot-url-shortener

# URL Shortener

A simple URL shortener service built with Spring Boot, Java 22, and Maven.

## Features

- Shorten long URLs
- Redirect short codes to original URLs
- RESTful API endpoints

## Requirements

- Java 22
- Maven

## Project Structure

- `src/main/java` - Application source code
- `src/main/resources` - Configuration and static files
- `src/test/java` - Unit tests

## Setup

1. Clone the repository
2. Build the project (mvn clean install)
3. Run the application (java -jar target/url-shortener-0.0.1-SNAPSHOT.jar)

The service will start on port `9090` (see `src/main/resources/application.yml`).

## For Docker

1. Build the Docker image (Dockerfile provided)
2. Run the container

## For Junits Testing

Run unit tests with: mvn test

## License

OpenSource