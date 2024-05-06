package com.asturutas.spring.web.app.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="actividad")
public class Actividad {
	@Id
	@Column(name="nombre")
	private String nombre;
	
	@ManyToMany(mappedBy = "actividades")
    private Set<Ruta> rutas = new HashSet<>();

	
	public Actividad() {
		super();
	}

	public Actividad(String nombre, Set<Ruta> rutas) {
		super();
		this.nombre = nombre;
		this.rutas = rutas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Ruta> getRutas() {
		return rutas;
	}

	public void setRutas(Set<Ruta> rutas) {
		this.rutas = rutas;
	}

	@Override
	public String toString() {
		return "Actividad [nombre=" + nombre + ", rutas=" + rutas + "]";
	}

	
}
