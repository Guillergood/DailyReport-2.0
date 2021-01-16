package com.gbv.dailyreport.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

//Clase que envuelve los datos relacionados con los Reports

@Entity
public class Report {
    //Indica el id por el que se rige este objeto
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String keeperName;
    private String animalName;
    private String report;

    // Constructor para que acepte directamente un json
    public Report(String json) throws JsonProcessingException {
        Report c = new ObjectMapper().readValue(json, Report.class);
        this.id = c.id;
        this.keeperName = c.keeperName;
        this.animalName = c.animalName;
        this.report = c.report;
    }

    public Report(int id, String keeperName, String animalName, String report) {
        this.id = id;
        this.keeperName = keeperName;
        this.animalName = animalName;
        this.report = report;
    }

    // Constructor por defecto
    public Report() { }

    //Getters
    @javax.persistence.Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKeeperName(String keeperName) {
        this.keeperName = keeperName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getKeeperName() {
        return keeperName;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getReport() {
        return report;
    }

    //Serializador
    public String serialize() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    //Metodo toString()
    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", keeperName='" + keeperName + '\'' +
                ", animalName='" + animalName + '\'' +
                ", text='" + report + '\'' +
                '}';
    }

}
