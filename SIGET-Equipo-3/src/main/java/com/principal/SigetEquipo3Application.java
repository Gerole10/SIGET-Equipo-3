package com.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dao.AgenteBD;

@SpringBootApplication
public class SigetEquipo3Application {

	public static void main(String[] args) {
		SpringApplication.run(SigetEquipo3Application.class, args);	
		AgenteBD agente;
		agente = new AgenteBD();
		boolean ok=agente.insertar("Esto es un ejemplo2");
		if(ok) {
		System.out.println("Inserción realizada con éxito");
		} else {
		System.out.println("Error al insertar");
		}
	}
}
