package com.asturutas.spring.web.app.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

	private String fotouno;
	
	private String fotodos;
	
	private String fototres;
	
	private String fotocuatro;
	
	private String fotocinco;

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "actividad_rutas",
               joinColumns = @JoinColumn(name = "id_ruta"),
               inverseJoinColumns = @JoinColumn(name = "nombre_actividad"))
    private Set<ActividadEntity> actividades = new HashSet<>();

	@Column(name = "usuario_usuario")
	private String usuario;

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "municipios_rutas",
               joinColumns = @JoinColumn(name = "id_ruta"),
               inverseJoinColumns = @JoinColumn(name = "nombre_municipio"))
    private Set<MunicipioEntity> municipios = new HashSet<>();
	
	@Column(name = "movilidad_reducida")
	private boolean movilidadReducida;

	@Column(name = "apto_ninos")
	private boolean aptoNinos;

	@Column(name = "apto_perros")
	private boolean aptoPerros;
}