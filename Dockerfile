
FROM adoptopenjdk/maven-openjdk11
WORKDIR .
COPY /src/Animal/src /src/Animal/src
COPY /src/Animal/pom.xml /src/Animal
COPY /src/Cuidador/src /src/Cuidador/src
COPY /src/Cuidador/pom.xml /src/Cuidador
COPY /src/Burocratico/src /src/Burocratico/src
COPY /src/Burocratico/pom.xml /src/Burocratico
COPY /src/API/src /src/API/src
COPY /src/API/pom.xml /src/API
COPY /pom.xml /
CMD ["mvn","test"]



