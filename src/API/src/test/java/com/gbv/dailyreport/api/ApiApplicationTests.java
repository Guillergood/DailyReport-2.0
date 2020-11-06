package com.gbv.dailyreport.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/*
    Clase que implementa todas los test de la aplicacion "Animal"
    Se le da la opcion de que escoja un puerto aleatorio para que no coincida con otro proceso
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiApplicationTests {

	//Variable autoconfigurada para hacer peticiones REST
	@Autowired
	private TestRestTemplate template;

	//Metodo para probar todas las conexiones
	@Test
	public void testConnections() throws JsonProcessingException {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		//Prueba de AGENTE BUROCRÁTICO (REPORTS)------------------------------------------------------------------------------------------------------------------------------
		//Prueba de POST && GET------------------------------------------------------------------------------------------------------------------------------
		Report report = new Report(1,"Alan","Alan reporting that Bonobos are fine!","Bonobo");
		HttpEntity<String> requestReport = new HttpEntity<>(report.serialize(), headers);
		this.template.postForObject("http://localhost:8081/dailyreport/report",requestReport,
				String.class);
		assertNotEquals("PRUEBA DE POST & GET CON AGENTE BUROCRÁTICO (REPORTS)",
				this.template.getForObject("http://localhost:8081/dailyreport/report/1",String.class),
				"Not found!");

		//Prueba de DELETE------------------------------------------------------------------------------------------------------------------------------
		this.template.delete("http://localhost:8081/dailyreport/report/1");
		assertEquals("PRUEBA DE DELETE CON AGENTE BUROCRÁTICO (REPORTS)",
				this.template.getForObject("http://localhost:8081/dailyreport/report/1",
						String.class),
				"Not found!");


		//Prueba de ANIMALES------------------------------------------------------------------------------------------------------------------------------
		//Prueba de POST && GET------------------------------------------------------------------------------------------------------------------------------
		Animal animal = new Animal(24,"Lemur", false);
		HttpEntity<String> requestAnimal = new HttpEntity<>(animal.serialize(), headers);
		this.template.postForObject("http://localhost:8080/dailyreport/animal",requestAnimal,
				String.class);
		assertNotEquals("PRUEBA DE POST & GET CON ANIMAL",
				this.template.getForObject("http://localhost:8080/dailyreport/animal/24",String.class)
				,"Not found!");
		//Prueba de DELETE------------------------------------------------------------------------------------------------------------------------------

		this.template.delete("http://localhost:8080/dailyreport/animal/24");
		assertEquals("PRUEBA DE DELETE CON ANIMAL",
				this.template.getForObject("http://localhost:8080/dailyreport/animal/24",String.class)
				,"Not found!");

		//Prueba de CUIDADOR------------------------------------------------------------------------------------------------------------------------------
		//Prueba de POST && GET------------------------------------------------------------------------------------------------------------------------------
		Cuidador cuidador = new Cuidador(33,"Sam");
		HttpEntity<String> requestCuidador = new HttpEntity<>(cuidador.serialize(), headers);
		this.template.postForObject("http://localhost:8082/dailyreport/cuidador",requestCuidador,
				String.class);
		assertNotEquals("PRUEBA DE POST & GET CON CUIDADOR",
				this.template.getForObject("http://localhost:8082/dailyreport/cuidador/33",String.class),
				"Not found!");

		//Prueba de DELETE------------------------------------------------------------------------------------------------------------------------------
		this.template.delete("http://localhost:8082/dailyreport/cuidador/33");
		assertEquals("PRUEBA DE DELETE CON CUIDADOR",
				this.template.getForObject("http://localhost:8082/dailyreport/cuidador/33",
						String.class),
				"Not found!");
	}
}
