---
layout: default
title: Alternativas
nav_order: 12
---

# Alternativas
{: .d-inline-block }
Nuevo
{: .label .label-purple }

## Alternativas a Docker Hub

Se ha añadido esta sección para comentar que debido a los [límites establecidos por Docker Hub en la descarga de contenedores](https://www.docker.com/blog/checking-your-current-docker-pull-rate-limits-and-status/) , se han buscado alternativas a este servicio:

- DigitalOcean Container Registry: Se ha descartado directamente puesto que sus condiciones son: un único repositorio y 500MB de almacenamiento, en el plan gratuito. Debido a que en el proyecto hay 4 contenedores que pesan más de 125MB cada uno, no se cumpliría con las restricciones. Además sólo dejan 500MB de tráfico de salida al mes, otra restricción más que no permitiría que fuese viable.
- Github Container Registry: La única limitación es que no sea un repositorio privado. La pega es que está en beta y podrían producirse fallos.

 Debido a los cambios hechos con Github Actions, lo único que habría que hacer es añadir el siguiente elemento en `jobs` en el archivo de Github Actions:

```yaml
login:
    runs-on: ubuntu-latest
    steps:
      -
        name: Checkout
        uses: actions/checkout@v2
      -
        name: Login to GitHub Package Registry
        uses: docker/login-action@v1
        with:
          registry: ghcr.io
          username: ${{ github.repository_owner }}
          password: ${{ secrets.GHCR_TOKEN }}
```

Siendo `secrets.GHCR_TOKEN` un token de acceso personal de Github que se pondría en el apartado secretos del que se ha hablado en este apartado.