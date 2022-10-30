FROM maven:3.8.6-jdk-11 AS builder

ADD ./pom.xml pom.xml
RUN mvn dependency:resolve

ADD ./src src/
RUN mvn clean package

FROM tomcat:9.0.53-jdk11-openjdk
COPY --from=builder target/demo-servlet-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/servlet.war

FROM tomcat:9.0.53-jdk11-openjdk
RUN mv /usr/local/tomcat/webapps.dist/* /usr/local/tomcat/webapps

EXPOSE 8080

