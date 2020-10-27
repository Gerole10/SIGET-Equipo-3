package es.uclm.esi.service;

import org.springframework.beans.factory.annotation.Autowired;

import es.uclm.esi.model.Reunion;
import es.uclm.esi.repository.ReunionRepository;

public class ServicioReuniones {

	@Autowired		
	ReunionRepository reunionRepository;
	public Reunion crearReunion(Reunion reunion) {
		return reunionRepository.save(reunion);
	}

}
