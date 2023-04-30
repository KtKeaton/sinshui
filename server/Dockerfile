####local直接啟用docker設定(自動build)####
FROM maven:3.8.3-openjdk-17 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean install

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /usr/src/app/target/$JARFILE /usr/app/$JARFILE
EXPOSE 8080
WORKDIR /usr/app
CMD java -jar $JARFILE

####local直接啟用docker設定(手動build)####
#FROM openjdk:17.0.1-jdk-slim
#COPY target/$JARFILE /usr/app/$JARFILE
#WORKDIR /usr/app
#CMD java -jar $JARFILE
#EXPOSE 8080

#### VM 啟用docker設定(手動build)####
#FROM openjdk:17.0.1-jdk-slim
#COPY $JARFILE /usr/app/$JARFILE
#WORKDIR /usr/app
#CMD java -jar $JARFILE
#EXPOSE 8080
