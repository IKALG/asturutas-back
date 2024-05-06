package com.asturutas.spring.web.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Fotos")
public class Foto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="src")
	private String src;
	
	@ManyToOne
    @JoinColumn(name = "id_ruta")
    private Ruta ruta;

	public Foto() {
		super();
	}

	public Foto(Long id, String src, Ruta ruta) {
		super();
		this.id = id;
		this.src = src;
		this.ruta = ruta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	@Override
	public String toString() {
		return "Foto [id=" + id + ", src=" + src + ", ruta=" + ruta + "]";
	}
	
	

}
