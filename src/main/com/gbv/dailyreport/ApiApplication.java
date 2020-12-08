package com.gbv.dailyreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Se dice al sistema que este archivo es el que se utiliza para iniciar la aplicacion
@SpringBootApplication
public class ApiApplication {
	//Metodo de la aplicacion
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
