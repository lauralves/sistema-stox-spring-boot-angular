FROM openjdk:11-jre-slim

ENV TZ America/Belem

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN apt-get update && apt-get install -y locales && rm -rf /var/lib/apt/lists/* \
    && localedef -i pt_BR -c -f UTF-8 -A /usr/share/locale/locale.alias pt_BR.UTF-8

ENV LANG=pt_BR.UTF-8
ENV LANGUAGE=pt_BR:pt:en

RUN addgroup spring && useradd spring -g spring

USER spring:spring

COPY ./target/@project.name@-@project.version@.@git.commit.id.abbrev@.jar app.jar

ENTRYPOINT ["java",  "-jar", "/app.jar"]

