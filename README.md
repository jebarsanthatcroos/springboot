# Spring Boot Project

A Spring Boot application built with Java and Maven.

## Features

- Spring Boot
- Spring Security
- REST API
- User Management
- Maven Build
- Docker Support
- Docker Compose

## Technologies Used

- Java 17 (or your Java version)
- Spring Boot
- Spring Security
- Maven
- Docker
- Git

## Project Structure

```
src
├── main
│   ├── java
│   │   └── org/example/springboot
│   │       ├── config
│   │       ├── controllers
│   │       ├── entity
│   │       ├── model
│   │       ├── repositoriey
│   │       ├── services
│   │       └── SpringbootApplication.java
│   └── resources
│       └── application.yaml
└── test
```

## Getting Started

### Clone the repository

```bash
git clone https://github.com/jebarsanthatcroos/springboot.git
cd springboot
```

### Build the project

```bash
mvn clean install
```

### Run the application

```bash
mvn spring-boot:run
```

The application will start at:

```
http://localhost:8080
```

## Docker

Build the Docker image:

```bash
docker build -t springboot-app .
```

Run the container:

```bash
docker run -p 8080:8080 springboot-app
```

Or use Docker Compose:

```bash
docker compose up
```

## API

Example endpoint:

```
GET /
```

Update this section with your application's API endpoints as you add them.

## Author

**Jebarsanthatcroos**

GitHub: https://github.com/jebarsanthatcroos