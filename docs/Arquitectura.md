---
layout: default
title: Navigation Structure
nav_order: 5
---

# Arquitectura
{: .no_toc }

<details open markdown="block">
  <summary>
    Table of contents
  </summary>
  {: .text-delta }
1. TOC
{:toc}
</details>


Para definir este programa y ayudar al zoólogico se ha definido los siguientes microservicios:

1. Cuidador
2. Animal
3. Agente Burocrático
4. API

**Cuidador:** Esta entidad será usada para reportar sobre los animales. El formato del envío de la información será en JSON. El Agente Burocrático será el encargado de recibir los reportes. Toda esta información será almacenada en una base de datos.

**Animal:** Esta entidad será usada para:

   -		**Generar** **estados** diario del animal.
   -		**Informar** con anotaciones más extensas sobre su estado.

Este servicio tendrá una base de datos encargada de guardar el tipo de animal que es.

**Agente Burocrático:** El objetivo de este servicio es **recopilar información** de los informes de los **Cuidadores**. Posteriormente este servicio podrá generar un informe final en formato pdf.

**API:** Redigirá las peticiones REST a su entidad correspondiente.



Esta arquitectura es una arquitectura **dirigida por eventos**. Se ha elegido este tipo de arquitectura debido al funcionamiento del trabajo de un zoológico, en el que este tipo de arquitectura funcionaría muy bien.

- Los **Animales** generan "estados", que en este casos son **eventos**.
- Los **Cuidadores** se encargarían de comunicar y añadir información extra estos "estados". En este caso haría una especie de función de **Bróker de Mensajería**.
- El **Agente Burocrático** captaría esos "estados" para ser **consumidos**, y generar un informe con toda la información contada por los **Cuidadores**.

Para finalizar caso de uso sería:

Los **Animales** generan "estados".  Estos "estados" son informados por los **Cuidadores** que envían la información por el *ApiGateway*, además se marca al **Animal** como **comprobado**. Una vez enviado, el **Agente Burocrático** recoge esta petición para ir rellenando el informe.