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

Se está desarrollando el proyecto bajo la metodología Desarrollo guiado por comportamiento ([BDD](https://www.ibm.com/garage/method/practices/code/practice_behavior_driven_development/)), lo que permitirá que el proyecto evolucione correctamente con el comportamiento deseado.

Se ha desarrollado acorde a la [planificación](https://guillergood.github.io/DailyReport-2.0/docs/Planificacion.html), dónde se han acordado varios pasos para conseguir un "M.V.P" (Producto Mínimo Viable). 

Para conseguir esta meta se han desarrollado los módulos que no tenían dependencia de otros, para luego completar el sistema con los dependientes:

#### **Animal** (no tiene dependencia)

* [AnimalApplicationTests](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Animal/src/test/java/com/gbv/dailyreport/animal/AnimalApplicationTests.java) , donde se recogen todos los test en diferentes métodos.

  Una vez diseñadas las pruebas, se pasó a implementar los distintos módulos:

   * [Animal](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Animal/src/main/java/com/gbv/dailyreport/animal/Animal.java) , donde se encapsulan los datos de animales.
    
   * [AnimalRepository](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Animal/src/main/java/com/gbv/dailyreport/animal/AnimalRepository.java) , interfaz donde se recogen los métodos a usar por el contenedor Animal, o comúnmente llamado lógica de negocio.
   * [AnimalController](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Animal/src/main/java/com/gbv/dailyreport/animal/AnimalController.java) , controlador de la aplicación, el cuál gestiona las peticiones HTTP.
   * [AnimalApplication](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Animal/src/main/java/com/gbv/dailyreport/animal/AnimalApplication.java) , clase principal donde se ejecuta el servicio.

Este desarrollo corresponde con las siguientes historias de usuario:
*	[Crear microservicio](https://github.com/Guillergood/DailyReport-2.0/issues/47), cuyos test están contenidos en [AnimalApplicationTests](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Animal/src/test/java/com/gbv/dailyreport/animal/AnimalApplicationTests.java)

*	[Crear entidad (Animal)](https://github.com/Guillergood/DailyReport-2.0/issues/50)

*	[Crear](https://github.com/Guillergood/DailyReport-2.0/issues/53), cuya funcionalidad está comprobada en el método [addAnimal()](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Animal/src/test/java/com/gbv/dailyreport/animal/AnimalApplicationTests.java#L56)

*	[Consultar](https://github.com/Guillergood/DailyReport-2.0/issues/62), cuya funcionalidad está comprobada en el método [getAnimal()](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Animal/src/test/java/com/gbv/dailyreport/animal/AnimalApplicationTests.java#L72)

* [Eliminar](https://github.com/Guillergood/DailyReport-2.0/issues/59), cuya funcionalidad está comprobada en el método [deleteAnimal()](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Animal/src/test/java/com/gbv/dailyreport/animal/AnimalApplicationTests.java#L85)

  

#### **Cuidador** (no tiene dependencia)

* [CuidadorApplicationTests](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Cuidador/src/test/java/com/gbv/dailyreport/cuidador/CuidadorApplicationTests.java) , donde se recogen todos los test en diferentes métodos.

  Una vez diseñadas las pruebas, se pasó a implementar los distintos módulos:
  * [Cuidador](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Cuidador/src/main/java/com/gbv/dailyreport/cuidador/Cuidador.java) , donde se encapsulan los datos de los cuidadores.
   * [CuidadorRepository](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Cuidador/src/main/java/com/gbv/dailyreport/cuidador/CuidadorRepository.java) , interfaz donde se recogen los métodos a usar por el contenedor Cuidador, o comúnmente llamado lógica de negocio.
   * [CuidadorController](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Cuidador/src/main/java/com/gbv/dailyreport/cuidador/CuidadorController.java) , controlador de la aplicación, el cuál gestiona las peticiones HTTP.
   * [CuidadorApplication](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Cuidador/src/main/java/com/gbv/dailyreport/cuidador/CuidadorApplication.java) , clase principal donde se ejecuta el servicio.

Este desarrollo corresponde con las siguientes historias de usuario:
*	[Crear microservicio](https://github.com/Guillergood/DailyReport-2.0/issues/49), cuyos test están contenidos en [CuidadorApplicationTests](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Cuidador/src/test/java/com/gbv/dailyreport/cuidador/CuidadorApplicationTests.java) 

*	[Crear entidad (Cuidador)](https://github.com/Guillergood/DailyReport-2.0/issues/52)

*	[Crear](https://github.com/Guillergood/DailyReport-2.0/issues/55), cuya funcionalidad está comprobada en el método [addCuidador()](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Cuidador/src/test/java/com/gbv/dailyreport/cuidador/CuidadorApplicationTests.java#L53)

* [Consultar](https://github.com/Guillergood/DailyReport-2.0/issues/64), cuya funcionalidad está comprobada en el método [getCuidador()](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Cuidador/src/test/java/com/gbv/dailyreport/cuidador/CuidadorApplicationTests.java#L69)

  

#### **Informe** (tiene dependencia con **Cuidador** y **Animal**)

* [BurocraticoApplicationTests](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Burocratico/src/test/java/com/gbv/dailyreport/burocratico/BurocraticoApplicationTests.java) , donde se recogen todos los test en diferentes métodos.

  Una vez diseñadas las pruebas, se pasó a implementar los distintos módulos:
  * [Report](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Burocratico/src/main/java/com/gbv/dailyreport/burocratico/Report.java) , donde se encapsulan los datos de los Informes.
  * [ReportRepository](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Burocratico/src/main/java/com/gbv/dailyreport/burocratico/ReportRepository.java) , interfaz donde se recogen los métodos a usar por el contenedor Informe, o comúnmente llamado lógica de negocio.
  * [BurocraticoController](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Burocratico/src/main/java/com/gbv/dailyreport/burocratico/BurocraticoController.java) , controlador de la aplicación, el cuál gestiona las peticiones HTTP.
  * [BurocraticoApplication](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Burocratico/src/main/java/com/gbv/dailyreport/burocratico/BurocraticoApplication.java) , clase principal donde se ejecuta el servicio.

Este desarrollo corresponde con las siguientes historias de usuario:
*	[Crear microservicio](https://github.com/Guillergood/DailyReport-2.0/issues/48), cuyos test están contenidos en [BurocraticoApplicationTests](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Burocratico/src/test/java/com/gbv/dailyreport/burocratico/BurocraticoApplicationTests.java)

*	[Crear entidad (Informe)](https://github.com/Guillergood/DailyReport-2.0/issues/51)

*	[Crear](https://github.com/Guillergood/DailyReport-2.0/issues/54), cuya funcionalidad está comprobada en el método [addReport()](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Burocratico/src/test/java/com/gbv/dailyreport/burocratico/BurocraticoApplicationTests.java#L53)

*	[Consultar](https://github.com/Guillergood/DailyReport-2.0/issues/63), cuya funcionalidad está comprobada en el método [getReport()](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Burocratico/src/test/java/com/gbv/dailyreport/burocratico/BurocraticoApplicationTests.java#L69)

*	[Eliminar](https://github.com/Guillergood/DailyReport-2.0/issues/60), cuya funcionalidad está comprobada en el método [deleteReport()](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Burocratico/src/test/java/com/gbv/dailyreport/burocratico/BurocraticoApplicationTests.java#L81)
