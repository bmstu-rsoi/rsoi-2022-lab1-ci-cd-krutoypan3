FROM adoptopenjdk/openjdk11
WORKDIR /app
COPY ./ app/
ENTRYPOINT ["java","-jar", "app/build/libs/rsoi-2022-lab1-ci-cd-krutoypan3.jar"]