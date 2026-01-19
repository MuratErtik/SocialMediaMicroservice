FROM amazoncorretto:21.0.2-alpine3.19
LABEL authors="muratertik"
COPY build/libs/ConfigServer-v.0.1.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]





#this file make a new image!
# go to directory and docker build -t socialmedia-configserver:v01 .  for executing in local
#but if you publish in dockerhub
# docker build -t muratertik/socialmedia-configserver:v01 .

# if you have M chip
# docker build --platform linux/amd64 -t muratertik/socialmedia-configserver:v01 .