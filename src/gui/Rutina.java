package gui;

import java.time.LocalDate;
import java.util.Date;

public class Rutina {

	private String numero;
	private String nombre;
	private String descripcion;
	private int progreso;
	private String fecha1;
	private String fecha2;
	

	
	public String getFecha1() {
		return fecha1;
	}
	public void setFecha1(String fecha1) {
		this.fecha1 = fecha1;
	}
	public String getFecha2() {
		return fecha2;
	}
	public void setFecha2(String fecha2) {
		this.fecha2 = fecha2;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getProgreso() {
		return progreso;
	}
	public void setProgreso(int progreso) {
		this.progreso = progreso;
	}

	
}
