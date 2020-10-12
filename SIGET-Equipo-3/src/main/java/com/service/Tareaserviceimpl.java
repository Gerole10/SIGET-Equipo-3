package com.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TareaDAO;
import com.model.Tarea;



@Service
public class Tareaserviceimpl implements Tareaservice {

	// The dao repository will use the Mongodb-Repository to perform the database operations.
	@Autowired
	TareaDAO dao;

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.Tareaservice#createTarea(java.util.List)
	 */
	@Override
	public void createTarea(List<Tarea> emp) {
		dao.saveAll(emp);
	}

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.Tareaservice#getAllTareas()
	 */
	@Override
	public Collection<Tarea> getAllTareas() {
		return dao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.Tareaservice#findTareaById(int)
	 */
	@Override
	public Optional<Tarea> findTareaById(String id) {
		return dao.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.Tareaservice#deleteTareaById(int)
	 */
	@Override
	public void deleteTareaById(String id) {
		dao.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.Tareaservice#updateTarea(int)
	 */
	@Override
	public void updateTarea(Tarea emp) {
		dao.save(emp);
	}

	/* (non-Javadoc)
	 * @see com.assignment.springboot.mongo.service.Tareaservice#deleteAllTareas()
	 */
	@Override
	public void deleteAllTareas() {
		dao.deleteAll();
	}

}