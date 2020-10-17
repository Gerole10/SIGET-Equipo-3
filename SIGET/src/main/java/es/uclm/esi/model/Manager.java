package es.uclm.esi.model;

import java.time.LocalDate;

import org.json.JSONArray;

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
	
	/*
	public JSONArray getCalendarioPersonal(LocalDate fechaInferior, LocalDate fechaSuperior) {
		JSONArray calendario = new JSONArray();
		return calendario;
	}
	*/

}
