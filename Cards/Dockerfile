#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim as build

#Information around who maintains the image
MAINTAINER sovansingh.com

# Add the application's jar to the container
COPY target/Cards-1.0.jar Cards-1.0.jar

#execute the application
ENTRYPOINT ["java","-jar","/Cards-1.0.jar"]