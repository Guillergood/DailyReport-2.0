package com.gbv.dailyreport.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

//Clase que envuelve los datos relacionados con los Cuidadores

@Entity
public class Cuidador {
    //Indica el id por el que se rige este objeto
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String name;

    // Constructor para que acepte directamente un json
    public Cuidador(String json) throws JsonProcessingException {
        Cuidador c = new ObjectMapper().readValue(json, Cuidador.class);
        this.id = c.id;
        this.name = c.name;
    }

    public Cuidador(int id,String name) {
        this.id = id;
        this.name = name;
    }

    // Constructor por defecto
    public Cuidador() {

    }

    //Getters
    @javax.persistence.Id
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //Serializador
    public String serialize() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    //Metodo toString()
    @Override
    public String toString() {
        return "Cuidador{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
