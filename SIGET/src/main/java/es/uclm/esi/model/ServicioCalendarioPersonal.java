package es.uclm.esi.model;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import es.uclm.esi.repository.RepositoryCalendarioPersonal;

/**
 * 
 * @author Víctor
 * Clase para gestionar la petición del controlador (obtener calendario personal) 
 */
public class ServicioCalendarioPersonal {
	@Autowired
	private RepositoryCalendarioPersonal rcp;
	
	/**
	 * 
	 * @param fechaInferior
	 * @param fechaSuperior
	 * @return JSONObject con todas las reuniones aceptadas por el solicitante
	 */
	public JSONObject getCalendarioPersonal(int mes, int ano) {
		List<Reunion> reuniones = rcp.findAll();
		JSONObject calendario = new JSONObject();
		for(int i=0; i<reuniones.size(); i++) {
			if(reuniones.get(i).getAno()==ano && reuniones.get(i).getMes()==mes) {
				// Filtro de reuniones
			}
		}
		
		return calendario;
	}

}
