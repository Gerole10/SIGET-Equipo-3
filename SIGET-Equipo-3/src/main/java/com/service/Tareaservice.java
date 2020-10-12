package com.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


import com.model.Tarea;

 
public interface Tareaservice {

	/**
	 * Method to create new tareas in the db using mongo-db repository.
	 * @param tar
	 */
	public void createTarea(List<Tarea> tar);

	/**
	 * Method to fetch all tareas from the db using mongo-db repository.
	 * @return
	 */
	public Collection<Tarea> getAllTareas();

	/**
	 * Method to fetch tarea by id using mongo-db repository.
	 * @param id
	 * @return
	 */
	public Optional<Tarea> findTareaById(String id);

	/**
	 * Method to delete tarea by id using mongo-db repository.
	 * @param id
	 */
	public void deleteTareaById(String id);

	/**
	 * Method to update tarea by id using mongo-db repository.
	 * @param id
	 */
	public void updateTarea(Tarea tar);

	/**
	 * Method to delete all tareas using mongo-db repository.
	 */
	public void deleteAllTareas();
}