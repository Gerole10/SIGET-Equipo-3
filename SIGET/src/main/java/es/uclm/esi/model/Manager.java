package es.uclm.esi.model;

import java.time.LocalDate;
// import java.util.Collection;

import org.json.JSONObject;

import es.uclm.esi.model.Manager;

public class Manager {
	
	private Manager() {
		
	}
	
	private static class ManagerHolder {
		static Manager singleton=new Manager();
	}
	
	public static Manager get() {
		return ManagerHolder.singleton;
	}
	
	public JSONObject getCalendarioPersonal(LocalDate fechaInferior, LocalDate fechaSuperior) {
		// Collection<Reunion> reuniones = ReunionesDAO.getReuniones();
		JSONObject calendario = new JSONObject();
		return calendario;
	}

}
