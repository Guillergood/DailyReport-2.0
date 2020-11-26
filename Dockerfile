
FROM csanchez/maven:latest
WORKDIR .
COPY pom.xml app/test/
WORKDIR app/test/
CMD ["mvn","test"]



