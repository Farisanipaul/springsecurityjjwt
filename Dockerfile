FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} springsecurityjjwt-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/springsecurityjjwt-0.0.1-SNAPSHOT.jar"]