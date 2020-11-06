package com.gbv.dailyreport.burocratico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


//Clase que controlara las llamadas REST de "Burocratico (Report)"
@RestController
public class BurocraticoController {

    //Se dice a la aplicacion el repositorio mongo es el siguiente y que lo autoconfigure
    @Qualifier("reportRepository")
    @Autowired
    private ReportRepository repository;

    //Llamada GET que devuelve un "Report"
    @GetMapping(value = "dailyreport/report/{id}")
    public String getReport(@PathVariable(value = "id") final int id) {
        Report report = repository.findReportById(id);
        return report !=null ? report.toString():"Not found!";
    }

    //Llamada POST que guarda un "Report"
    @PostMapping(path= "dailyreport/report", consumes = "application/json", produces = "application/json")
    public void postReport(@RequestBody final Report report) {
        repository.save(report);
    }

    //Llamada DELETE que elimina un "Report"
    @DeleteMapping(value= "dailyreport/report/{id}")
    public void deleteReport(@PathVariable(value= "id") final int id){
        repository.deleteReportById(id);
    }


}

