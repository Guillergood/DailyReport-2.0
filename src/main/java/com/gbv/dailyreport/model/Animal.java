package com.gbv.dailyreport.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;


//Clase que envuelve los datos relacionados con los Animales

@Entity
public class Animal {
    //Indica el id por el que se rige este objeto
    @Id
    private int id;

    private String name;
    private boolean checked;

    // Constructor para que acepte directamente un json
    public Animal(String json) throws JsonProcessingException {
        Animal c = new ObjectMapper().readValue(json, Animal.class);
        this.id = c.id;
        this.name = c.name;
        this.checked = c.checked;
    }

    public Animal(int id, String name, boolean checked) {
        super();
        this.id = id;
        this.name = name;
        this.checked = checked;
    }

    // Constructor por defecto
    public Animal() {}

    //Getter

    public String getName() {
        return name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    //Serializador
    public String serialize() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    //Metodo toString()
    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", checked=" + checked +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Id
    public int getId() {
        return id;
    }
}
