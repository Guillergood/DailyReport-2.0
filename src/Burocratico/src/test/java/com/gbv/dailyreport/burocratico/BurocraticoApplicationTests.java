package com.gbv.dailyreport.burocratico;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

/*
    Clase que implementa todas los test de la aplicacion "Burocratico"
    Se le da la opcion de que escoja un puerto aleatorio para que no coincida con otro proceso
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application.properties")
@Configuration
@ComponentScan
@AutoConfigureDataMongo
public class BurocraticoApplicationTests {
    //Variable autoconfigurada de puerto
    @LocalServerPort
    private int port;

    //Variable de URI que se va a tomar como base para el test
    private URI base;

    @Value("${server.host}")
    private String host;

    //Variable autoconfigurada para hacer peticiones REST
    @Autowired
    private TestRestTemplate template;

    //Metodo para configurar anteriormente los test
    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URI(host + port + "/dailyreport/report");
    }

    //Metodo para añadir un report a la colecccion
    @Test
    public void addReport() {
        Report report = new Report(66,"Alan","Bonobo", "Alan Reporting, Bonobos are fine!");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<Report> request = new HttpEntity<>(report, headers);

        ResponseEntity<String> result = this.template.postForEntity(base, request, String.class);

        
        Assert.assertEquals("El report se añadió",200, result.getStatusCodeValue());
    }

    //Metodo para devolver un report de la colecccion
    @Test
    public void getReport() throws URISyntaxException {
        addReport();
        URI uri = new URI(host + port + "/dailyreport/report/66");

        ResponseEntity<String> result = this.template.getForEntity(uri, String.class);

        
        Assert.assertEquals("El Report se pudo captar",200, result.getStatusCodeValue());
    }

    //Metodo para eliminar un animal de la colecccion
    @Test
    public void deleteReport() throws URISyntaxException {
        addReport();
        URI uri = new URI(host + port + "/dailyreport/report/66");


        this.template.delete(uri);

        ResponseEntity<String> result = this.template.getForEntity(uri, String.class);

        
        Assert.assertTrue("El Report fue borrado", Objects.requireNonNull(result.getBody()).contains("Not found!"));
    }


}



