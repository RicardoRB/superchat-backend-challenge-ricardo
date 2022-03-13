FROM adoptopenjdk/openjdk11:latest
ENV PORT 5000
ENV LOG_LEVEL DEBUG
EXPOSE 5000
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} brokokoly-be.jar
ENTRYPOINT ["java","-jar","/brokokoly-be.jar"]