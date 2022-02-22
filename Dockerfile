FROM maven:3.5.2-jdk-8 AS build
COPY src /app2/src/
COPY pom.xml /app2/
WORKDIR /app2/
RUN mvn -f /app2/pom.xml clean package


#
# Package stage
#
FROM openjdk:11
EXPOSE 8080

COPY --from=build /app2/target/hello-world-webapp-1.0.0-SNAPSHOT.jar /usr/lib/hello-world-webapp-1.0.0-SNAPSHOT.jar

CMD java -jar /usr/lib/hello-world-webapp-1.0.0-SNAPSHOT.jar