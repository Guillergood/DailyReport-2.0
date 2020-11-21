
FROM adoptopenjdk/maven-openjdk11
COPY /src /Animal/src
COPY /pom.xml /Animal
RUN cd Animal && mvn clean package -DskipTests && cd .. && cp ./Animal/target/Animal-0.0.1-SNAPSHOT.jar ./app.jar &&  rm -rf ./Animal
CMD ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "./app.jar"]

EXPOSE 8000



