package com.gbv.dailyreport.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

//Clase que controlara las llamadas REST de "Animal"
@RestController
public class AnimalController {
    //Se dice a la aplicacion el repositorio mongo es el siguiente y que lo autoconfigure
    @Qualifier("animalRepository")
    @Autowired
    private AnimalRepository repository;

    //Llamada GET que devuelve un animal
    @GetMapping(value = "/dailyreport/animal/{id}")
    public String getAnimal(@PathVariable(value = "id") final int id) {
        Animal animal = repository.findAnimalById(id);
        return animal != null ? animal.toString():"Not found!";
    }


    //Llamada POST que guarda un "Animal"
    @PostMapping(path= "/dailyreport/animal", consumes = "application/json", produces = "application/json")
    public void postAnimal(@RequestBody final Animal animal) {
        repository.save(animal);
    }

    //Llamada DELETE que elimina un "Animal"
    @DeleteMapping(value= "/dailyreport/animal/{id}")
    public void deleteAnimal(@PathVariable(value= "id") final int id){
        repository.deleteAnimalById(id);
    }


}

