# FROM openjdk:11
# VOLUME /tmp
# EXPOSE 8080
# ARG JAR_FILE=target/fake_twitter-0.0.1-SNAPSHOT.jar
# ADD ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]

FROM eclipse-temurin:17-jdk-focal
EXPOSE 8080:80
WORKDIR /app
 
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
 
COPY src ./src
 
CMD ["./mvnw", "spring-boot:run"]