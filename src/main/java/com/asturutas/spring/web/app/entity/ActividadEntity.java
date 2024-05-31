package com.asturutas.spring.web.app.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "actividad")
@Getter
@Setter
@ToString
public class ActividadEntity {
	@Id
	@Column(name = "nombre")
	private String nombre;

	@ManyToMany(mappedBy = "actividades", fetch = FetchType.EAGER)
    private Set<RutaEntity> rutas = new HashSet<>();

}
