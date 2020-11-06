package com.gbv.dailyreport.cuidador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//Se dice al sistema que la aplicacion utiliza repositorios MongoDB
@EnableMongoRepositories
//Se dice al sistema que este archivo es el que se utiliza para iniciar la aplicacion
@SpringBootApplication
public class CuidadorApplication extends SpringBootServletInitializer {
    //Metodo de la aplicacion
    public static void main(String[] args) {
        SpringApplication.run(CuidadorApplication.class, args);
    }



}
