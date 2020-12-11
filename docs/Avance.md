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

Se ha avanzado en los siguientes puntos:

[Mejorar el Dockerfile del proyecto](https://github.com/Guillergood/DailyReport-2.0/issues/74), en el que se ha borrado la copia del `pom.xml`

[Eliminar make del proyecto](https://github.com/Guillergood/DailyReport-2.0/issues/73), en el que se ha borrado la copia del `Makefile`

[Refactorizar el código para que corresponda a las buenas prácticas de Java](https://github.com/Guillergood/DailyReport-2.0/issues/72):

Donde se han cambiado la estructura del proyecto y ahora,dentro de la carpeta `src` contiene:

- Una carpeta `main` y dentro el conjunto de carpetas del artefacto `java/com/gbv/dailyreport`, dentro de este está:
  - El archivo principal de la aplicación *[DailyreportApplication.java](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/main/java/com/gbv/dailyreport/DailyreportApplication.java)*
  - La carpeta de *[controllers](https://github.com/Guillergood/DailyReport-2.0/tree/main/src/main/java/com/gbv/dailyreport/controllers)*, con los correspondientes controladores de cada uno de las entidades.
  - La carpeta de *[models](https://github.com/Guillergood/DailyReport-2.0/tree/main/src/main/java/com/gbv/dailyreport/models)*, con las correspondientes entidades.



- Una carpeta `test` y dentro el conjunto de carpetas del artefacto `java/com/gbv/dailyreport`, dentro de este está:

  - El archivo principal test de la aplicación *[DailyreportApplicationTest.java](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/test/java/com/gbv/dailyreport/DailyreportApplicationTest.java)*
  - El archivo test de la entidad Animal *[AnimalControllerTest.java](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/test/java/com/gbv/dailyreport/DailyreportApplicationTest.java)*
  - El archivo test de la entidad Cuidador *[CuidadorControllerTest.java](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/test/java/com/gbv/dailyreport/DailyreportApplicationTest.java)*
  - El archivo test de la entidad Report *[ReportControllerTest.java](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/test/java/com/gbv/dailyreport/DailyreportApplicationTest.java)*


[Agregar "Codecov" al proyecto](https://github.com/Guillergood/DailyReport-2.0/issues/41): Donde se han agregado los reportes de los tests de los anteriores proyectos con una cobertura del 100%.

[[HU23] Editar Cuidador](https://github.com/Guillergood/DailyReport-2.0/issues/58) : La posibilidad de editar Cuidadores con el verbo HTTP PUT.

[[HU17] Editar Informes](https://github.com/Guillergood/DailyReport-2.0/issues/57)  : La posibilidad de editar Informes con el verbo HTTP PUT.

[[HU11] Editar Animales ](https://github.com/Guillergood/DailyReport-2.0/issues/56)  : La posibilidad de editar Animales con el verbo HTTP PUT.