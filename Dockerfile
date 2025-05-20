# Etapa de build
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copia apenas os arquivos de configuração para aproveitar cache
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o restante do código
COPY src ./src

# Compila o projeto
RUN mvn clean package -DskipTests

# Etapa de runtime
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copia o jar gerado do estágio anterior
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta usada pela aplicação (ajuste se necessário)
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
