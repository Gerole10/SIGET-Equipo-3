package es.uclm.esi.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author Víctor
 * Clase de dominio que usaremos para instanciar reuniones
 */
@Document(collection= "reunion")
public class Reunion {
	
	@Id
	private int id;
	private String titulo;
	private LocalDate fecha;
	private LocalTime hora;
	private String[] asistentes;
	
	public Reunion(int id, String titulo, LocalDate fecha, LocalTime hora, String[] asistentes) {
		this.id=id;
		this.titulo=titulo;
		this.fecha=fecha;
		this.hora=hora;
		this.asistentes=asistentes;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
