package com.gbv.dailyreport;

import com.gbv.dailyreport.controllers.ReportController;
import com.gbv.dailyreport.model.Report;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
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

@ExtendWith(SpringExtension.class)
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
    public void updateReport_withNoExistingReport_shouldReturnNotFound() throws Exception {
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
        result.andExpect(status().isNotFound());
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