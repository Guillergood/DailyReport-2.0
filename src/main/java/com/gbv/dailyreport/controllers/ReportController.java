package com.gbv.dailyreport.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gbv.dailyreport.model.Report;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReportController {

    //Se dice a la aplicacion el repositorio mongo es el siguiente y que lo autoconfigure
    private final List<Report> reports = new ArrayList<>();
    {

        reports.add(new Report(1,"name_1","animal_1","hello"));
        reports.add(new Report(2,"name_2","animal_2","hello"));
        reports.add(new Report(3,"name_3","animal_3","hello"));
        reports.add(new Report(4,"name_4","animal_4","hello"));
    }

    @RequestMapping("/dailyreport/report/all")
    public List<Report> findAll() {
        return reports;
    }

    //Llamada GET que devuelve un report
    @GetMapping(value = "/dailyreport/report/{id}")
    public ResponseEntity<?> getReport(@PathVariable(value = "id") final int id) throws JsonProcessingException {
        Report report;
        try {
            report = reports.get(id);
        }
        catch (IndexOutOfBoundsException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("Not found");
        }
        return ResponseEntity.ok(report.serialize());
    }

    @PutMapping(value = "/dailyreport/report/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> update(@PathVariable("id") final int id, @RequestBody final Report sourceReport) {
        Report targetReport;

        try {
            targetReport = reports.get(id);
            BeanUtils.copyProperties(sourceReport, targetReport, "id");
            return new ResponseEntity<>(targetReport, HttpStatus.OK);
        }
        catch (IndexOutOfBoundsException e){
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("There is not an object like that to update");
        }


    }

    //Llamada POST que guarda un "Report"
    @PostMapping(path= "/dailyreport/report", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> postReport(@RequestBody final Report report) {
        reports.add(report);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body("Added successfully");
    }

    //Llamada DELETE que elimina un "Report"
    @DeleteMapping(value= "/dailyreport/report/{id}")
    public ResponseEntity<?> deleteReport(@PathVariable(value= "id") final int id){

        try{
            reports.remove(reports.get(id));
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
