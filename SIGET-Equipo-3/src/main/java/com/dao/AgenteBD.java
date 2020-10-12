package com.dao;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class AgenteBD {
	MongoDatabase database;
	Document document = new Document();
	public AgenteBD(){
	try {
	ConnectionString connString = new ConnectionString(
	   "mongodb+srv://Fatima:Fatima0@siget-equipo-3.j2x5d.mongodb.net/test?authSource=admin"
	);
	MongoClientSettings settings = MongoClientSettings.builder()
	   .applyConnectionString(connString)
	   .retryWrites(true)
	   .build();
	MongoClient mongoClient = MongoClients.create(settings);
	database = mongoClient.getDatabase("prueba");
	System.out.println("CONEXIÓN REALIZADA CON ÉXITO");
	}catch (Exception e){
	Logger.getLogger(AgenteBD.class.getName()).log(Level.SEVERE, null, e);
	}
	}
	public boolean insertar(String insercion) {
	MongoCollection<Document> coleccion = database.getCollection("tareas");
	document.append("tarea", "Esto es un ejemplo");
	coleccion.insertOne(document);
	return true;
	}
}
