---
layout: default
title: Tecnologias
nav_order: 7
---

# Uso de tecnologías
{: .d-inline-block }
Nuevo
{: .label .label-purple }

Se ha decidido utilizar las siguientes tecnologías en el proyecto:

  * **Maven** como gestor de tareas y dependencias, se ha optado por esta tecnología debido a que Maven usa un enfoque más declarativo y no un enfoque basado en tareas como **Ant** o **Makefile**. Permite ahorrar tiempo y hacer cumplir estándares en scripts de compilación. El proyecto se subdivide en otros proyectos con sus respectivos **pom.xml** (archivos de configuración de Maven) con sus diferentes ciclos de vida y aquí es donde entra el uso de **Makefile**, para automatizar y permitir el uso de tareas de Maven de cada uno de los proyectos. Se ha utilizado **Makefile** frente a **Ant** por su mejor legibilidad de gestor de tareas, el formato xml es más farragoso de leer y la compatibilidad en la amplia mayoría de los sistemas.
  
  * **JUnit** como biblioteca de aserciones, debido a su amplio uso por organizaciones en proyectos con el lenguaje **Java**. Ya ha marcado tendencia y es un estándar en los proyectos de este lenguaje de programación, llegando a hacer bastante eficiente el proceso de las pruebas. Por último, destacar su funcionalidad de poder crear "suites tests" para hacer más exhaustiva y completa la búsqueda de errores.
  
  * **Spring Test** como marco de pruebas. Se va a usar esta herramienta porque al utilizar el marco de trabajo Spring Boot, el marco de pruebas contendrá todos los elementos necesarios para probar los proyectos realizados bajo el marco de trabajo. Pruebas Unitarias, Objetos "mock" y pruebas de Integración, unido a la gran capacidad de adaptación a otras bibliotecas, como a la de aserciones **JUnit** entre otras.
    
