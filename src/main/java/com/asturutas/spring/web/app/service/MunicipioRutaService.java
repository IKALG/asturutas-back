package com.asturutas.spring.web.app.service;

import java.util.List;

import com.asturutas.spring.web.app.dto.municipioRuta.MunicipioRutaRequestDto;
import com.asturutas.spring.web.app.dto.municipioRuta.MunicipioRutaResponseDto;

public interface MunicipioRutaService {

	List<MunicipioRutaResponseDto> findAll();

	MunicipioRutaResponseDto findById(int id);

	MunicipioRutaResponseDto create(MunicipioRutaRequestDto municipioRutaRequestDto);

	MunicipioRutaResponseDto update(int id, MunicipioRutaRequestDto municipioRutaRequestDto);

	MunicipioRutaResponseDto delete(int id);

}
