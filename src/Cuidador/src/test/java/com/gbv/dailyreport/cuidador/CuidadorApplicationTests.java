package com.gbv.dailyreport.cuidador;

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
        Clase que implementa todas los test de la aplicacion "Animal"
        Se le da la opcion de que escoja un puerto aleatorio para que no coincida con otro proceso
*/

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application.properties")
@Configuration
@ComponentScan
@AutoConfigureDataMongo
public class CuidadorApplicationTests {
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
        this.base = new URI(host + port + "/dailyreport/cuidador");
    }
    
    //Metodo para añadir un cuidador a la colecccion
    @Test
    public void addCuidador() {
        Cuidador cuidador = new Cuidador(33,"Alan");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<Cuidador> request = new HttpEntity<>(cuidador, headers);

        ResponseEntity<String> result = this.template.postForEntity(base, request, String.class);

        
        Assert.assertEquals("El cuidador se añadió",200, result.getStatusCodeValue());
    }

    //Metodo para devolver un cuidador de la colecccion
    @Test
    public void getCuidador() throws URISyntaxException {
        addCuidador();
        URI uri = new URI(host + port + "/dailyreport/cuidador/33");


        ResponseEntity<String> result = this.template.getForEntity(uri, String.class);

        
        Assert.assertEquals("El Cuidador se pudo captar",200, result.getStatusCodeValue());
    }

    //Metodo para eliminar un cuidador de la colecccion
    @Test
    public void deleteCuidador() throws URISyntaxException {
        addCuidador();
        URI uri = new URI(host + port + "/dailyreport/cuidador/33");


        this.template.delete(uri);

        ResponseEntity<String> result = this.template.getForEntity(uri, String.class);

        
        Assert.assertTrue("El Cuidador fue borrado", Objects.requireNonNull(result.getBody()).contains("Not found!"));
    }


}



