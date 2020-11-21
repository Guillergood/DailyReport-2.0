
FROM adoptopenjdk/maven-openjdk11
COPY /src /Burocratico/src
COPY /pom.xml /Burocratico
RUN cd Burocratico && mvn clean package -DskipTests && cd .. && cp ./Burocratico/target/Burocratico-0.0.1-SNAPSHOT.jar ./app.jar &&  rm -rf ./Burocratico
CMD ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "./app.jar"]

EXPOSE 8081



