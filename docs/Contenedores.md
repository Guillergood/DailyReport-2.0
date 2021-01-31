---
layout: default
title: Documentación y justificación de la configuración de cada uno de los contenedores que lo componen.
nav_order: 19

---

# Documentación y justificación de la configuración de cada uno de los contenedores que lo componen.

{: .d-inline-block }
Nuevo
{: .label .label-purple }


---

Como se ha dicho en la [composición del clúster](https://guillergood.github.io/DailyReport-2.0/docs/Contenedores.html), el proyecto va a estar conformardo por dos contenedores.

Uno el cual será la base de datos y otro que contendrá el proyecto. Para la base de datos, se va a optar por el contenedor de Bitnami. 
Principalmente, hay dos opciones para contenedores de MongoDB, el propio MongoDB y Bitnami.

Bitnami realiza un seguimiento de cerca de los cambios de fuente ascendentes y publica rápidamente nuevas versiones de esta imagen utilizando nuestros sistemas automatizados.

Con las imágenes de Bitnami, las últimas funciones y correcciones de errores están disponibles lo antes posible.
Los contenedores de Bitnami, las máquinas virtuales y las imágenes en la nube utilizan los mismos componentes y enfoque de configuración, lo que facilita el cambio entre formatos según las necesidades de su proyecto.

Las imágenes están basadas en minideb, una imagen de contenedor minimalista basada en Debian que brinda una imagen de contenedor base pequeña y la familiaridad de una distribución de Linux líder.
Todas las imágenes de Bitnami disponibles en Docker Hub están firmadas con Docker Content Trust (DCT).

Las imágenes de contenedores de Bitnami se publican diariamente con los últimos paquetes de distribución disponibles.

Con respecto al servidor se actualizará la versión del Dockerfile para que en vez de probar el proyecto con los test de éste mismo, ejecute el servidor para poder desplegarlo, quedando de está manera:

```Dockerfile
FROM gradle:jdk15 AS TEMP_BUILD_IMAGE
ENV APP_HOME=/app/test/
WORKDIR $APP_HOME
COPY build.gradle settings.gradle $APP_HOME

RUN useradd --home $APP_HOME --user-group --uid 1001 nonRoot
RUN chown nonRoot -R $APP_HOME

CMD ["gradle","bootRun"]
```