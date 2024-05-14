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
@Table(name="Municipios")
@Getter
@Setter
@ToString
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
}
