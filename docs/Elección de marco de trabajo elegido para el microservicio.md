---
layout: default
title: Elección de marco de trabajo elegido para el microservicio
nav_order: 15

---

# Elección de marco de trabajo elegido para el microservicio

{: .d-inline-block }
Nuevo
{: .label .label-purple }


---
## Spring

Con su concepto de inyección de dependencia y características de programación orientadas a aspectos, Spring tomó el desarrollo mundo por sorpresa. Es un marco de trabajo de código abierto utilizado para aplicaciones empresariales.

Con Spring, los desarrolladores pueden crear módulos acoplados de forma flexible en los que el marco de trabajo controla las dependencias en lugar de depender de las bibliotecas del código.

El marco de trabajo de Spring cubre muchas características, incluida la seguridad y la configuración, que son fáciles de aprender. Además, dado que es el marco de trabajo web más popular, se puede encontrar una gran cantidad de documentación y una comunidad activa.

Con todo configurado, el código es limpio y fácil de comprender.

• Conceptos principales:

- Inyección de dependencia (DI) (Inversión de control): en este principio, en lugar de que la aplicación tome el control del flujo secuencialmente, da el control a un controlador externo que controla el flujo. El controlador externo son los eventos. Cuando se produce algún evento, el flujo de la aplicación continúa. Esto proporciona flexibilidad a la aplicación. Tiene tres tipos de inyecciones: inyección de establecedor, inyección de método e inyección de constructor.
- Beans y contexto: en Spring, los objetos se denominan Beans y hay un BeanFactory que administra y configura estos Beans. La mayoría de las aplicaciones utilizan xml (beans.xml) para la configuración. ApplicationContext que un superconjunto de BeanFactory se utiliza para aplicaciones más complejas que necesitan propagación de eventos, mecanismos declarativos e integración con características orientadas a aspectos de Spring.
- Tiene una extensa documentación y tutoriales en su página web oficial.
- Se puede crear aplicaciones rápidamente con su plugin en el IDE Intellij IDEA.

## Struts


Apache Struts es otro sólido marco de trabajo de código abierto para aplicaciones web. Sigue el modelo MVC (Model-View-Controller) y extiende la API JSP. En un enfoque tradicional servlet-JSP, si un usuario envía un formulario con sus detalles, la información va a un servlet para su procesamiento o el control pasa al siguiente JSP (Java Server Pages – donde puede escribir código Java en un HTML). Esto se vuelve confuso para aplicaciones complejas, ya que la capa 'View' o la capa de presentación no debería tener lógica de negocio.

Los struts separan la vista, el controlador y el modelo (datos) y proporcionan el enlace entre cada uno a través de un archivo de configuración struts-config.xml.

El controlador es un ActionServlet donde puede escribir plantillas para la vista y los datos de usuario se mantienen utilizando ActionForm JavaBean. El objeto Action es responsable de reenviar el flujo de aplicación.

La vista se mantiene mediante un amplio conjunto de bibliotecas de etiquetas.

Los struts son fáciles de configurar y proporcionan mucha más flexibilidad y extensibilidad sobre el enfoque MVC tradicional utilizando servlets y JSP solo. Puede ser un buen punto de partida para su carrera como desarrollador web.

## Hibernate


Aunque Hibernate no es un marco de trabajo completo. Implementa Java Persistence API (JPA). Hibernate es una base de datos de asignación relacional de objetos (ORM) para aplicaciones Java. Al igual que SQL, las consultas en Hibernate se denominan HQL (Lenguaje de consulta de Hibernate).

Hibernate asigna directamente las clases Java a las tablas de base de datos correspondientes y viceversa.

El archivo principal en hibernación es el archivo hibernado.cfg.xml que contiene información sobre la asignación de clases Java con la configuración de la base de datos.

Hibernate resuelve los dos principales problemas con JDBC: JDBC no admite relaciones a nivel de objeto y si alguna vez decide migrar a una base de datos diferente, las consultas más antiguas pueden no funcionar, lo que significa muchos cambios, ¡es decir, tiempo y dinero!

