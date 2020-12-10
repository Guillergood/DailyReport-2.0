package com.gbv.dailyreport.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gbv.dailyreport.model.Cuidador;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CuidadorController {

    private final List<Cuidador> cuidadores = new ArrayList<>();
    {
        cuidadores.add(new Cuidador(1, "entity_1"));
        cuidadores.add(new Cuidador(2, "entity_2"));
        cuidadores.add(new Cuidador(3, "entity_3"));
        cuidadores.add(new Cuidador(4, "entity_4"));
    }



    @RequestMapping("/dailyreport/cuidador/all")
    public List<Cuidador> findAll() {
        return cuidadores;
    }

    //Llamada GET que devuelve un cuidador
    @GetMapping(value = "/dailyreport/cuidador/{id}")
    public ResponseEntity<?> getCuidador(@PathVariable(value = "id") final int id) throws JsonProcessingException {
        Cuidador cuidador;
        try {
            cuidador = cuidadores.get(id);
        }
        catch (IndexOutOfBoundsException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("Not found");
        }
        return ResponseEntity.ok(cuidador.serialize());
    }


    //Llamada POST que guarda un "Cuidador"
    @PostMapping(path= "/dailyreport/cuidador", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> postCuidador(@RequestBody final Cuidador cuidador) {
        cuidadores.add(cuidador);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body("Added successfully");
    }

    @PutMapping(value = "/dailyreport/cuidador/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> update(@PathVariable("id") final int id, @RequestBody final Cuidador sourceCuidador) {
        Cuidador targetCuidador;
        try{
            targetCuidador = cuidadores.get(id);
            BeanUtils.copyProperties(sourceCuidador, targetCuidador, "id");
            return new ResponseEntity<>(targetCuidador, HttpStatus.OK);
        }
        catch (IndexOutOfBoundsException e){
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("There is not an object like that to update");
        }


    }

    //Llamada DELETE que elimina un "Cuidador"
    @DeleteMapping(value= "/dailyreport/cuidador/{id}")
    public ResponseEntity<?> deleteCuidador(@PathVariable(value= "id") final int id){

        try{
            cuidadores.remove(cuidadores.get(id));
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
