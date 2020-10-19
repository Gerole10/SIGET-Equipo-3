package es.uclm.esi.model;

import java.time.LocalDate;
// import java.util.Collection;

import org.json.JSONObject;

import es.uclm.esi.model.Manager;

/**
 * 
 * @author Víctor
 * Clase para gestionar la petición del controlador (obtener calendario personal) 
 */
public class Manager {
	
	private Manager() {
		// Vacío
	}
	
	private static class ManagerHolder {
		static Manager singleton=new Manager();
	}
	
	public static Manager get() {
		return ManagerHolder.singleton;
	}
	
	/**
	 * 
	 * @param fechaInferior
	 * @param fechaSuperior
	 * @return JSONObject con todas las reuniones aceptadas por el solicitante
	 */
	public JSONObject getCalendarioPersonal(LocalDate fechaInferior, LocalDate fechaSuperior) {
		// Collection<Reunion> reuniones = ReunionesDAO.getReuniones();
		JSONObject calendario = new JSONObject();
		return calendario;
	}

}
