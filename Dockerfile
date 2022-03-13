FROM java:8-jdk as build

ENV BUILD_HOME=/build

WORKDIR $BUILD_HOME

COPY gradle $BUILD_HOME/gradle
COPY build.gradle settings.gradle gradlew $BUILD_HOME
COPY . .

RUN ./gradlew build -x test

FROM java:8-jdk

ENV ARTIFACT_NAME=superchat-1.0.0.jar
ENV APP_HOME=/app
ENV BUILD_HOME=/build

WORKDIR $APP_HOME

COPY --from=build $BUILD_HOME/build/libs/$ARTIFACT_NAME .

CMD ["sh", "-c", "java -jar -Dspring.profiles.active=docker-dev $ARTIFACT_NAME"]