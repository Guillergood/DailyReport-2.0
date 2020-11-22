---
layout: default
title: Contenedores remotos
nav_order: 11
---

# Contenedores remotos
{: .d-inline-block }
Nuevo
{: .label .label-purple }

## Primeros pasos

Para tener un repositorio remoto se utilizará el sistema de `Docker Hub`, el cual permitirá gestionar las nuevas versiones cada vez que se dé una nueva subida de código al repositorio de `Github`.

Los requisitos para esto son:

- Tener una cuenta.
- Crear un repositorio.
- Tener un contenedor que subir.

En el proyecto de DailyReport-2.0 hay 4 contenedores a subir: `Animal`, `Cuidador`, `Burocratico`, `Api`.

Una vez construidos los contenedores, se marcan:

```bash
docker tag 6a3862129a24 guillergood/dailyreport-api:latest
docker tag 642490bc22dd guillergood/dailyreport-burocratico:latest
docker tag ed95ee3120e5 guillergood/dailyreport-cuidador:latest
docker tag c9cf4c6afef1 guillergood/dailyreport-animal:latest
```

Y se suben a los repositorios:

```
docker push guillergood/dailyreport-api &&
docker push guillergood/dailyreport-burocratico &&
docker push guillergood/dailyreport-cuidador &&
docker push guillergood/dailyreport-animal
```

## Automatización

Una vez subidos, en cada repositorio se tiene que configurar para que cada vez que se suba código, se genere una nueva versión. Puesto que son cuatro contenedores en el mismo proyecto, hay que definir el mismo proyecto y cada carpeta donde se contiene el archivo Dockerfile. Esta configuración está en la pestaña *Build*

![]()

Y una vez hecha esta configuración, ya funcionaría. 

![]()