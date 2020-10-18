package es.uclm.esi.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "reunion")
public class Reunion {
	
	private String titulo;
	private LocalDate fecha;
	private LocalTime hora;
	private String[] asistentes;
	
	public Reunion(String titulo, LocalDate fecha, LocalTime hora, String[] asistentes) {
		this.titulo=titulo;
		this.fecha=fecha;
		this.hora=hora;
		this.asistentes=asistentes;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String[] getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(String[] asistentes) {
		this.asistentes = asistentes;
	}
	
	

}
