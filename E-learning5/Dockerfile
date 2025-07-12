# Sử dụng image Maven để build project
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

# Sử dụng image Tomcat 9 với JDK 17 để chạy ứng dụng
FROM tomcat:9.0-jdk17-temurin
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=build /app/target/elearning5.war /usr/local/tomcat/webapps/elearning5.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
