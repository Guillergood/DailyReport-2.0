---
layout: default
title: Estudio Herramientas de Integración Continua
nav_order: 13

---

# Estudio Herramientas de Integración Continua

{: .d-inline-block }
Nuevo
{: .label .label-purple }


---

### Estudio

Para escoger las mejores opciones se han estudiado las siguientes herramientas de integración continua:

* [Jenkins](https://www.jenkins.io/): Jenkins es un servidor de automatización open source desarrollado en Java. Es uno de los más populares y usados.


* [CircleCI](https://circleci.com/): Es una plataforma de integración continua y despliegue continuo. CircleCI fue nombrado líder en integración continua nativa de la nube por Forrester en 2019 y ha sido incluido en varias listas de Mejores herramientas de DevOps. CircleCI es la primera herramienta CI / CD en obtener la certificación FedRAMP y procesa más de 30 millones de compilaciones cada mes en entornos de compilación Linux, macOS, Docker y Windows.

### Comparativa

En Jenkins, la compilación se alimenta a través de la interfaz de usuario de Jenkins, por lo que todas las configuraciones de tareas se mantienen en los archivos del sistema de Jenkins, principalmente en la base de datos de Jenkins, lo que dificulta el intercambio de información de configuración con el equipo o la organización. Github o dichos servidores de origen no pueden acceder a los datos contenidos en Jenkins.

En CircleCI, los desarrolladores pueden crear todas las tareas en un solo documento llamado "circle.yaml". Es simple porque la configuración de CI sería como todos los demás repositorios de origen que facilitan la copia de seguridad y el intercambio. Solo una cantidad limitada de configuraciones, como información confidencial, se puede almacenar de forma encriptada.

Con la simplicidad y facilidad de uso, CircleCI es el claro ganador y es el que voy a utilizar.
