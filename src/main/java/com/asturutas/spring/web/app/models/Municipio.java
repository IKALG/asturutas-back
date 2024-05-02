package com.asturutas.spring.web.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Municipios")
public class Municipio {
	@Id
	@Column(name = "nombre")
	private String nombre;
	
	public Municipio() {
		
	}
	
	public Municipio(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Municipio [nombre=" + nombre + "]";
	}
	
	
}
