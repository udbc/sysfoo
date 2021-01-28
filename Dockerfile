FROM maven:3.6.3-jdk-11-slim as build

WORKDIR /opt/demo

COPY . /opt/demo

RUN mvn package -D skipTests



FROM tomcat as run

WORKDIR /usr/local/tomcat

COPY --from=build /opt/demo/target/sysfoo.war webapps/

CMD catalina.sh run