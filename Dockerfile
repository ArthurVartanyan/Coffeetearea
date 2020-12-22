FROM openjdk:11
ADD build/libs/Coffeetearea-0.0.1-SNAPSHOT.jar Coffeetearea-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Coffeetearea-0.0.1-SNAPSHOT.jar"]