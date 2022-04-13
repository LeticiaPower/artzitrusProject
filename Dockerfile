FROM openjdk:8

ARG ADDITIONAL_OPTS

ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/spring_boot

COPY /target/artzitrus-0.0.1-SNAPSHOT.jar artzitrus-api.jar

SHELL ["bash", "-c"]

EXPOSE 8080

CMD java ${ADDITIONAL_OPTS} -jar artzitrus-api.jar



