package com.asturutas.spring.web.app.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "actividades")
	private List<ActividadRutaEntity> actividades;

}
