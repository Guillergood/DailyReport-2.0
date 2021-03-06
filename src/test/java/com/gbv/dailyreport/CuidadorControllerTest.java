package com.gbv.dailyreport;

import com.gbv.dailyreport.controllers.CuidadorController;
import com.gbv.dailyreport.model.Cuidador;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;
import org.springframework.util.MimeTypeUtils;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CuidadorController.class)
@ComponentScan
@AutoConfigureDataMongo
public class CuidadorControllerTest {

    @Autowired
    private MockMvc mvc;

    private void populateCuidadores() throws Exception {
        Cuidador cuidador = new Cuidador(1,"name_1");

        this.mvc.perform(MockMvcRequestBuilders
                .post("/dailyreport/cuidador/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(cuidador.serialize()));

        cuidador = new Cuidador(2,"name_2");

        this.mvc.perform(MockMvcRequestBuilders
                .post("/dailyreport/cuidador/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(cuidador.serialize()));

        cuidador = new Cuidador(3,"name_3");

        this.mvc.perform(MockMvcRequestBuilders
                .post("/dailyreport/cuidador/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(cuidador.serialize()));
        cuidador = new Cuidador(4,"name_4");

        this.mvc.perform(MockMvcRequestBuilders
                .post("/dailyreport/cuidador/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(cuidador.serialize()));
    }

    @Test
    public void getAllCuidadors() throws Exception {
        populateCuidadores();
        mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/cuidador")
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
                .get("/dailyreport/cuidador")
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
        populateCuidadores();
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
        populateCuidadores();
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
    public void updateCuidador_withNoExistingCuidador_shouldReturnNotFound() throws Exception {
        // Given
        populateCuidadores();
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
        result.andExpect(status().isNotFound());
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
        populateCuidadores();
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
                .andExpect(status().isNotFound());

    }


}