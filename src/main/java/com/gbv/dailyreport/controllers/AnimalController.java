package com.gbv.dailyreport.controllers;

import com.gbv.dailyreport.model.Animal;
import org.springframework.beans.BeanUtils;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class AnimalController {


    private final List<Animal> animals = new ArrayList<>();
    {
        animals.add(new Animal(1, "entity_1", false));
        animals.add(new Animal(2, "entity_2", false));
        animals.add(new Animal(3, "entity_3", false));
        animals.add(new Animal(4, "entity_4", false));
    }


    @RequestMapping("/dailyreport/animal/all")
    public List<Animal> findAll() {
        return animals;
    }

    //Llamada GET que devuelve un animal
    @GetMapping(value = "/dailyreport/animal/{id}")
    public ResponseEntity<?> getAnimal(@PathVariable(value = "id") final int id) {
        Animal animal;
        try {
            animal = animals.get(id);
        }
        catch (IndexOutOfBoundsException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("Not found");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<Animal> request = new HttpEntity<>(animal, headers);


        return ResponseEntity.ok(Objects.requireNonNull(request.getBody()));
    }


    //Llamada POST que guarda un "Animal"
    @PostMapping(path= "/dailyreport/animal", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> postAnimal(@RequestBody final Animal animal) {
        animals.add(animal);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body("Added successfully");
    }

    @PutMapping(value = "/dailyreport/animal/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> update(@PathVariable("id") final int id, @RequestBody final Animal sourceAnimal) {
        Animal targetAnimal;
        try{
            targetAnimal = animals.get(id);
            BeanUtils.copyProperties(sourceAnimal, targetAnimal, "id");
            return new ResponseEntity<>(targetAnimal, HttpStatus.OK);
        }
        catch (IndexOutOfBoundsException e){
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("There is not an object like that to update");
        }


    }

    //Llamada DELETE que elimina un "Animal"
    @DeleteMapping(value= "/dailyreport/animal/{id}")
    public ResponseEntity<?> deleteAnimal(@PathVariable(value= "id") final int id){

        try{
            animals.remove(animals.get(id));
            return ResponseEntity.ok("Removed successfully");
        }
        catch (IndexOutOfBoundsException e){
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("There is not an object like that to delete");
        }
    }
}
