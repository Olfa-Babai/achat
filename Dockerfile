FROM adoptopenjdk/openjdk11:alpine-slim
COPY /target/tpAchatProject-3.0.0.jar app.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","app.jar"]
