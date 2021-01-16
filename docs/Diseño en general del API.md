---
layout: default
title: Diseño en general del API
nav_order: 16

---

# Diseño en general del API

{: .d-inline-block }
Nuevo
{: .label .label-purple }


---

La aplicación tiene las siguientes rutas

## Animal

GET `/dailyreport/animal/all` , que devuelve toda la colección animal.

GET `/dailyreport/animal/{id}` , que devuelve el animal en cuestion o si no devuelve un código not found (404) .

POST `/dailyreport/animal/` , que añade un animal a la colección animal .

PUT `/dailyreport/animal/{id}`, que modifica un animal existente por otro dado, si no existe previamente devuelve un código no content (204).

DELETE `/dailyreport/animal/{id}`, que elimina un animal, si no existe previamente devuelve un código no content (204).

## Cuidador

GET `/dailyreport/cuidador/all` , que devuelve toda la colección cuidador .

GET `/dailyreport/cuidador/{id}` , que devuelve el cuidador en cuestion o si no devuelve un código not found (404) .

POST `/dailyreport/cuidador/` , que añade un cuidador a la colección cuidador .

PUT `/dailyreport/cuidador/{id}`, que modifica un cuidador existente por otro dado, si no existe previamente devuelve un código no content (204).

DELETE `/dailyreport/cuidador/{id}`, que elimina un cuidador, si no existe previamente devuelve un código no content (204).

## Report

GET `/dailyreport/report/all` , que devuelve toda la colección report .

GET `/dailyreport/report/{id}` , que devuelve el report en cuestion o si no devuelve un código not found (404) .

POST `/dailyreport/report/` , que añade un report a la colección report .

PUT `/dailyreport/report/{id}`, que modifica un report existente por otro dado, si no existe previamente devuelve un código no content (204).

DELETE `/dailyreport/report/{id}`, que elimina un report, si no existe previamente devuelve un código no content (204).


Con las siguientes pruebas correspondientes:

````
package com.gbv.dailyreport;

import com.gbv.dailyreport.controllers.AnimalController;
import com.gbv.dailyreport.model.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;
import org.springframework.util.MimeTypeUtils;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AnimalController.class)
@ComponentScan
@AutoConfigureDataJpa
public class AnimalControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllAnimals() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/animal/all")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)));
    }

    @Test
    public void getAnimals_invalidAcceptHeader_shouldReturnNotAcceptable() throws Exception {
        // Given
        final String invalidAcceptMimeType = MimeTypeUtils.APPLICATION_XML_VALUE;

        // When
        final ResultActions result = mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/animal/all")
                .accept(invalidAcceptMimeType));

        // Then
        result.andExpect(status().isNotAcceptable());
    }

    @Test
    public void getAnimal_nonExistingAnimal_shouldReturnNotFound() throws Exception {
        // Given
        final int mockedId = 5;

        // When
        final ResultActions result = mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/animal/".concat(Integer.toString(mockedId)))
                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

        // Then
        result.andExpect(status().isNotFound());
    }

    @Test
    public void getAnimal_withExistingAnimal_shouldReturnOk() throws Exception {
        // Given
        final int mockedId = 2;

        // When
        final ResultActions result = mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/animal/".concat(Integer.toString(mockedId)))
                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

        // Then
        result.andExpect(status().isOk());
    }

    @Test
    public void updateAnimal_withExistingAnimal_shouldReturnOk() throws Exception {
        // Given
        final int mockedId = 2;
        final ResultActions sourceAnimal = mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/animal/".concat(Integer.toString(mockedId)))
                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

        String sourceAnimalString = sourceAnimal.andReturn().getResponse().getContentAsString();
        Animal modifiedAnimal = new Animal(sourceAnimalString);
        modifiedAnimal.setChecked(true);
        modifiedAnimal.setName("changed");
        // When
        final ResultActions result = mvc.perform(MockMvcRequestBuilders
                .put("/dailyreport/animal/".concat(Integer.toString(mockedId)))
                .content(modifiedAnimal.serialize())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));


        // Then
        result.andExpect(status().isOk());
    }

    @Test
    public void updateAnimal_withNoExistingAnimal_shouldReturnNoContent() throws Exception {
        // Given
        final int mockedId = 2;
        final ResultActions sourceAnimal = mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/animal/".concat(Integer.toString(mockedId)))
                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

        String sourceAnimalString = sourceAnimal.andReturn().getResponse().getContentAsString();
        Animal modifiedAnimal = new Animal(sourceAnimalString);
        modifiedAnimal.setId(100);
        modifiedAnimal.setChecked(true);
        modifiedAnimal.setName("changed");

        Assert.notNull(modifiedAnimal.toString(),"Animal is null");

        // When
        final ResultActions result = mvc.perform(MockMvcRequestBuilders
                .put("/dailyreport/animal/".concat(Integer.toString(100)))
                .content(modifiedAnimal.serialize())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));


        // Then
        result.andExpect(status().isNoContent());
    }

    //Metodo para añadir un animal a la colecccion
    @Test
    public void addAnimal_withExistingData_shouldReturnOk() throws Exception {
        Animal animal = new Animal(40, "Bonobo", false);

        this.mvc.perform(MockMvcRequestBuilders
                .post("/dailyreport/animal/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(animal.serialize()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());


    }


    //Metodo para eliminar un animal de la colecccion
    @Test
    public void delete_withExistingData_shouldReturnOk() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders
                .delete("/dailyreport/animal/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void delete_withBadId_shouldReturnNoContent() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders
                .delete("/dailyreport/animal/101")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());

    }


}
````

