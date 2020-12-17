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
