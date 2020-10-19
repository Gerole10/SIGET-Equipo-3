package es.uclm.esi.controller;

import java.time.LocalDate;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.uclm.esi.model.Manager;

/**
 * 
 * @author Víctor
 * Clase para recepción de mensajes http relacionados con obtener el calendario personal
 */
@RestController
public class ControllerCalendarioPersonal {
	
	/**
	 * 
	 * @param fechasLimite
	 * @return JSONObject con todas las reuniones aceptadas por el solicitante
	 */
	@GetMapping("/getCalendarioPersonal")
	public JSONObject getCalendarioPersonal(@RequestBody Map<String, Object> fechasLimite) {
		JSONObject jso = new JSONObject(fechasLimite);
		LocalDate fechaInferior = (LocalDate) jso.get("fechaSuperior");
		LocalDate fechaSuperior = (LocalDate) jso.get("fechaSuperior");
		return Manager.get().getCalendarioPersonal(fechaInferior, fechaSuperior);
	}

}
