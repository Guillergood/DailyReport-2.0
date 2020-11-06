package com.gbv.dailyreport.burocratico;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Clase que envuelve los datos relacionados con los Reports
//Document indica el contenedor donde se guardara este objeto mongo
@Document(collection = "reports")
public class Report {
    //Indica el id por el que se rige este objeto
    @Id
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
    public int getId() {
        return id;
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
