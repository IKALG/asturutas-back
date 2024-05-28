package com.asturutas.spring.web.app.dto.actividadRuta;

import com.asturutas.spring.web.app.dto.actividad.ActividadResponseDto;
import com.asturutas.spring.web.app.dto.ruta.RutaResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ActividadRutaResponseDto {

	private Integer id;
	private RutaResponseDto ruta;
	private ActividadResponseDto actividades;

}
