FROM maven:3.5.3-jdk-8-alpine

RUN mkdir webapp

COPY ./ ./

RUN mvn clean install
