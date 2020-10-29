package es.uclm.esi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalendarioStepDefinitions extends SpringIntegrationTest {
	 
    ResponseEntity<String> response ;
    
    Map<String, String> params = new HashMap<String, String>();
   
    
    @When("Consulta calendario  con el token {string}")
    	public void consulta_calendario_con_el_token(String string) {
        HttpHeaders headers = new HttpHeaders();
        headers.set ("Autorization", "Bearer " + string);
    	//header con el token
       
    }

    @When("con mes {int} y anio {int}")
    public void con_mes_y_anio(Integer int1, Integer int2) {
    	//CalendarioMesRequest fecha = new CalendarioMesRequest (int1, int2);
    	//HttpEntity <CalendarioMesRequest> request = new HttpEntity <>(fecha, headers);
    	//String url = DEFAULT_URL + "getCalendarioPersonalMes/";
    	//response = restTemplate.postForEntity(url, request, String.class); ES POSIBLE QUE HAYA QUE CREAR UN URI A PARTIR DEL URL
        // llamar al calendario del mes
    }
    
    @When("con dia {int} mes {int} y anio {int}")
    public void con_dia_mes_y_anio(Integer int1, Integer int2, Integer int3) {
    	//CalendarioDiaRequest fecha = new CalendarioDiaRequest (int1, int2, int3);
    	//HttpEntity <CalendarioDiaRequest> request = new HttpEntity <>(fecha, headers);
    	//String url = DEFAULT_URL + "getCalendarioPersonalDia/";
    	//response = restTemplate.postForEntity(url, request, String.class); ES POSIBLE QUE HAYA QUE CREAR UN URI A PARTIR DEL URL
        // llamar al calendario del dia
    }
    
    @When("consulta calendario mes con {string} vacio")
    public void consulta_calendario_mes_con_vacio(String string) {
    	int int1, int2;
    	if (string.equals("mes")) 
    	//CalendarioMesRequest fecha = new CalendarioMesRequest (int1, int2);
    	//HttpEntity <CalendarioMesRequest> request = new HttpEntity <>(fecha, headers);
    	//String url = DEFAULT_URL + "getCalendarioPersonalMes/";
    	//response = restTemplate.postForEntity(url, request, String.class); ES POSIBLE QUE HAYA QUE CREAR UN URI A PARTIR DEL URL
        throw new io.cucumber.java.PendingException();
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

