package com.asturutas.spring.web.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Rutas")
public class Ruta {
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column (name="distancia")
	private float distancia;
	
	@Column (name="foto_url")
	private String foto_url;
	
	@Column (name="municipio")
	private String municipio;
	
	@Column (name="usuario_usuario")
	private String usuario;
	
	@Column (name="actividad")
	private String actividad;
	
	

	public Ruta() {
	}



	public Ruta(Long id, String nombre, String descripcion, float distancia, String foto_url, String municipio,
			String usuario, String actividad) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.distancia = distancia;
		this.foto_url = foto_url;
		this.municipio = municipio;
		this.usuario = usuario;
		this.actividad = actividad;
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



	public String getFoto_url() {
		return foto_url;
	}



	public void setFoto_url(String foto_url) {
		this.foto_url = foto_url;
	}



	public String getMunicipio() {
		return municipio;
	}



	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getActividad() {
		return actividad;
	}



	public void setActividad(String actividad) {
		this.actividad = actividad;
	}



	@Override
	public String toString() {
		return "Ruta [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", distancia=" + distancia
				+ ", foto_url=" + foto_url + ", municipio=" + municipio + ", usuario=" + usuario + ", actividad="
				+ actividad + "]";
	}
	
	
	
	
	
	
}
