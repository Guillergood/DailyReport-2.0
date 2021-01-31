---
layout: default
title: Documentación y justificación de la estructura del clúster.
nav_order: 18

---

# Documentación y justificación de la estructura del clúster.

{: .d-inline-block }
Nuevo
{: .label .label-purple }


---
Analizando los requisitos del proyecto para funcionar, se destacan principalmente dos: una base de datos y la propia implementación de Spring Boot.

Con respecto a la base de datos, hay dos principales formas de persistencia de datos, la relacional y la no relacional. Pensando en una base de datos relacional como MySQL, cualquier tipo de aplicación que requiera transacciones de varias filas, como un sistema de contabilidad, sería más adecuada para una base de datos relacional.

Por otro lado, hay una variedad de casos de uso en los que MongoDB es adecuado. Algunos de estos incluyen análisis en tiempo real, administración de contenido, Internet de las cosas, dispositivos móviles y otros tipos de aplicaciones que son nuevas y pueden aprovechar lo que MongoDB tiene para ofrecer.

En MongoDB, los documentos se pueden utilizar para almacenar datos no estructurados y facilitar su actualización y recuperación.
Su base de datos está creciendo, pero su esquema no es estable. En MySQL, una tabla puede degradarse si supera los 10 GB, MongoDB no tiene este problema.

Debida a la naturaleza del problema voy a elegir MongoDB por dos razones: análisis en tiempo real y escalabilidad.

Con respecto al servidor, Spring Boot tiene contenedores de servlets integrados. Spring Boot permite a los desarrolladores crear fácilmente aplicaciones o servicios utilizando los 3 contenedores más maduros disponibles: Tomcat (predeterminado), Undertow y Jetty.

Como indica este [estudio](https://www.baeldung.com/spring-boot-servlet-containers) hecho recientemente, sugiere que aunque Undertow necesite de un poco más de memoria, es mejor en prestaciones con respecto a los otros dos. Por tanto se va a elegir Undertow como servlet integrado.