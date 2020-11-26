
FROM csanchez/maven:3-adoptopenjdk-15-openj9
WORKDIR .
COPY pom.xml app/test/
WORKDIR app/test/
CMD ["mvn","test"]



