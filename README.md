# DailyReport-2.0

[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0) [![Language](https://img.shields.io/badge/Language-Java-fd6a02.svg)](https://www.java.com/) [![Framework](https://img.shields.io/badge/Framework-Spring-brightgreen.svg)](https://spring.io/) [![Build Status](https://travis-ci.com/Guillergood/DailyReport-2.0.svg?branch=main)](https://travis-ci.com/Guillergood/DailyReport-2.0)

DailyReport-2.0 surge de la necesidad de actualizar un proyecto de voluntariado que realizé para el zoo de Dublín en 2019, *DailyReport* (actualmente se está trabajando para poder ponerlo en un repositorio público).

Este proyecto ayuda a los trabajadores del zoo debido a que es necesario que guarden una serie de informes del estado animal diarios, recogidos en la sección 9 de la ley irlandesa [ISMZP](https://www.npws.ie/sites/default/files/publications/pdf/ISMZP%202016.pdf) del año 2016 y que a su vez está recogida en la sección 2.6 de la [Directiva Europea de Buenas Prácticas de zoológicos](https://ec.europa.eu/environment/nature/pdf/EU_Zoos_Directive_Good_Practices.pdf). 

Anteriormente, el zoo generaba un gasto importante de recursos para generar informes diarios. Con esta herramienta se puede informar directamente con cualquier dispositivo (móvil, tablet, ordenador)  y ser recopilados en el servidor del zoológico para posteriormente, generar un documento con todas las anotaciones.

Los objetivos principales de esta herramienta son:
+ Agilizar la generación del informe.
+ Ahorrar en costes y tiempo.
+ Permitir la toma de decisiones basadas en la información generada por los informes diarios.

Para desarrollar el proyecto se quiere utilizar *Spring*.

Para ver la arquitectura, accede a la página del [proyecto](https://guillergood.github.io/DailyReport-2.0/docs/Arquitectura.html).

Las tecnologías a usar son:
Para la creación de microservicios se usará Java y el framework Spring Boot y Spring Cloud.

Se ha elegido Java por mi conocimiento sobre él y la cantidad de tiempo dedicado en utilizarlo. Además de ser usado por un comunidad muy grande, el framework Spring Boot y Cloud estás desarrollado en este lenguaje. Estos dos últimos se han escogido para desarrollar el proyecto porque permite facilitar el desarrollo completo (Test Unitarios, integración, manejo de mensajes...).

Para las bases de datos se utilizará MongoDB. La razón de esto es por la posible escalabilidad en el futuro de la aplicación, además de permitir el desarrollo más rápido.


# Historias de usuario:

Las historias de usuario que describen este proyecto se muestran a continuación:

[Como Cuidador quiero poder generar el informe final con todos los reportes de los demás cuidadores para tener el informe diario requerido por la ley.](https://github.com/Guillergood/DailyReport-2.0/issues/11)

[Como Cuidador quiero poder administrar la colección de animales para añadir, eliminar y editar animales.](https://github.com/Guillergood/DailyReport-2.0/issues/12)

[Como Cuidador quiero poder listar los animales ya comprobados para saber cuál de ellos tengo que revisar.](https://github.com/Guillergood/DailyReport-2.0/issues/13)

[Como Cuidador, necesito poder hacer reportes de otros días para poder cubrir días donde el sistema ha fallado.](https://github.com/Guillergood/DailyReport-2.0/issues/17)

[Como Cuidador del zoológico me gustaría reportar sobre los animales para poder añadir información al informe final.](https://github.com/Guillergood/DailyReport-2.0/issues/10)

[Como administrador del zoológico quiero poder tener en el correo el informe generado para saber que se ha generado el reporte final y sea más cómodo leer.](https://github.com/Guillergood/DailyReport-2.0/issues/15)

# **Entidades:**

Las entidades que se van a utilizar en este proyecto son:

- Cuidador
  
- Animal
  
- Agente Burocrático
  
- API

# **Planificación del proyecto:**

El proyecto se va a dividir en los siguientes objetivos:

**[Cuidador](https://github.com/Guillergood/DailyReport-2.0/milestone/5):**

Como Cuidador del zoólogico me gustaría reportar sobre los animales para poder añadir información al informe final.

**[Animales](https://github.com/Guillergood/DailyReport-2.0/milestone/6):**

Como Cuidador quiero poder administrar la colección de animales para añadir, eliminar y editar animales.
Como Cuidador quiero poder listar los animales ya comprobados para saber cuál de ellos tengo que revisar.

**[Agente Burocrático](https://github.com/Guillergood/DailyReport-2.0/milestone/6):**

Como Cuidador quiero poder generar el informe final con todos los reportes de los demás cuidadores para tener el informe diario requerido por la ley.
Como Cuidador, necesito poder hacer reportes de otros días para poder cubrir días donde el sistema ha fallado.
Como administrador del zoológico quiero poder tener en el correo el informe generado para saber que se ha generado el reporte final y sea más cómodo leer.

**[Test:](https://github.com/Guillergood/DailyReport-2.0/milestone/8)**

Hacer test de la Entidad Cuidador

Hacer test de la Entidad Animal

Hacer test de la Entidad Agente Burocrático

Hacer un test "suite"

**[Despliegue en la nube:](https://github.com/Guillergood/DailyReport-2.0/milestone/9)**

Investigar cómo poder subir proyectos a Google Cloud

Investigar cómo desplegar el proyecto en Alibaba

[**Investigación de posibles mejoras:**](https://github.com/Guillergood/DailyReport-2.0/milestone/10)

Investigar sobre Spring Cloud

# **Clases:**
Se ha creado el esqueleto del modelo [*Cuidador*](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/main/java/com/gbv/dailyreport/model/Cuidador.java).
El cual pasa el test en [TravisCI](https://travis-ci.org/github/Guillergood/DailyReport-2.0/builds/740404090)