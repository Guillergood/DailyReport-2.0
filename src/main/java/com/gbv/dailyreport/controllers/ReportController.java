package com.gbv.dailyreport.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gbv.dailyreport.model.Report;
import com.gbv.dailyreport.service.impl.ReportServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReportController {

    private final ReportServiceImpl reportService;

    public ReportController(ReportServiceImpl reportService) {
        this.reportService = reportService;
    }
    @RequestMapping("/dailyreport/report")
    public List<Report> findAll() {
        return reportService.getAll();
    }

    //Llamada GET que devuelve un report
    @GetMapping(value = "/dailyreport/report/{id}")
    public ResponseEntity<?> getReport(@PathVariable(value = "id") final int id) throws JsonProcessingException {
        Report report;
        try {
            report = reportService.get(id);
        }
        catch (IndexOutOfBoundsException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("Not found");
        }

        return ResponseEntity.ok(report.serialize());
    }


    //Llamada POST que guarda un "Report"
    @PostMapping(path= "/dailyreport/report", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> postReport(@RequestBody final Report report) {
        reportService.add(report);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body("Added successfully");
    }

    @PutMapping(value = "/dailyreport/report/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> update(@PathVariable("id") final int id, @RequestBody final Report sourceReport) throws JsonProcessingException {
        Report targetReport;
        try{
            targetReport = reportService.get(id);
            reportService.edit(id,sourceReport);
            return new ResponseEntity<>(targetReport.serialize(), HttpStatus.OK);
        }
        catch (IndexOutOfBoundsException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("There is not an object like that to update");
        }


    }

    //Llamada DELETE que elimina un "Report"
    @DeleteMapping(value= "/dailyreport/report/{id}")
    public ResponseEntity<?> deleteReport(@PathVariable(value= "id") final int id){

        try{
            reportService.delete(reportService.get(id));
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
