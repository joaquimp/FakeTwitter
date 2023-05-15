FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/fake_twitter-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]