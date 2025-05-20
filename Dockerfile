# Etapa 1: Build com Maven e JDK 17
FROM eclipse-temurin:17 AS build

WORKDIR /app

# Copia os arquivos do projeto
COPY pom.xml .
COPY src ./src

# Faz build com Maven
RUN ./mvnw clean package -DskipTests

# Etapa 2: Imagem final com JRE 17
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copia a aplicação empacotada
COPY --from=build /app/target/quarkus-app/lib/ /app/lib/
COPY --from=build /app/target/quarkus-app/*.jar /app/
COPY --from=build /app/target/quarkus-app/app/ /app/app/
COPY --from=build /app/target/quarkus-app/quarkus/ /app/quarkus/

# Executa o JAR gerado pelo Quarkus
CMD ["java", "-jar", "-Dquarkus.http.host=0.0.0.0", "quarkus-run.jar"]
