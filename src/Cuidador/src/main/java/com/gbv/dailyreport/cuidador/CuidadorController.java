package com.gbv.dailyreport.cuidador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

//Clase que controlara las llamadas REST de "Cuidador"
@RestController
public class CuidadorController {
    //Se dice a la aplicacion el repositorio mongo es el siguiente y que lo autoconfigure
    @Qualifier("cuidadorRepository")
    @Autowired
    private CuidadorRepository repository;

    //Llamada GET que devuelve un cuidador
    @GetMapping(value = "/dailyreport/cuidador/{id}")
    public String getCuidador(@PathVariable(value = "id") final int id) {
        Cuidador cuidador = repository.findCuidadorById(id);
        return cuidador !=null ? cuidador.toString():"Not found!";
    }


    //Llamada POST que guarda un "Cuidador"
    @PostMapping(path= "/dailyreport/cuidador", consumes = "application/json", produces = "application/json")
    public void postCuidador(@RequestBody final Cuidador cuidador) {
        repository.save(cuidador);
    }

    //Llamada DELETE que elimina un "Cuidador"
    @DeleteMapping(value= "/dailyreport/cuidador/{id}")
    public void deleteCuidador(@PathVariable(value= "id") final int id){
        repository.deleteCuidadorById(id);
    }


}

