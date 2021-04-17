FROM openjdk:8

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDIOTIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/spring_boot

COPY /target/spring-boot*.jar spring_boot_com_mysql.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 5005
EXPOSE 8080

CMD java ${ADDIOTIONAL_OPTS} -jar spring_boot_com_mysql.jar --spring.profiles.active=${PROFILE}