FROM adoptopenjdk/openjdk11
ARG JAR_FILE="build/libs/*.jar"
COPY ${JAR_FILE} "rsoi-2022-lab1-ci-cd-krutoypan3.jar"
RUN mkdir "/app"
WORKDIR "app/"
ADD "./build/libs/rsoi-2022-lab1-ci-cd-krutoypan3.jar" "./rsoi-2022-lab1-ci-cd-krutoypan3-cicd.jar"
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=prod", "/rsoi-2022-lab1-ci-cd-krutoypan3.jar"]