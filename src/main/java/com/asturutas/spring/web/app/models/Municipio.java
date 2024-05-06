package com.asturutas.spring.web.app.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Municipios")
public class Municipio {
	@Id
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToMany(mappedBy = "municipios")
    private Set<Ruta> rutas = new HashSet<>();
	
	public Municipio() {
		
	}
	

	public Municipio(String nombre, Set<Ruta> rutas) {
		super();
		this.nombre = nombre;
		this.rutas = rutas;
	}


	public Set<Ruta> getRutas() {
		return rutas;
	}


	public void setRutas(Set<Ruta> rutas) {
		this.rutas = rutas;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Municipio [nombre=" + nombre + ", rutas=" + rutas + "]";
	}


	
	
}
