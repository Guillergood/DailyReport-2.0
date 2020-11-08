---
layout: default
title: Arquitectura
nav_order: 5
---

# Arquitectura
{: .d-inline-block }
Cambiado
{: .label .label-blue }

La arquitectura en la que se apoya el proyecto es una basada en **microservicios**. Se ha elegido este tipo de arquitectura debido al funcionamiento del trabajo de un zoológico, en el que este tipo de arquitectura funcionaría muy bien. Hay un buen número de tareas que podrían ser automatizadas, dónde la mayoría de las veces las transacciones que se hacen son datos mínimos o de poco tamaño. Además, permitiría una futura integración de nuevas funcionalidades sin mucho esfuerzo. La rapidez de una arquitectura de este tipo es rápida puesto que, los módulos que la contienen suelen tener un pequeño tamaño, aunque por otra parte se necesitaría más recursos. Una última ventaja de esta arquitectura sería el mantenimiento, permitiría mantenerse simple y barato ya que los cambios serían con respecto a módulos, no al sistema entero.


Para definir este programa y ayudar al zoológico se ha definido las siguientes entidades:

1. **Informe (entidad principal)**
2. Animal
3. Agente Burocrático
4. Cuidador

La funcionalidad del proyecto se asemejaría a la vida real. Dónde un "Cuidador" reporta sobre un "Animal" a un "Agente Burocrático". El "Agente Burocrático" se encarga de realizar un informe diario con los demás aportes de los otros "Cuidadores". Por último, el "Agente Burocrático" se encarga de enviar a las partes interesadas el informe final.
Este proceso se está llevando a cabo actualmente en algunos zoológicos, apenas usando algunos dispositivos informáticos para algunas tareas.

