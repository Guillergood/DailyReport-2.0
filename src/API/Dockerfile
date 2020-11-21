
FROM adoptopenjdk/maven-openjdk11
COPY /src /API/src
COPY /pom.xml /API
RUN cd API && mvn clean package -DskipTests && cd .. && cp ./API/target/api-0.0.1-SNAPSHOT.jar ./app.jar &&  rm -rf ./API
CMD ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "./app.jar"]



