
FROM adoptopenjdk/maven-openjdk11
COPY /src /Cuidador/src
COPY /pom.xml /Cuidador
RUN cd Cuidador && mvn clean package -DskipTests && cd .. && cp ./Cuidador/target/Cuidador-0.0.1-SNAPSHOT.jar ./app.jar &&  rm -rf ./Cuidador
CMD ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "./app.jar"]

EXPOSE 8082



