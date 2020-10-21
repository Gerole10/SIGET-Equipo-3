package es.uclm.esi.model;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import es.uclm.esi.repository.RepositoryCalendarioPersonal;

/**
 * 
 * @author Víctor
 * Clase para gestionar la petición del controlador (obtener calendario personal) 
 */
@Service
public class ServicioCalendarioPersonal {

	/**
	 * 
	 * @param fechaInferior
	 * @param fechaSuperior
	 * @return JSONObject con todas las reuniones aceptadas por el solicitante
	 */
	public JSONObject getCalendarioPersonal(int mes, int ano) {
		RepositoryCalendarioPersonal rcp;

		JSONObject calendario = new JSONObject();
		return calendario;
	}
	
	/*
	public JSONObject getUsuarioLogeado() {
		
	}
	*/

}
