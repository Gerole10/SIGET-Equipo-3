package es.uclm.esi.model;

import java.time.LocalDate;
// import java.util.Collection;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import es.uclm.esi.model.ServicioCalendarioPersonal;

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
	public JSONObject getCalendarioPersonal(LocalDate fechaInferior, LocalDate fechaSuperior) {
		// Collection<Reunion> reuniones = RepositoryReuniones.getReuniones();
		JSONObject calendario = new JSONObject();
		return calendario;
	}

}
