FROM openjdk:11-jre-slim
WORKDIR /app
COPY build/libs/workout_journal-0.0.1-SNAPSHOT.jar /app/workout-journal-app.jar
ENTRYPOINT ["java", "-jar", "workout-journal-app.jar"]