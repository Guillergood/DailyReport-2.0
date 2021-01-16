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

[No se pueden meter datos en la definición de la clase.](https://github.com/Guillergood/DailyReport-2.0/issues/77)

Ahora cada controlador tiene sus datos introducidos en una clase aparte, como recomiendan en la documentación de Spring:

```java
package com.gbv.dailyreport;

import com.gbv.dailyreport.model.Cuidador;
import com.gbv.dailyreport.model.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.gbv.dailyreport.model.Animal;
import com.gbv.dailyreport.repositories.AnimalRepository;
import com.gbv.dailyreport.repositories.CuidadorRepository;
import com.gbv.dailyreport.repositories.ReportRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AnimalRepository animalRepository, ReportRepository reportRepository,
                                   CuidadorRepository cuidadorRepository) {

        return args -> {
            log.info("Preloading Animal 1 " + animalRepository.save(new Animal(1,"entity_1", false)));
            log.info("Preloading Animal 2 " + animalRepository.save(new Animal(2,"entity_2", false)));
            log.info("Preloading Animal 3 " + animalRepository.save(new Animal(3,"entity_3", false)));
            log.info("Preloading Animal 4 " + animalRepository.save(new Animal( 4,"entity_4", false)));

            log.info("Preloading Cuidador 1 " + cuidadorRepository.save(new Cuidador(1,"name_1")));
            log.info("Preloading Cuidador 2 " + cuidadorRepository.save(new Cuidador(2,"name_2")));
            log.info("Preloading Cuidador 3 " + cuidadorRepository.save(new Cuidador(3,"name_3")));
            log.info("Preloading Cuidador 4 " + cuidadorRepository.save(new Cuidador(4,"name_4")));

            log.info("Preloading Report 1 " + reportRepository.save(new Report(1,"name_1","animal_1","hello")));
            log.info("Preloading Report 2 " + reportRepository.save(new Report(2,"name_2","animal_2","hello")));
            log.info("Preloading Report 3 " + reportRepository.save(new Report(3,"name_3","animal_3","hello")));
            log.info("Preloading Report 4 " + reportRepository.save(new Report(4,"name_4","animal_4","hello")));
        };
    }
}
```



[La lógica de negocio debe estar desacoplada de su publicación en un API](https://github.com/Guillergood/DailyReport-2.0/issues/78) 

[La lógica de negocio básica debe estar separada de cualquier dependencia de un framework](https://github.com/Guillergood/DailyReport-2.0/issues/79) 

[Esta clase no tiene ningún código asociado](https://github.com/Guillergood/DailyReport-2.0/issues/80)


Se han cambiado los controladores para que tengan la implementación de la lógica de negocio (la cual está ligada al framework) y a través de ella hagan las transacciones necesarias. Sin embargo, la lógica de negocio esta desacoplada de su publicación en una API y de cualquier dependencia del framework

````java
package com.gbv.dailyreport.service.impl;

import com.gbv.dailyreport.model.Animal;
import com.gbv.dailyreport.repositories.AnimalRepository;
import com.gbv.dailyreport.services.AnimalService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }
   [...]
````
````java
package com.gbv.dailyreport.service.impl;

import com.gbv.dailyreport.model.Animal;
import com.gbv.dailyreport.repositories.AnimalRepository;
import com.gbv.dailyreport.services.AnimalService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }
   [...]
````
````java
package com.gbv.dailyreport.service.impl;

import com.gbv.dailyreport.model.Animal;
import com.gbv.dailyreport.repositories.AnimalRepository;
import com.gbv.dailyreport.services.AnimalService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }
   [...]
````
Y aquí la lógica de negocio sin ningún tipo de dependencia:

````java
package com.gbv.dailyreport.services;

import com.gbv.dailyreport.model.Animal;

import java.util.List;

public interface AnimalService {
    void add(Animal animal);
    void delete(Animal animal);
    void edit(int id, Animal animal);
    Animal get(int id);
    List<Animal> getAll();
}
````

````java
package com.gbv.dailyreport.services;

import com.gbv.dailyreport.model.Cuidador;

import java.util.List;

public interface CuidadorService {
    void add(Cuidador cuidador);
    void delete(Cuidador cuidador);
    void edit(int id, Cuidador cuidador);
    Cuidador get(int id);
    List<Cuidador> getAll();
}
````

````java
package com.gbv.dailyreport.services;

import com.gbv.dailyreport.model.Report;

import java.util.List;

public interface ReportService {
    void add(Report report);
    void delete(Report report);
    void edit(int id, Report report);
    Report get(int id);
    List<Report> getAll();
}
````



