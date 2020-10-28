package es.uclm.esi.controller;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import es.uclm.esi.service.ServicioCalendarioPersonal;

/**
 * 
 * @author Víctor
 * Clase para recepción de mensajes http relacionados con obtener el calendario personal
 */
@RestController
public class ControllerCalendarioPersonal {
	
	
	private ServicioCalendarioPersonal servcp;
	
	/**
	 * 
	 * @param fecha
	 * @return JSONObject con todos los numeros de dias que haya reunion ese mes
	 */
	@GetMapping("/getCalendarioPersonalMes")
	public JSONObject getCalendarioPersonalMes(@RequestHeader("Authorization") String auth, @RequestBody Map<String, Object> fecha) {
		JSONObject jso = new JSONObject(fecha);
		int mes = jso.getInt("mes");
		int ano = jso.getInt("ano");
		return servcp.getCalendarioPersonalMes(auth.substring(7, auth.length()),mes, ano);
	}
	
	/**
	 * 
	 * @param fecha
	 * @return JSONObject con informacion detallada de todas las reuniones de ese dia
	 */
	@GetMapping("/getDetallesReunion")
	public JSONObject getDetallesReunion(@RequestBody Map<String, Object> fecha) {
		JSONObject jso = new JSONObject(fecha);
		int dia = jso.getInt("dia");
		return servcp.getDetallesReunion(dia);
	}

}
