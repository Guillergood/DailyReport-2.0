package com.gbv.dailyreport.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gbv.dailyreport.model.Animal;
import com.gbv.dailyreport.service.impl.AnimalServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {

    private final AnimalServiceImpl animalService;

    public AnimalController(AnimalServiceImpl animalService) {
        this.animalService = animalService;
    }
    @RequestMapping("/dailyreport/animal")
    public List<Animal> findAll() {
        return animalService.getAll();
    }

    //Llamada GET que devuelve un animal
    @GetMapping(value = "/dailyreport/animal/{id}")
    public ResponseEntity<?> getAnimal(@PathVariable(value = "id") final int id) throws JsonProcessingException {
        Animal animal;
        try {
            animal = animalService.get(id);
        }
        catch (IndexOutOfBoundsException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("Not found");
        }

        return ResponseEntity.ok(animal.serialize());
    }


    //Llamada POST que guarda un "Animal"
    @PostMapping(path= "/dailyreport/animal", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> postAnimal(@RequestBody final Animal animal) {
        animalService.add(animal);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body("Added successfully");
    }

    @PutMapping(value = "/dailyreport/animal/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> update(@PathVariable("id") final int id, @RequestBody final Animal sourceAnimal) throws JsonProcessingException {
        Animal targetAnimal;
        try{
            targetAnimal = animalService.get(id);
            animalService.edit(id,sourceAnimal);
            return new ResponseEntity<>(targetAnimal.serialize(), HttpStatus.OK);
        }
        catch (IndexOutOfBoundsException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("There is not an object like that to update");
        }


    }

    //Llamada DELETE que elimina un "Animal"
    @DeleteMapping(value= "/dailyreport/animal/{id}")
    public ResponseEntity<?> deleteAnimal(@PathVariable(value= "id") final int id){

        try{
            animalService.delete(animalService.get(id));
            return ResponseEntity.ok("Removed successfully");
        }
        catch (IndexOutOfBoundsException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("There is not an object like that to delete");
        }
    }


}
