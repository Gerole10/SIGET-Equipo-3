package com.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Tarea;
import com.service.Tareaservice;

@RestController
@RequestMapping(value= "/tareas")
public class TareaRestController {

	@Autowired
	private Tareaservice serv;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@GetMapping(value= "/saludo")
	public String saludo() {
		
		return "test";
	}
	/**
	 * Method to save tareas in the db.
	 * @param emp
	 * @return
	 */
	@PostMapping(value= "/create")
	public String create(@RequestBody List<Tarea> emp) {
		logger.debug("Saving tareas.");
		serv.createTarea(emp);
		return "Tarea records created.";
	}

	/**
	 * Method to fetch all tareas from the db.
	 * @return
	 */
	@GetMapping(value= "/getall")
	public Collection<Tarea> getAll() {
		logger.debug("Getting all tareas.");
		return serv.getAllTareas();
	}

	/**
	 * Method to fetch tarea by id.
	 * @param id
	 * @return
	 */
	@GetMapping(value= "/getbyid/{tarea-id}")
	public Optional<Tarea> getById(@PathVariable(value= "tarea-id") String id) {
		logger.debug("Getting tarea with tarea-id= {}.", id);
		return serv.findTareaById(id);
	}

	/**
	 * Method to update tarea by id.
	 * @param id
	 * @param e
	 * @return
	 */
	@PutMapping(value= "/update/{tarea-id}")
	public String update(@PathVariable(value= "tarea-id") String id, @RequestBody Tarea e) {
		logger.debug("Updating tarea with tarea-id= {}.", id);
		//e.setDatabaseId(id);
		serv.updateTarea(e);
		return "Tarea record for tarea-id= " + id + " updated.";
	}

	/**
	 * Method to delete tarea by id.
	 * @param id
	 * @return
	 */
	@DeleteMapping(value= "/delete/{tarea-id}")
	public String delete(@PathVariable(value= "tarea-id") String id) {
		logger.debug("Deleting tarea with tarea-id= {}.", id);
		serv.deleteTareaById(id);
		return "Tarea record for tarea-id= " + id + " deleted.";
	}

	/**
	 * Method to delete all tareas from the db.
	 * @return
	 */
	@DeleteMapping(value= "/deleteall")
	public String deleteAll() {
		logger.debug("Deleting all tareas.");
		serv.deleteAllTareas();
		return "All tarea records deleted.";
	}
}