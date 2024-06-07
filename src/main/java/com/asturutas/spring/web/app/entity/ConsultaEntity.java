package com.asturutas.spring.web.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "consultas")
@Getter
@Setter
@ToString
public class ConsultaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "correo")
	private String correo;

	@Column(name = "mensaje")
	private String mensaje;
	
	@Column(name = "leido")
	private boolean leido;

}
