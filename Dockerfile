FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copia todo o conteúdo do projeto
COPY . .

# Garante permissão de execução
RUN chmod +x mvnw

# Roda o Maven Wrapper com os comandos necessários
RUN ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install

# Define o comando para executar a aplicação
CMD ["java", "-jar", "target/quarkus-app/quarkus-run.jar"]
