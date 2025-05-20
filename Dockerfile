# Etapa 1 - build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /build

COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2 - runtime
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copia o app gerado no formato "fast-jar"
COPY --from=build /build/target/quarkus-app /app

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