````
package com.gbv.dailyreport;

import com.gbv.dailyreport.controllers.CuidadorController;
import com.gbv.dailyreport.model.Cuidador;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;
import org.springframework.util.MimeTypeUtils;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CuidadorController.class)
@ComponentScan
@AutoConfigureDataJpa
public class CuidadorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllCuidadors() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/cuidador/all")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)));
    }

    @Test
    public void getCuidadors_invalidAcceptHeader_shouldReturnNotAcceptable() throws Exception {
        // Given
        final String invalidAcceptMimeType = MimeTypeUtils.APPLICATION_XML_VALUE;

        // When
        final ResultActions result = mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/cuidador/all")
                .accept(invalidAcceptMimeType));

        // Then
        result.andExpect(status().isNotAcceptable());
    }

    @Test
    public void getCuidador_nonExistingCuidador_shouldReturnNotFound() throws Exception {
        // Given
        final int mockedId = 5;

        // When
        final ResultActions result = mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/cuidador/".concat(Integer.toString(mockedId)))
                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

        // Then
        result.andExpect(status().isNotFound());
    }

    @Test
    public void getCuidador_withExistingCuidador_shouldReturnOk() throws Exception {
        // Given
        final int mockedId = 2;

        // When
        final ResultActions result = mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/cuidador/".concat(Integer.toString(mockedId)))
                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

        // Then
        result.andExpect(status().isOk());
    }

    @Test
    public void updateCuidador_withExistingCuidador_shouldReturnOk() throws Exception {
        // Given
        final int mockedId = 2;
        final ResultActions sourceCuidador = mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/cuidador/".concat(Integer.toString(mockedId)))
                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

        String sourceCuidadorString = sourceCuidador.andReturn().getResponse().getContentAsString();
        Cuidador modifiedCuidador = new Cuidador(sourceCuidadorString);
        modifiedCuidador.setName("changed");
        // When
        final ResultActions result = mvc.perform(MockMvcRequestBuilders
                .put("/dailyreport/cuidador/".concat(Integer.toString(mockedId)))
                .content(modifiedCuidador.serialize())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));


        // Then
        result.andExpect(status().isOk());
    }

    @Test
    public void updateCuidador_withNoExistingCuidador_shouldReturnNoContent() throws Exception {
        // Given
        final int mockedId = 2;
        final ResultActions sourceCuidador = mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/cuidador/".concat(Integer.toString(mockedId)))
                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

        String sourceCuidadorString = sourceCuidador.andReturn().getResponse().getContentAsString();
        Cuidador modifiedCuidador = new Cuidador(sourceCuidadorString);
        modifiedCuidador.setId(100);
        modifiedCuidador.setName("changed");

        Assert.notNull(modifiedCuidador.toString(),"Cuidador is null");

        // When
        final ResultActions result = mvc.perform(MockMvcRequestBuilders
                .put("/dailyreport/cuidador/".concat(Integer.toString(100)))
                .content(modifiedCuidador.serialize())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));


        // Then
        result.andExpect(status().isNoContent());
    }

    //Metodo para añadir un cuidador a la colecccion
    @Test
    public void addCuidador_withExistingData_shouldReturnOk() throws Exception {
        Cuidador cuidador = new Cuidador(40, "Keeper");

        this.mvc.perform(MockMvcRequestBuilders
                .post("/dailyreport/cuidador/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(cuidador.serialize()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());


    }


    //Metodo para eliminar un cuidador de la colecccion
    @Test
    public void delete_withExistingData_shouldReturnOk() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders
                .delete("/dailyreport/cuidador/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void delete_withBadId_shouldReturnNoContent() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders
                .delete("/dailyreport/cuidador/101")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());

    }


}
````

