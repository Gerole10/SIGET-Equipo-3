package es.uclm.esi.model;

import java.util.ArrayList;
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
	 * @param mes
	 * @param ano
	 * @return JSONObject con todos los numeros de dia que haya reunion ese mes
	 */
	public JSONObject getCalendarioPersonalMes(int mes, int ano) {
		List<Reunion> reuniones = rcp.findAll(); 
		JSONObject calendario = new JSONObject();
		ArrayList<Integer> dias = new ArrayList<Integer>();
		for(int i=0; i<reuniones.size(); i++) {
			boolean asiste=false;
			for(int a=0; a<reuniones.get(i).getAsistentes().length; a++) {
				/*
				if(JwtUtils.getUserNameFromJwtToken(token).equals(reuniones.get(i).getAsistente(a))) {
						asiste=true;
				}
				*/
			}
			if(reuniones.get(i).getAno()==ano && reuniones.get(i).getMes()==mes && asiste) {
				dias.add(reuniones.get(i).getDia());
			}
			
		}
		calendario.put("dias", dias);
		
		return calendario;
	}
	
	/**
	 * 
	 * @param dia
	 * @return JSONObject con informacion detallada de la reunion ese dia
	 */
	
	public JSONObject getDetallesReunion(int dia) {
		List<Reunion> reuniones = rcp.findAll();
		JSONObject reunion = new JSONObject();
		for(int i=0; i<reuniones.size(); i++) {
			if(reuniones.get(i).getDia()==dia) {
				reunion.put("id", reuniones.get(i).getId());
				reunion.put("titulo", reuniones.get(i).getTitulo());
				reunion.put("dia", reuniones.get(i).getDia());
				reunion.put("mes", reuniones.get(i).getMes());
				reunion.put("ano", reuniones.get(i).getAno());
				reunion.put("hora", reuniones.get(i).getHora());
				reunion.put("asistentes", reuniones.get(i).getAsistentes());
			}
		}
		return reunion;
	}

}
