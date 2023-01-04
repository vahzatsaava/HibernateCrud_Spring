FROM openjdk:17-jdk-alpine
MAINTAINER Tsaava Vazha
COPY target/HibernateCrud_Spring-0.0.1-SNAPSHOT.jar spring_box.jar
ENTRYPOINT ["java","-jar","/spring_box.jar"]