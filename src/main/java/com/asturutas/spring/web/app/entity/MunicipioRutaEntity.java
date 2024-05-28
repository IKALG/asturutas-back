package com.asturutas.spring.web.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "municipios_rutas")
@Getter
@Setter
@ToString
public class MunicipioRutaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_ruta")
	private RutaEntity rutas;

	@ManyToOne
	@JoinColumn(name = "nombre_municipio")
	private MunicipioEntity municipios;
}
