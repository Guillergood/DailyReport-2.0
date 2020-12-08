package com.gbv.dailyreport.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;

//Clase que envuelve los datos relacionados con los Cuidadores
//Document indica el contenedor donde se guardara este objeto mongo
@Document(collection = "cuidadores")
public class Cuidador {
    //Indica el id por el que se rige este objeto
    @Id
    private int id;

    private String name;
    HashSet<Integer> reportsId;

    // Constructor para que acepte directamente un json
    public Cuidador(String json) throws JsonProcessingException {
        Cuidador c = new ObjectMapper().readValue(json, Cuidador.class);
        this.id = c.id;
        this.name = c.name;
        this.reportsId = new HashSet<>();
    }

    public Cuidador(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    // Constructor por defecto
    public Cuidador() {
        reportsId = new HashSet<>();
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashSet<Integer> getReportsId() {
        return reportsId;
    }

    //Añadir Informes que ha reportado el Cuidador
    public void addReportId(int id){
        reportsId.add(id);
    }

    //Borrar Informes que ha reportado el Cuidador
    public void deleteReportId(int id){
        reportsId.remove(id);
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
                ", reportsId=" + reportsId +
                '}';
    }
}
