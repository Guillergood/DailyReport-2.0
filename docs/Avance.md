---
layout: default
title: Avance
nav_order: 9
---

# Avance
{: .d-inline-block }
Nuevo
{: .label .label-purple }


---

Se ha avanzado en los siguientes puntos:

[Se ha realizado una limpieza de archivos](https://github.com/Guillergood/DailyReport-2.0/issues/69), donde se han borrado archivos innecesarios

[Se ha realizado la orquestación de los diferentes servicios con docker-compose](https://github.com/Guillergood/DailyReport-2.0/issues/66):

### Docker Compose

Además como trabajo adicional, se ha configurado la orquestación de los servicios con `docker-compose`, donde se han definido los diferentes servicios a orquestar:

### Dockerfile de Animal

```bash
FROM adoptopenjdk/maven-openjdk11
WORKDIR .
COPY /src /Animal/src
COPY /pom.xml /Animal
RUN cd Animal && mvn clean package -DskipTests && cd .. && cp ./Animal/target/Animal-0.0.1-SNAPSHOT.jar ./app.jar &&  rm -rf ./Animal
CMD ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "./app.jar"]

EXPOSE 8080
```

### Dockerfile de Api

```bash
FROM adoptopenjdk/maven-openjdk11
COPY /src /API/src
COPY /pom.xml /API
CMD ["mvn","test"]
```

### Dockerfile de Burocratico

```bash
FROM adoptopenjdk/maven-openjdk11
COPY /src /Burocratico/src
COPY /pom.xml /Burocratico
RUN cd Burocratico && mvn clean package -DskipTests && cd .. && cp ./Burocratico/target/Burocratico-0.0.1-SNAPSHOT.jar ./app.jar &&  rm -rf ./Burocratico
CMD ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "./app.jar"]

EXPOSE 8081
```

### Dockerfile de Cuidador

```bash
FROM adoptopenjdk/maven-openjdk11
COPY /src /Cuidador/src
COPY /pom.xml /Cuidador
RUN cd Cuidador && mvn clean package -DskipTests && cd .. && cp ./Cuidador/target/Cuidador-0.0.1-SNAPSHOT.jar ./app.jar &&  rm -rf ./Cuidador
CMD ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "./app.jar"]

EXPOSE 8082
```



- Una base de datos para cada servicio`mongoanimal`, `mongocuidador`, `mongoburocratico` y`mongoapi` :

  ```yaml
    mongoanimal:
      image: 'bitnami/mongodb:latest'
      container_name: "mongoanimal"
      ports:
        - '27017:27017'
    mongocuidador:
      image: 'bitnami/mongodb:latest'
      container_name: "mongocuidador"
      ports:
        - '27018:27017'
    mongoburocratico:
      image: 'bitnami/mongodb:latest'
      container_name: "mongoburocratico"
      ports:
        - '27019:27017'
    mongoapi:
      image: 'bitnami/mongodb:latest'
      container_name: "mongoapi"
      ports:
        - '27020:27017'
        
  ```
  
- Y un apartado para cada servicio donde tiene sus diferentes características`animal`, `cuidador`, `burocratico` y`api` :

  ```yaml
  animal:
      build: ./src/Animal
      image: dailyreport-animal
      container_name: "animal"
      links:
        - mongoanimal
      environment:
        - ADDITIONAL_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8080
        - MONGODB_HOST=mongoanimal
        - MONGODB_PORT=27017
  
      depends_on:
        - mongoanimal
      ports:
        - "8080:8080"
    cuidador:
      build: ./src/Cuidador
      image: dailyreport-cuidador
      container_name: "cuidador"
      links:
        - mongocuidador
      environment:
        - ADDITIONAL_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8082
        - MONGODB_HOST=mongocuidador
        - MONGODB_PORT=27017
  
      depends_on:
        - mongocuidador
      ports:
        - "8082:8082"
  
    burocratico:
      build: ./src/Burocratico
      image: dailyreport-burocratico
      container_name: "burocratico"
      links:
        - mongoburocratico
      environment:
        - ADDITIONAL_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8081
        - MONGODB_HOST=mongoburocratico
        - MONGODB_PORT=27017
  
      depends_on:
        - mongoburocratico
        - cuidador
        - animal
      ports:
        - "8081:8081"
    api:
      build: ./src/API
      image: dailyreport-api
      container_name: "api"
      links:
        - mongoapi
      environment:
        - ADDITIONAL_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000
      depends_on:
        - mongoapi
        - cuidador
        - animal
        - burocratico
  ```

[Se ha añadido variables secretas en Github Secrets](https://github.com/Guillergood/DailyReport-2.0/issues/67):

### Configuración de Github secrets

Como se ha observado en el archivo anterior, se ha introducido los valores directamente. Esto no es una buena práctica. Para ello se ha definido un archivo de [Github Actions](https://docs.github.com/es/free-pro-team@latest/actions/reference/workflow-syntax-for-github-actions) donde se quiere pasar como variables esos valores no seguros.

Gracias a *Wojciech Krzywiec* por su extenso [tutorial](https://medium.com/faun/continuous-integration-of-java-project-with-github-actions-7a8a0e8246ef) sobre estas materias y más.

```yaml
name: Daily Report Push
on: [push]

jobs:
  build:
    strategy:
      #Matriz donde se van a guardar valores que se van a utilizar
      matrix:
        platform: [ubuntu-latest]
        JDK: [11]
    
    runs-on: ${{ "matrix.platform }}
    
    steps:
    #Utiliza "checkout" para poder acceder al repositorio
    - uses: actions/checkout@v2
    #Uno de los nombres de la acción que vamos a hacer (para ser más legible)
    - name: Despliega Java con el JDK ${{ "matrix.JDK }}
      #Utiliza "setup-java" para configurar java...
      uses: actions/setup-java@v1
      with:
        #... con el JDK que se ha indicado
        java-version: ${{ "matrix.JDK }}
        
    - name: Utiliza las variables globales para todo el proyecto
      #Utiliza "allenevans/set-env" que permite definir variables que se pueden utilizar en todo el despliegue
      uses: allenevans/set-env@v2.0.0
      with:
          PORT_HOST_API: ${{ "secrets.PORT_HOST_API }}
          PORT_HOST_CUIDADOR: ${{ "secrets.PORT_HOST_CUIDADOR }}
          PORT_HOST_BUROCRATICO: ${{ "secrets.PORT_HOST_BUROCRATICO }}
          PORT_HOST_ANIMAL: ${{ "secrets.PORT_HOST_ANIMAL }}
          
          PORT_DB_DEFAULT: ${{ "secrets.DEFAULT_DB_PORT }}
          PORT_DB_API: ${{ "secrets.PORT_DB_API }}
          PORT_DB_CUIDADOR: ${{ "secrets.PORT_DB_CUIDADOR }}
          PORT_DB_BUROCRATICO: ${{ "secrets.PORT_DB_BUROCRATICO }}
          PORT_DB_ANIMAL: ${{ "secrets.PORT_DB_ANIMAL }}
```

*Por el momento este archivo se queda con esta configuración, habría que mejorarlo*.

Por último esas variables son introducidas en el repositorio en la opción de Secretos (*"secrets*), donde será reemplazadas por Github. 

Al final el archivo `docker-compose.yml` quedaría así:

```yaml
version: '3.3'

services:
  mongoanimal:
    image: 'bitnami/mongodb:latest'
    container_name: "mongoanimal"
    ports:
      - '${{ "PORT_DB_ANIMAL }}:${{ "PORT_DB_DEFAULT }}'
  mongocuidador:
    image: 'bitnami/mongodb:latest'
    container_name: "mongocuidador"
    ports:
      - '${{ "PORT_DB_CUIDADOR }}:${{ "PORT_DB_DEFAULT }}'
  mongoburocratico:
    image: 'bitnami/mongodb:latest'
    container_name: "mongoburocratico"
    ports:
      - '${{ "PORT_DB_BUROCRATICO }}:${{ "PORT_DB_DEFAULT }}'
  mongoapi:
    image: 'bitnami/mongodb:latest'
    container_name: "mongoapi"
    ports:
      - '${{ "PORT_DB_API }}:${{ "PORT_DB_DEFAULT }}'
  animal:
    build: ./src/Animal
    image: dailyreport-animal
    container_name: "animal"
    links:
      - mongoanimal
    environment:
      - ADDITIONAL_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=${{ "PORT_HOST_ANIMAL }}
      - MONGODB_HOST=mongoanimal
      - MONGODB_PORT=${{ "PORT_DB_DEFAULT }}

    depends_on:
      - mongoanimal
    ports:
      - "${{ "PORT_HOST_ANIMAL }}:${{ "PORT_HOST_ANIMAL }}"
  cuidador:
    build: ./src/Cuidador
    image: dailyreport-cuidador
    container_name: "cuidador"
    links:
      - mongocuidador
    environment:
      - ADDITIONAL_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=${{ "PORT_HOST_CUIDADOR }}
      - MONGODB_HOST=mongocuidador
      - MONGODB_PORT=${{ "PORT_DB_DEFAULT }}

    depends_on:
      - mongocuidador
    ports:
      - "${{ "PORT_HOST_CUIDADOR }}:${{ "PORT_HOST_CUIDADOR }}"

  burocratico:
    build: ./src/Burocratico
    image: dailyreport-burocratico
    container_name: "burocratico"
    links:
      - mongoburocratico
    environment:
      - ADDITIONAL_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=${{ "PORT_HOST_BUROCRATICO }}
      - MONGODB_HOST=mongoburocratico
      - MONGODB_PORT=${{ "PORT_DB_DEFAULT }}

    depends_on:
      - mongoburocratico
      - cuidador
      - animal
    ports:
      - "${{ "PORT_HOST_BUROCRATICO }}:${{ "PORT_HOST_BUROCRATICO }}"
  api:
    build: ./src/API
    image: dailyreport-api
    container_name: "api"
    links:
      - mongoapi
    environment:
      - ADDITIONAL_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=${{ "PORT_HOST_API }}
    depends_on:
      - mongoapi
      - cuidador
      - animal
      - burocratico
```
