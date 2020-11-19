FROM openjdk:11-jdk-slim
WORKDIR app
ENV SPRING_PROFILES_ACTIVE prod
COPY gradle/ gradle/
COPY build.gradle build.gradle
COPY settings.gradle settings.gradle
COPY gradlew gradlew
RUN ./gradlew dependencies

COPY src src
RUN ./gradlew build

EXPOSE 8000

ENTRYPOINT ["java","-jar","build/libs/inventory-0.0.1-SNAPSHOT.jar"]