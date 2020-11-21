package com.gbv.dailyreport.animal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//Se dice al sistema que la aplicacion utiliza repositorios MongoDB
@EnableMongoRepositories
//Se dice al sistema que este archivo es el que se utiliza para iniciar la aplicacion
@SpringBootApplication
public class AnimalApplication extends SpringBootServletInitializer {
    //Metodo de la aplicacion
    public static void main(String[] args) {
        SpringApplication.run(AnimalApplication.class, args);
    }
}
