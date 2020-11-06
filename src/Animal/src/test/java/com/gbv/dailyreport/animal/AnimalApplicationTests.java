package com.gbv.dailyreport.animal;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;


/*
    Clase que implementa todas los test de la aplicacion "Animal"
    Se le da la opcion de que escoja un puerto aleatorio para que no coincida con otro proceso
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AnimalApplicationTests {
    //Variable autoconfigurada de puerto
    @LocalServerPort
    private int port;

    //Variable de URI que se va a tomar como base para el test
    private URI base;

    //Variable autoconfigurada para hacer peticiones REST
    @Autowired
    private TestRestTemplate template;

    //Metodo para configurar anteriormente los test
    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URI("http://localhost:" + port + "/dailyreport/animal");
    }

    //Metodo para añadir un animal a la colecccion
    @Test
    public void addAnimal() {
        Animal animal = new Animal(40,"Bonobo",false);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");

        HttpEntity<Animal> request = new HttpEntity<>(animal, headers);

        ResponseEntity<String> result = this.template.postForEntity(base, request, String.class);

        
        Assert.assertEquals("El animal se añadió",200, result.getStatusCodeValue());
    }

    //Metodo para devolver un animal de la colecccion
    @Test
    public void getAnimal() throws URISyntaxException {
        addAnimal();
        URI uri = new URI("http://localhost:" + port + "/dailyreport/animal/40");


        ResponseEntity<String> result = this.template.getForEntity(uri, String.class);

        
        Assert.assertEquals("El Animal se pudo captar",200, result.getStatusCodeValue());
    }

    //Metodo para eliminar un animal de la colecccion
    @Test
    public void deleteAnimal() throws URISyntaxException {
        addAnimal();
        URI uri = new URI("http://localhost:" + port + "/dailyreport/animal/40");


        this.template.delete(uri);

        ResponseEntity<String> result = this.template.getForEntity(uri, String.class);

        
        Assert.assertTrue("El Animal fue borrado", Objects.requireNonNull(result.getBody()).contains("Not found!"));
    }


}



