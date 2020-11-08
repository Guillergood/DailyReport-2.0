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

[Como Cuidador quiero poder generar el informe final con todos los reportes de los demás cuidadores para tener el informe diario requerido por la ley.](https://github.com/Guillergood/DailyReport-2.0/issues/11)

[Como Cuidador quiero poder administrar la colección de animales para añadir, eliminar y editar animales.](https://github.com/Guillergood/DailyReport-2.0/issues/12)

[Como Cuidador quiero poder listar los animales ya comprobados para saber cuál de ellos tengo que revisar.](https://github.com/Guillergood/DailyReport-2.0/issues/13)

[Como Cuidador, necesito poder hacer reportes de otros días para poder cubrir días donde el sistema ha fallado.](https://github.com/Guillergood/DailyReport-2.0/issues/17)

[Como Cuidador del zoológico me gustaría reportar sobre los animales para poder añadir información al informe final.](https://github.com/Guillergood/DailyReport-2.0/issues/10)

[Como administrador del zoológico quiero poder tener en el correo el informe generado para saber que se ha generado el reporte final y sea más cómodo leer.](https://github.com/Guillergood/DailyReport-2.0/issues/15)

# **Entidades:**

Las entidades que se van a utilizar en este proyecto son:

- **Report (informe)** (entidad principal)
  
- Animal
  
- Agente Burocrático
  
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
