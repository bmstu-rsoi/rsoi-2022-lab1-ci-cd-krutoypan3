FROM adoptopenjdk/openjdk11
WORKDIR /app
COPY ./ app/
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx128m", "-jar", "app/build/libs/rsoi-2022-lab1-ci-cd-krutoypan3.jar"]