FROM adoptopenjdk/openjdk11
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} rsoi-2022-lab1-ci-cd-krutoypan3.jar
RUN mkdir /app
WORKDIR app/
ENTRYPOINT ["java","-jar","/rsoi-2022-lab1-ci-cd-krutoypan3.jar"]