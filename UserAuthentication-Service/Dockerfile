FROM openjdk:11-jre-slim
WORKDIR /usr/src
ENV MYSQL_URL MYSQL_URL:jdbc:mysql://localhost:3306/keepnotestep5
ENV MYSQL_USERNAME root
ENV MYSQL_PASSWORD password
ADD ./target/UserAuthentication-Service-0.0.1-SNAPSHOT.jar /usr/src/UserAuthentication-Service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "UserAuthentication-Service-0.0.1-SNAPSHOT.jar"]