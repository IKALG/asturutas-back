package com.asturutas.spring.web.app.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="actividad")
@Getter
@Setter
@ToString
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
}
