package es.uclm.esi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;


import es.uclm.esi.clasesPrueba.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalendarioStepDefinitions extends SpringIntegrationTest {
	 
    ResponseEntity<String> response ;
    
    Map<String, String> params = new HashMap<String, String>();
   
    HttpHeaders headers = new HttpHeaders();
    @When("Consulta calendario  con el token {string}")
    	public void consulta_calendario_con_el_token(String string) {
       
        headers.set ("Autorization", "Bearer " + string);
    	//header con el token
       
    }

    @When("con mes {int} y anio {int}")
    public void con_mes_y_anio(Integer int1, Integer int2) {
    	CalendarioMesRequest fecha = new CalendarioMesRequest (int1, int2);
    	HttpEntity <CalendarioMesRequest> request = new HttpEntity <>(fecha, headers);
    	String url = DEFAULT_URL + "getCalendarioPersonalMes/";
    	response = restTemplate.postForEntity(url, request, String.class); //ES POSIBLE QUE HAYA QUE CREAR UN URI A PARTIR DEL URL
        // llamar al calendario del mes
    }
    
    @When("con dia {int} mes {int} y anio {int}")
    public void con_dia_mes_y_anio(Integer int1, Integer int2, Integer int3) {
    	CalendarioDiaRequest fecha = new CalendarioDiaRequest (int1, int2, int3);
    	HttpEntity <CalendarioDiaRequest> request = new HttpEntity <>(fecha, headers);
    	String url = DEFAULT_URL + "getCalendarioPersonalDia/";
    	response = restTemplate.postForEntity(url, request, String.class); //ES POSIBLE QUE HAYA QUE CREAR UN URI A PARTIR DEL URL
        // llamar al calendario del dia
    }
    
    @When("consulta calendario mes con {string} vacio")
    public void consulta_calendario_mes_con_vacio(String string) {
    	
    	if (string.equals("mes"));
    		HttpEntity <SoloAnio> request = new HttpEntity <>(new SoloAnio (2020), headers);
    		String url = DEFAULT_URL + "getCalendarioPersonalMes/";
        	response = restTemplate.postForEntity(url, request, String.class);
        	
       if (string.equals("anio"));
    		HttpEntity <SoloMes> request1 = new HttpEntity <>(new SoloMes (2), headers);
    		String url1 = DEFAULT_URL + "getCalendarioPersonalMes/";
        	response = restTemplate.postForEntity(url1, request1, String.class);
        	
        if (string.equals("todo"));
     		HttpEntity <ClaseVacia> request2 = new HttpEntity <>(new ClaseVacia (), headers);
     		String url2 = DEFAULT_URL + "getCalendarioPersonalMes/";
         	response = restTemplate.postForEntity(url2, request2, String.class);
    }


    @When("consulta calendario dia con {string} vacio")
    public void consulta_calendario_dia_con_vacio(String string) {
        
        throw new io.cucumber.java.PendingException();
    }
 
    @Then("la respuesta debe ser {string}")
    public void la_respuesta_debe_ser(String string) {
        //assertEquals(string, response.toString());
    }
}

