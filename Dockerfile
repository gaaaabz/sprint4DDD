# Etapa 1: build da aplicação
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /build

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Etapa 2: imagem final
FROM eclipse-temurin:17
WORKDIR /app

# Copia o JAR com nome fixo
COPY --from=build /build/target/*-runner.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
