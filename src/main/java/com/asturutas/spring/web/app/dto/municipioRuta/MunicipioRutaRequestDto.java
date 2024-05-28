package com.asturutas.spring.web.app.dto.municipioRuta;

import com.asturutas.spring.web.app.dto.municipio.MunicipioResponseDto;
import com.asturutas.spring.web.app.dto.ruta.RutaResponseDto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MunicipioRutaRequestDto {

	private Integer id;

	private RutaResponseDto rutas;

	private MunicipioResponseDto municipios;

}
