---
layout: default
title: Descripcion
nav_order: 4
---

# Descripción
{: .d-inline-block }
Cambiado
{: .label .label-blue }

# **Historias de usuario:**

Las historias de usuario que describen este proyecto se muestran a continuación:

[[HU8] Crear microservicio Animal ](https://github.com/Guillergood/DailyReport-2.0/issues/47)

[[HU14] Crear microservicio Burocrático ](https://github.com/Guillergood/DailyReport-2.0/issues/48)

[[HU20] Crear microservicio Cuidador ](https://github.com/Guillergood/DailyReport-2.0/issues/49)

[[HU9] Crear entidad Animal ](https://github.com/Guillergood/DailyReport-2.0/issues/50)

[[HU15] Crear entidad Report (Informe) ](https://github.com/Guillergood/DailyReport-2.0/issues/51)

[[HU21] Crear la entidad Cuidador ](https://github.com/Guillergood/DailyReport-2.0/issues/52)

[[HU10] Crear Animal ](https://github.com/Guillergood/DailyReport-2.0/issues/53)

[[HU16] Crear informes. ](https://github.com/Guillergood/DailyReport-2.0/issues/54)

[[HU22] Crear Cuidadores ](https://github.com/Guillergood/DailyReport-2.0/issues/55)

[[HU13] Eliminar Animal ](https://github.com/Guillergood/DailyReport-2.0/issues/59)

[[HU19] Eliminar Informes ](https://github.com/Guillergood/DailyReport-2.0/issues/60)

[[HU12] Eliminar Cuidadores ](https://github.com/Guillergood/DailyReport-2.0/issues/61)

[[HU24] Consultar Animal ](https://github.com/Guillergood/DailyReport-2.0/issues/62)

[[HU18] Consultar Informe ](https://github.com/Guillergood/DailyReport-2.0/issues/63)

[[HU25] Consultar Cuidador ](https://github.com/Guillergood/DailyReport-2.0/issues/64)

[[HU11] Editar Animales](https://github.com/Guillergood/DailyReport-2.0/issues/56)

[[HU17] Editar Informes](https://github.com/Guillergood/DailyReport-2.0/issues/57)

[[HU23] Editar Cuidador](https://github.com/Guillergood/DailyReport-2.0/issues/58)

# **Entidades:**

Las entidades que se van a utilizar en este proyecto son:

- **Report (informe)** (entidad principal)
  
- Animal
  
- Cuidador

# **Planificación del proyecto:**

El proyecto se va a dividir en los siguientes milestones, centrados en la entidad principal **Report (informe)** y priorizados de la siguiente manera para que se desarrolle de forma incremental:

**[Administración animal](https://github.com/Guillergood/DailyReport-2.0/milestone/12)**
Como Cuidador quiero poder administrar la colección de animales para añadir, eliminar y editar animales.
Como Cuidador quiero poder listar los animales ya comprobados para saber cuál de ellos tengo que revisar.

**[Creación de informes](https://github.com/Guillergood/DailyReport-2.0/milestone/6):**
Como Cuidador del zoológico me gustaría reportar sobre los animales para poder añadir información al informe final.
Como Cuidador quiero poder generar el informe final con todos los reportes de los demás cuidadores para tener el informe diario requerido por la ley.

**[Administración de informes](https://github.com/Guillergood/DailyReport-2.0/milestone/7):**
Como Cuidador, necesito poder hacer reportes de otros días para poder cubrir días donde el sistema ha fallado.
Como administrador del zoológico quiero poder tener en el correo el informe generado para saber que se ha generado el reporte final y sea más cómodo leer.

**[Despliegue en la nube:](https://github.com/Guillergood/DailyReport-2.0/milestone/9)**
Investigar cómo poder subir proyectos a Google Cloud
Investigar cómo desplegar el proyecto en Alibaba

**[Investigación de posibles mejoras:](https://github.com/Guillergood/DailyReport-2.0/milestone/10)**
Investigar sobre Spring Cloud



# **Clases:**
Se ha creado el esqueleto de las siguientes clases:

  [*Animal*](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Animal/src/main/java/com/gbv/dailyreport/animal/Animal.java)
  
  [*AnimalApplication*](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Animal/src/main/java/com/gbv/dailyreport/animal/AnimalApplication.java)
  
  [*AnimalController*](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Animal/src/main/java/com/gbv/dailyreport/animal/AnimalController.java)
  
  [*AnimalRepository*](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Animal/src/main/java/com/gbv/dailyreport/animal/AnimalRepository.java)
  
  [*Report*](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Burocratico/src/main/java/com/gbv/dailyreport/burocratico/Report.java)
  
  [*BurocraticoApplication*](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Burocratico/src/main/java/com/gbv/dailyreport/burocratico/BurocraticoApplication.java)
  
  [*BurocraticoController*](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Burocratico/src/main/java/com/gbv/dailyreport/burocratico/BurocraticoController.java)
  
  [*ReportRepository*](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Burocratico/src/main/java/com/gbv/dailyreport/burocratico/ReportRepository.java)
  
  [*Cuidador*](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Cuidador/src/main/java/com/gbv/dailyreport/cuidador/Cuidador.java)
  
  [*CuidadorApplication*](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Cuidador/src/main/java/com/gbv/dailyreport/cuidador/CuidadorApplication.java)
  
  [*CuidadorController*](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Cuidador/src/main/java/com/gbv/dailyreport/cuidador/CuidadorController.java)
  
  [*CuidadorRepository*](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/Cuidador/src/main/java/com/gbv/dailyreport/cuidador/CuidadorRepository.java)
  
  [*ApiApplication*](https://github.com/Guillergood/DailyReport-2.0/blob/main/src/API/src/main/java/com/gbv/dailyreport/api/ApiApplication.java)
