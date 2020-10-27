# DailyReport-2.0

[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0) [![Language](https://img.shields.io/badge/Language-Java-fd6a02.svg)](https://www.java.com/) [![Framework](https://img.shields.io/badge/Framework-Spring-brightgreen.svg)](https://spring.io/) [![Build Status](https://travis-ci.com/Guillergood/DailyReport-2.0.svg?branch=main)](https://travis-ci.com/Guillergood/DailyReport-2.0)

DailyReport-2.0 surje de la necesidad de actualizar un proyecto de voluntariado que realizé para el zoo de Dublín en 2019, *DailyReport* (actualmente se está trabajando para poder ponerlo en un repositorio público).

Este proyecto ayuda a los trabajadores del zoo debido a que es necesario que guarden una serie de informes del estado animal diarios, recogidos en la sección 9 de la ley irlandesa [ISMZP](https://www.npws.ie/sites/default/files/publications/pdf/ISMZP%202016.pdf) del año 2016 y que a su vez está recogida en la sección 2.6 de la [Directiva Europea de Buenas Prácticas de zoológicos](https://ec.europa.eu/environment/nature/pdf/EU_Zoos_Directive_Good_Practices.pdf). 

Anteriormente, el zoo generaba un gasto importante de recursos para generar informes diarios. Con esta herramienta se puede informar directamente con cualquier dispositivo (móvil, tablet, ordenador)  y ser recopilados en el servidor del zoológico para posteriormente, generar un documento con todas las anotaciones.

Los objetivos principales de esta herramienta son:
+ Agilizar la generación del informe.
+ Ahorrar en costes y tiempo.
+ Permitir la toma de decisiones basadas en la información generada por las informes diarios.

Para desarrollar el proyecto se quiere utilizar *Spring*.

Para ver la arquitectura, accede a la página del [proyecto](https://guillergood.github.io/DailyReport-2.0/docs/Arquitectura.html).

Para ver el *roadmap*, accede al apartado [projects](https://github.com/Guillergood/DailyReport-2.0/projects/1) y a la [gráfica](https://guillergood.github.io/DailyReport-2.0/docs/Roadmap.html) de la página del repositorio.

Las tecnilogías a usar son:
Para la creación de microservicios se usará Java y el framework Spring Boot y Spring Cloud.

Se ha elegido Java por mi conocimiento sobre él y la cantidad de tiempo dedicado en utilizarlo. Además de ser usado por un comunidad muy grande, el framework Srping Boot y Cloud estás desarrollado en este lenguaje. Estos dos últimos se han escogido para desarrollar el proyecto porque permite facilitar el desarrollo completo (Test Unitarios, integración, manejo de mensajes...).

Para las bases de datos se utlizará MongoDB. La razón de esto es por la posible escalabidad en el futuro de la aplicación, además de permitir el desarrollo más rápido.

Para cola de eventos se usará RabbitMQ, debido a que permite solucionar el problema de eventos y al no tener una gran carga de datos, permitiría mandar mensajes entre los microservicios rápidamente.


=====================================================================================

Historias de Usuario
[HU1](https://github.com/Guillergood/DailyReport-2.0/issues/10)

[HU2](https://github.com/Guillergood/DailyReport-2.0/issues/11)

[HU3](https://github.com/Guillergood/DailyReport-2.0/issues/12)

[HU4](https://github.com/Guillergood/DailyReport-2.0/issues/13)

[HU5](https://github.com/Guillergood/DailyReport-2.0/issues/14)

[HU6](https://github.com/Guillergood/DailyReport-2.0/issues/15)
