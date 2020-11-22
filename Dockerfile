FROM adoptopenjdk/maven-openjdk11
WORKDIR .
COPY /src/dailyreport/src /dailyreport/src
COPY /src/dailyreport/pom.xml /dailyreport
RUN cd dailyreport && mvn clean package
WORKDIR ./dailyreport
CMD ["mvn", "test"]


