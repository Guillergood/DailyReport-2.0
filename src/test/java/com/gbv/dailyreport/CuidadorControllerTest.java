package com.gbv.dailyreport;

import com.gbv.dailyreport.controllers.CuidadorController;
import com.gbv.dailyreport.model.Cuidador;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
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
public class CuidadorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllCuidadores() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/dailyreport/cuidador/all")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)));
    }

    @Test
    public void getCuidadores_invalidAcceptHeader_shouldReturnNotAcceptable() throws Exception {
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
        Cuidador cuidador = new Cuidador(40, "Alan");

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
                .delete("/dailyreport/cuidador/0")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void delete_withBadId_shouldReturnNoContent() throws Exception {
        this.mvc.perform(MockMvcRequestBuilders
                .delete("/dailyreport/cuidador/100")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());

    }



}

