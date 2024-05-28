package com.asturutas.spring.web.app.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "rutas")
@Getter
@Setter
@ToString
public class RutaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "distancia")
	private float distancia;

	@Column(name = "dificultad")
	private String dificultad;

	@Column(name = "duracion")
	private float duracion;

	private String fotos;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "rutas")
	private List<ActividadRutaEntity> actividades;

	@Column(name = "usuario_usuario")
	private String usuario;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "rutas")
	private List<MunicipioRutaEntity> municipios;

	@Column(name = "movilidad_reducida")
	private boolean movilidadReducida;

	@Column(name = "apto_ninos")
	private boolean aptoNinos;

	@Column(name = "apto_perros")
	private boolean aptoPerros;
}