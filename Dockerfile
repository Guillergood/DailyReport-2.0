FROM adoptopenjdk/maven-openjdk11
WORKDIR .
COPY /src/dailyreport/src /dailyreport/src
COPY /pom.xml /dailyreport
RUN cd dailyreport && mvn test


