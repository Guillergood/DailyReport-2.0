---
layout: default
title: Planificacion
nav_order: 6
---

# Planificación y descripción
{: .d-inline-block }

Cambiado {: .label .label-blue }

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

  [*Animal*](https://github.com/Guillergood/DailyReport-2.0/blob/main/Animal/Animal.java)
  
  [*AnimalApplication*](https://github.com/Guillergood/DailyReport-2.0/blob/main/Animal/AnimalApplication.java)
  
  [*AnimalController*](https://github.com/Guillergood/DailyReport-2.0/blob/main/Animal/AnimalController.java)
  
  [*AnimalRepository*](https://github.com/Guillergood/DailyReport-2.0/blob/main/Animal/AnimalRepository.java)
  
  [*Report*](https://github.com/Guillergood/DailyReport-2.0/blob/main/Burocratico/Report.java)
  
  [*BurocraticoApplication*](https://github.com/Guillergood/DailyReport-2.0/blob/main/Burocratico/BurocraticoApplication.java)
  
  [*BurocraticoController*](https://github.com/Guillergood/DailyReport-2.0/blob/main/Burocratico/BurocraticoController.java)
  
  [*ReportRepository*](https://github.com/Guillergood/DailyReport-2.0/blob/main/Burocratico/ReportRepository.java)
  
  [*Cuidador*](https://github.com/Guillergood/DailyReport-2.0/blob/main/Cuidador/Cuidador.java)
  
  [*CuidadorApplication*](https://github.com/Guillergood/DailyReport-2.0/blob/main/Cuidador/CuidadorApplication.java)
  
  [*CuidadorController*](https://github.com/Guillergood/DailyReport-2.0/blob/main/Cuidador/CuidadorController.java)
  
  [*CuidadorRepository*](https://github.com/Guillergood/DailyReport-2.0/blob/main/Cuidador/CuidadorRepository.java)
  
  [*ApiApplication*](https://github.com/Guillergood/DailyReport-2.0/blob/main/API/ApiApplication.java)