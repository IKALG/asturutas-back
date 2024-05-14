package com.asturutas.spring.web.app.models;

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
@Table(name="Fotos")
@Getter
@Setter
@ToString
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
}