Hibernate proporciona una capa de abstracción para que el código se combine libremente con la base de datos. Cosas como establecer una conexión de base de datos, realizar operaciones CRUD son atendidos por Hibernate, por lo que los desarrolladores no necesitan implementar eso, por lo tanto, hace que el código sea independiente de la base de datos utilizada.

## Apache Wicket

Un simple marco de trabajo web, Wicket tiene una estructura orientada a componentes y todo lo que se necesita saber es Java y HTML.

La característica principal de Wicket es el modelo POJO en el que los componentes son simples (Plain Old) Java Objects que tienen características OOP. Estos componentes se agrupan como paquetes reutilizables con imágenes, botones, formularios, enlaces, páginas, contenedores, comportamientos y mucho más para que los desarrolladores puedan personalizarlos.

Wicket es ligero y puede crear aplicaciones muy rápido. También es sencillo crear pruebas unitarias bajo este marco de trabajo.

## JSF

Es un marco MVC basado en componentes y tiene componentes de interfaz de usuario reutilizables para aplicaciones basadas en servidor. La idea principal es encapsular varias tecnologías del lado cliente como CSS, JavaScript y HTML que permitirán a los desarrolladores crear la interfaz de usuario sin conocer ninguna de estas tecnologías en profundidad. Solo pueden arrastrar y soltar componentes de la interfaz de usuario y centrarse más en los detalles de la capa de presentación.

El sistema de plantillas predeterminado en JSF es FaceLets. JSF es bastante similar a Struts.

JSF se puede integrar sin problemas con componentes habilitados para AJAX para enriquecer la experiencia del usuario mediante la adición de eventos Ajax para validaciones e invocaciones de métodos.

## Dropwizard

Este marco de trabajo ligero permite completar una aplicación muy rápido debido a su compatibilidad inmediata con configuraciones avanzadas, registro, métricas de aplicaciones y mucho más. Puede crear aplicaciones web RESTful que ofrezcan un alto rendimiento, sean estables y fiables.

Dropwizard reúne una gran cantidad de bibliotecas como Jetty, Guava, Jersey, Jackson y Metrics entre muchas otras del ecosistema Java en un solo marco de trabajo y da la sensación de ser una aplicación ligera y robusta.

Dado que hay bibliotecas integradas para todas las configuraciones, tareas relacionadas con la seguridad y el rendimiento, parece que lo único que se necesita es saber la lógica de negocio a implementar.

Dropwizard es un marco de trabajo de código abierto que se incluye con bibliotecas y se puede configurar fácilmente con Eclipse IDE.

## Grails

Grails es un marco de trabajo web escrito en lenguaje de programación Groovy, se ejecuta en la plataforma Java y es perfectamente compatible con la sintaxis Java. Este marco de trabajo se basa en el patrón de diseño MVC.

Groovy es similar a Java que algunas características más añadidas en comparación con Java. Es muy fácil aprender Groovy si ya conoces Java.

Al igual que JSP, en Grails, la tecnología de renderizado es GSP (Groovy Server Pages). Crear etiquetas para la vista en Grails es simple y fácil.  Se puede integrar un código en Java existente con Grails.

## Atg

ATG es una plataforma de comercio web escrita en Java. Es un marco de trabajo personalizable y configurable, especialmente útil para sitios web relacionados con el comercio electrónico. El producto es propiedad de Oracle y es compatible con aplicaciones B2B y B2C que son complejas y enormes. Sin embargo, para aplicaciones a pequeña escala, podría ser demasiado costoso.


ATG es un marco extenso y necesita tiempo y paciencia para aprender de él.


## Elección
Después de repasar todas estas herramientas, he elegido [Spring](spring.io) para desarrollar la aplicación, por su simplicidad a la hora de gestionar el proyecto con el plugin del IDE que estoy usando y la cantidad de tutoriales y documentación disponible que tiene en su página web. Además de su amplio y continuo uso por parte de empresas de alto nivel en el sector tecnológico.
