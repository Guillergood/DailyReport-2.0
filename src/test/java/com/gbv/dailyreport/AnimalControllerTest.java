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