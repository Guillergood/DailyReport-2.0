---
layout: default
title: Configuración de herramientas CI
nav_order: 14

---

# Configuración de herramientas CI

{: .d-inline-block }
Nuevo
{: .label .label-purple }


---

### TravisCI

[![Build Status](https://travis-ci.com/Guillergood/DailyReport-2.0.svg?branch=main)](https://travis-ci.org/Guillergood/DailyReport-2.0)

Hay que darse de alta en la plataforma. En mi caso como lo tenía configurado por los ejercicios del tema 4.

![](https://raw.githubusercontent.com/Guillergood/Ejercicios_20-21_CC/main/Ejercicios%20Tema%202/20.png)

### Configuración .travis.yml

En la configuración de Travis CI, está activada la automatización y cada vez que se sube código con un push ejecuta su flujo de trabajo para construir el proyecto y ejecutar los tests.

Se puede ver el fichero .travis.yml [aquí](https://github.com/Guillergood/DailyReport-2.0/blob/main/.travis.yml). 

```yaml
language: java
# Para instalar openjdk11 sin problemas (https://travis-ci.community/t/install-of-openjdk11-is-failing-again/3061/16)
dist: xenial
jdk:
  - openjdk11
  
script:
  # Script para que ejecute los test con la regla por defecto
  # Con mvn clean package ejecuta todos los tests y el coverage
  - mvn verify

notifications:
  email:
    recipients:
      - guillergood@gmail.com
    on_success: never # default: change
    on_failure: always # default: always

after_success:
  # report coverage to codecov.io
  - bash <(curl https://codecov.io/bash)
```

De esta manera, código ejecuta desde este archivo la tarea `mvn verify`, la cual llama a la orden `test` y genera la cobertura del código. Si los test tienen éxito, el infome se sube a codecov para poder ver cuánto código se ha cubierto. Por último, se han activado notificaciones para que si falla se mande un correo a mi cuenta de correo y enterarme mejor. 

### CircleCI

[![CircleCI](https://circleci.com/gh/Guillergood/DailyReport-2.0.svg?style=svg)](https://app.circleci.com/pipelines/github/Guillergood/DailyReport-2.0)

Igual que TravisCi, hay que darse de alta en la plataforma.

Una vez dado de alta, se elige un repositorio, el mismo que este proyecto.

![](https://raw.githubusercontent.com/Guillergood/DailyReport-2.0/gh-pages/image/7.png)

Se da permisos en la cuenta de Github, para permitirle ejecutar la construcción necesaria.

![](https://raw.githubusercontent.com/Guillergood/DailyReport-2.0/gh-pages/image/8.png)



Por último, el tutorial dice que se necesita un archivo config.yml dentro de .circleci

### Configuración config.yml

Se puede ver el fichero config.yml [aquí](https://github.com/Guillergood/DailyReport-2.0/blob/main/.circleci/config.yml). 

```yaml
version: 2.1
jobs:
    test:
        docker: #Descarga de Docker la imagen del contenedor creado
            - image: guillergood/dailyreport-2.0:latest
        steps:
            - checkout
            # Ejecuta la orden verify de maven
            - run: mvn verify

workflows:
    test_dailyreport:
        jobs:
            - test
```

Como se hace en TravisCI, se ejecuta `mvn verify`, pero reutilizando el contenedor creado posteriormente, y al activar los `triggers` de Docker, cuando haya un cambio en el Dockerfile y la imagen se actualice, siempre tendrá la última versión.