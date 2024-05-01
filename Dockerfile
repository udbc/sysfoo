# Stage 1: Build the application
FROM maven:3.8.1-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM build as test 
CMD mvn clean test 

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/sysfoo-0.0.1-SNAPSHOT.jar ./sysfoo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "sysfoo.jar"]
