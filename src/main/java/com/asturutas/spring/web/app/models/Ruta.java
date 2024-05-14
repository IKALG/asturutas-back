package com.asturutas.spring.web.app.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
@Table(name="Rutas")
@Getter
@Setter
@ToString
public class Ruta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column (name="distancia")
	private float distancia;
	
	@Column (name="dificultad")
	private String dificultad;
	
	@Column (name="duracion")
	private float duracion;
	
	@OneToMany(mappedBy = "ruta", fetch = FetchType.EAGER)
	private List<Foto> fotos = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "actividad_rutas",
               joinColumns = @JoinColumn(name = "id_ruta"),
               inverseJoinColumns = @JoinColumn(name = "nombre_actividad"))
    private Set<Actividad> actividades = new HashSet<>();
	
	@Column (name="usuario_usuario")
	private String usuario;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "municipios_rutas",
               joinColumns = @JoinColumn(name = "id_ruta"),
               inverseJoinColumns = @JoinColumn(name = "nombre_municipio"))
    private Set<Municipio> municipios = new HashSet<>();
	
	@Column (name="movilidad_reducida")
	private boolean movilidad_reducida;
	
	@Column (name="apto_ninos")
	private boolean apto_ninos;
	
	@Column (name="apto_perros")
	private boolean apto_perros;
	
	
	public Ruta() {
	}


	public Ruta(Long id, String nombre, String descripcion, float distancia, String dificultad, float duracion,
			List<Foto> fotos, Set<Actividad> actividades, String usuario, Set<Municipio> municipios,
			boolean movilidad_reducida, boolean apto_ninos, boolean apto_perros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.distancia = distancia;
		this.dificultad = dificultad;
		this.duracion = duracion;
		this.fotos = fotos;
		this.actividades = actividades;
		this.usuario = usuario;
		this.municipios = municipios;
		this.movilidad_reducida = movilidad_reducida;
		this.apto_ninos = apto_ninos;
		this.apto_perros = apto_perros;
	}	
}