````
package com.gbv.dailyreport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest()
@ComponentScan
@AutoConfigureDataJpa
public class DailyreportApplicationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void applicationStarts() throws Exception {
        DailyreportApplication.main(new String[] {});
        mvc.perform( MockMvcRequestBuilders
                .get("/dailyreport/animal/all")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}

````

````
package com.gbv.dailyreport;

import com.gbv.dailyreport.controllers.ReportController;
import com.gbv.dailyreport.model.Report;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;
import org.springframework.util.MimeTypeUtils;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ReportController.class)
@ComponentScan
@AutoConfigureDataJpa
public class ReportControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllReports() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/report/all")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)));
    }

    @Test
    public void getReports_invalidAcceptHeader_shouldReturnNotAcceptable() throws Exception {
        // Given
        final String invalidAcceptMimeType = MimeTypeUtils.APPLICATION_XML_VALUE;

        // When
        final ResultActions result = mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/report/all")
                .accept(invalidAcceptMimeType));

        // Then
        result.andExpect(status().isNotAcceptable());
    }

    @Test
    public void getReport_nonExistingReport_shouldReturnNotFound() throws Exception {
        // Given
        final int mockedId = 5;

        // When
        final ResultActions result = mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/report/".concat(Integer.toString(mockedId)))
                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

        // Then
        result.andExpect(status().isNotFound());
    }

    @Test
    public void getReport_withExistingReport_shouldReturnOk() throws Exception {
        // Given
        final int mockedId = 2;

        // When
        final ResultActions result = mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/report/".concat(Integer.toString(mockedId)))
                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

        // Then
        result.andExpect(status().isOk());
    }

    @Test
    public void updateReport_withExistingReport_shouldReturnOk() throws Exception {
        // Given
        final int mockedId = 2;
        final ResultActions sourceReport = mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/report/".concat(Integer.toString(mockedId)))
                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

        String sourceReportString = sourceReport.andReturn().getResponse().getContentAsString();
        Report modifiedReport = new Report(sourceReportString);
        modifiedReport.setReport("changed");
        modifiedReport.setKeeperName("changed");
        modifiedReport.setAnimalName("changed");
        // When
        final ResultActions result = mvc.perform(MockMvcRequestBuilders
                .put("/dailyreport/report/".concat(Integer.toString(mockedId)))
                .content(modifiedReport.serialize())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));


        // Then
        result.andExpect(status().isOk());
    }

    @Test
    public void updateReport_withNoExistingReport_shouldReturnNoContent() throws Exception {
        // Given
        final int mockedId = 2;
        final ResultActions sourceReport = mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/report/".concat(Integer.toString(mockedId)))
                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));

        String sourceReportString = sourceReport.andReturn().getResponse().getContentAsString();
        Report modifiedReport = new Report(sourceReportString);
        modifiedReport.setId(100);
        modifiedReport.setReport("changed");
        modifiedReport.setKeeperName("changed");
        modifiedReport.setAnimalName("changed");

        Assert.notNull(modifiedReport.toString(),"Report is null");

        // When
        final ResultActions result = mvc.perform(MockMvcRequestBuilders
                .put("/dailyreport/report/".concat(Integer.toString(100)))
                .content(modifiedReport.serialize())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));


        // Then
        result.andExpect(status().isNoContent());
    }

    //Metodo para añadir un report a la colecccion
    @Test
    public void addReport_withExistingData_shouldReturnOk() throws Exception {
        Report report = new Report(40,"keeper","animal","hello");

        this.mvc.perform(MockMvcRequestBuilders
                .post("/dailyreport/report/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(report.serialize()))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());


    }


    //Metodo para eliminar un report de la colecccion
    @Test
    public void delete_withExistingData_shouldReturnOk() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders
                .delete("/dailyreport/report/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void delete_withBadId_shouldReturnNoContent() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders
                .delete("/dailyreport/report/101")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());

    }


}
````


Donde se ha hecho una [cobertura del 100% del código](https://codecov.io/gh/Guillergood/DailyReport-2.0), comprobando exhaustivamente las distintas posibilidades.
