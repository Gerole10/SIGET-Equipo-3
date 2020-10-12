package com.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.model.Tarea;

public interface TareaDAO extends MongoRepository<Tarea, String> {
 
}