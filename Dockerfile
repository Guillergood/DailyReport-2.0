
FROM adoptopenjdk/maven-openjdk11
WORKDIR .
COPY /src /src
COPY /pom.xml /
CMD ["mvn","test"]



