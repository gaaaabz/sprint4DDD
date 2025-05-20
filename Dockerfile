FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests -Dquarkus.package.type=fast-jar

CMD ["java", "-jar", "target/quarkus-app/quarkus-run.jar"]
