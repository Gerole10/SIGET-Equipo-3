package es.uclm.esi.controller;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.uclm.esi.model.ServicioCalendarioPersonal;

/**
 * 
 * @author Víctor
 * Clase para recepción de mensajes http relacionados con obtener el calendario personal
 */
@RestController
public class ControllerCalendarioPersonal {
	
	@Autowired
	private ServicioCalendarioPersonal servcp;
	/**
	 * 
	 * @param fechasLimite
	 * @return JSONObject con todas las reuniones aceptadas por el solicitante
	 */
	@GetMapping("/getCalendarioPersonal")
	public JSONObject getCalendarioPersonal(@RequestBody Map<String, Object> fecha) {
		JSONObject jso = new JSONObject(fecha);
		int mes = jso.getInt("mes");
		int ano = jso.getInt("ano");
		return servcp.getCalendarioPersonal(mes, ano);
	}
	
	/*
	@GetMapping("/getUsuarioLogeado")
	public JSONObject getUsuarioLogeado() {
		//return servcp.getUsuarioLogeado();
	}
	*/

}
