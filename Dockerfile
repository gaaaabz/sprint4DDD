# Usa imagem com Java 17 (ajuste conforme necessário)
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Copia os arquivos do projeto
COPY . .

# Garante que o Maven Wrapper tem permissão de execução
RUN chmod +x ./mvnw

# Define JAVA_HOME explicitamente (normalmente já está setado, mas garantimos)
ENV JAVA_HOME=/opt/java/openjdk
ENV PATH="$JAVA_HOME/bin:$PATH"

# Executa o build
RUN ./mvnw -X clean package

# Cria uma imagem final mais leve
FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=build /app/target/*-runner.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
