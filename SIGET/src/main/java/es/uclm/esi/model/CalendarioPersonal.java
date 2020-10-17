package es.uclm.esi.model;

public class CalendarioPersonal {
	
	private Reunion[] reuniones;
	private int empleado;
	
	public CalendarioPersonal(Reunion[] reuniones, int empleado) {
		this.reuniones=reuniones;
		this.empleado=empleado;
	}

	public Reunion[] getReuniones() {
		return reuniones;
	}

	public void setReuniones(Reunion[] reuniones) {
		this.reuniones = reuniones;
	}

	public int getEmpleado() {
		return empleado;
	}

	public void setEmpleado(int empleado) {
		this.empleado = empleado;
	}
	
	

}
