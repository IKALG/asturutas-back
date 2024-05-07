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

@Entity
@Table(name="Rutas")
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



	public String getDificultad() {
		return dificultad;
	}


	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}


	public float getDuracion() {
		return duracion;
	}


	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}


	public boolean isMovilidad_reducida() {
		return movilidad_reducida;
	}


	public void setMovilidad_reducida(boolean movilidad_reducida) {
		this.movilidad_reducida = movilidad_reducida;
	}


	public boolean isApto_ninos() {
		return apto_ninos;
	}


	public void setApto_ninos(boolean apto_ninos) {
		this.apto_ninos = apto_ninos;
	}


	public boolean isApto_perros() {
		return apto_perros;
	}


	public void setApto_perros(boolean apto_perros) {
		this.apto_perros = apto_perros;
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public float getDistancia() {
		return distancia;
	}



	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}


	public List<Foto> getFotos() {
		return fotos;
	}


	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}


	public Set<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(Set<Municipio> municipios) {
		this.municipios = municipios;
	}

	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public Set<Actividad> getActividades() {
		return actividades;
	}


	public void setActividades(Set<Actividad> actividades) {
		this.actividades = actividades;
	}


	@Override
	public String toString() {
		return "Ruta [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", distancia=" + distancia
				+ ", dificultad=" + dificultad + ", duracion=" + duracion + ", fotos=" + fotos + ", actividades="
				+ actividades + ", usuario=" + usuario + ", municipios=" + municipios + ", movilidad_reducida="
				+ movilidad_reducida + ", apto_ninos=" + apto_ninos + ", apto_perros=" + apto_perros + "]";
	}

	
}
