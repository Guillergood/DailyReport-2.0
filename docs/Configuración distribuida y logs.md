
---
layout: default
title: Configuración distribuida y logs.
nav_order: 17

---

# Configuración distribuida y logs.

{: .d-inline-block }
Nuevo
{: .label .label-purple }


---


Spring usa Commons Logging, usando por defecto Logback, si bien incluye también configuraciones por defecto para utilizar Java Util Logging y Log4J2.

Por defecto Spring Boot, muestra los mensajes de nivel ERROR-level, WARN-level, and INFO-level pero esto se puede cambiar de diferentes maneras.

La mas simple es añadiendo el parámetro --trace o --debugcuando ejecutemos nuestro programa.

```
java -jar APP.JAR –debug
```

Otra manera será especificar en la propiedad ‘logging.level.root’. Esto lo haremos añadiremos la línea correspondiente en el fichero application.properties o a la hora de ejecutarlo, añadiendo el parametro adecuado:

```
java -jar -Dlogging.level.root=DEBUG APP.JAR
```

Una vez más si usamos maven para ejecutar el proceso podremos poner el siguiente comando:

```
mvn spring-boot:run -Dspring-boot.run.arguments=-logging.level.root=TRACE
```

Por supuesto, se permite especificar niveles de logging por paquetes, así, si queremos que nuestra aplicación que esta en el paquete "com.gbv.dailyreport" muestre los mensajes de nivel debug, pero el resto de aplicaciones solo muestren los mensajes de error, escribiríamos:

```
java -jar -Dlogging.level.root=ERROR -D-Dlogging.level.com.gbv.dailyreport=DEBUG APP.JAR
```
El archivo "application.properties" permite la configuración distribuida de cada uno, donde se puede introducir las variables de entorno deseadas. Además de esto, se permite el uso de la herramiento "Consul" y "Zookeper" para facilitar el uso de configuraciones distribuidas.
