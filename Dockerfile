# Etapa 1: build da aplicação
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /build

# Copia o código e o pom.xml
COPY pom.xml .
COPY src ./src

# Faz o download das dependências e compila a aplicação
RUN mvn clean package -DskipTests

# Etapa 2: imagem final para rodar no Railway
FROM eclipse-temurin:17

# Define o diretório de trabalho na imagem final
WORKDIR /app

# Copia o JAR gerado da etapa de build
COPY --from=build /build/target/*-runner.jar app.jar

# Expõe a porta padrão usada pelo Quarkus
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
