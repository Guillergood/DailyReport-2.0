FROM gradle:jdk15 AS TEMP_BUILD_IMAGE
ENV APP_HOME=/app/test/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle $APP_HOME

RUN useradd --home $APP_HOME --user-group --uid 1001 nonRoot
RUN chown nonRoot -R $APP_HOME

CMD ["gradle","bootRun"]