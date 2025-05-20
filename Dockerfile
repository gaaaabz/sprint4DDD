# Etapa de build
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de execução
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/quarkus-app/ .

# Railway usa porta 8080 por padrão
EXPOSE 8080

CMD ["java", "-jar", "quarkus-run.jar"]
