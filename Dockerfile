
FROM gradle:jdk11 AS TEMP_BUILD_IMAGE
ENV APP_HOME=/app/test/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle $APP_HOME

USER root
RUN chown root -R $APP_HOME

CMD ["gradle","test"]
