# Build stage
FROM eclipse-temurin:17-jdk as build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN chmod +x mvnw

COPY src ./src

RUN ./mvnw clean package -DskipTests -B

# Runtime stage
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY --from=build /app/target/quarkus-app /app/target/quarkus-app

CMD ["java", "-jar", "target/quarkus-app/quarkus-run.jar"]
