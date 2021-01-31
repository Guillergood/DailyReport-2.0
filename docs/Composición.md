---
layout: default
title: Documentación del fichero de composición.
nav_order: 20

---

# Documentación del fichero de composición.

{: .d-inline-block }
Nuevo
{: .label .label-purple }


---

El fichero de composición de servicios pudo probarse con anterioridad debido al trabajo extra que realicé. 
Por tanto he recopilado esa información, además de investigar posibles mejoras, dejando el fichero de esta manera:

```Dockerfile
version: '3.3'

services:
  # Servicio de mongodb para guardar los datos
  # con la imagen de bitnami de mongodb
  # indicando que usa una red para comunicarse con el proyecto
  # mapeando el puerto 27017 al mismo puerto
  mongodb:
    image: 'bitnami/mongodb:latest'
    container_name: "mongodb"
    networks:
      - dailyreport-network
    ports:
      - 27017:27017

  # Servicio del proyecto que construye el contenedor con el DockerfileTest
  # utilizando la misma red que el servicio mongodb.
  # Además utiliza los archivos locales como volumen para poder cambiarlos
  # sin necesidad de reconstruir todo de nuevo. Y la carpeta "log" para sacar el log del servicio
  # Indicamos que el servicio se liga con mongodb
  # Indicamos unas variables de entorno necesarias para configurar Spring con mongodb
  # y optimizar las conexiones del proyecto.
  # Por último, el servicio depende de mongodb y se mapea el puerto 8080 al mismo puerto
  dailyreport:
    build: .
    image: dailyreport-2.0
    networks:
      - dailyreport-network
    container_name: "dailyreport-2.0"
    volumes:
      - ./:/app/test
      - ./log:/log
    links:
      - mongodb
    environment:
      - ADDITIONAL_OPTS=-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=27017
      - MONGODB_HOST=mongodb
      - MONGODB_PORT=27017
    depends_on:
      - mongodb
    ports:
      - 8080:8080

# Se crea una nueva red para ligar ambos servicios.
networks:
  dailyreport-network:
    driver: bridge
```

Como se puede observar en el fichero, hay dos servicios "mongodb" y "dailyreport".
En "mongodb" se indica que usa una red para comunicarse con el proyecto mapeando el puerto 27017 al mismo puerto.

En "dailyreport" se indica que se construye la imagen a partir del Dockerfile existente en el proyecto, utiliza la misma red que "mongodb".
Utiliza 2 vólumenes uno para el código del proyecto, para poder seguir desarrollando sin tener que volver a construir la imagen y otro para sacar el log.

También se detalla que tiene el servicio "mongodb" ligado, unas variables de entorno para optimizar el servidor, y parámetros de la base de datos.

Por último, este servicio depende del anterior y el puerto de mapeo es el 8080.

Al final del archivo se declara la red a usar entre ellos dos, "dailyreport-network" que permite la comunicación entre ellos.

Finalmente, se quiere destacar: 
No es buena práctica poner los puertos en los archivos de configuración, se ha hecho así para detallar de mejor manera cómo se ha hecho y seguir desarrollando este proyecto. 
Anteriormente realicé esta labor con Github Secrets pero no permitía mostrar las variables, como es normal.

