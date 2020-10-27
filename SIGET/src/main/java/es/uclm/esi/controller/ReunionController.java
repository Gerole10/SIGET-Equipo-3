package es.uclm.esi.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uclm.esi.model.Reunion;
import es.uclm.esi.service.ServicioReuniones;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/reuniones")
public class ReunionController {
	
	@GetMapping("/create")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Reunion crearReunion(Reunion reunion) {
		return ServicioReuniones.crearReunion(reunion);
	}

	
}
