package com.asturutas.spring.web.app.service;

import java.util.List;

import com.asturutas.spring.web.app.dto.municipio.MunicipioRequestDto;
import com.asturutas.spring.web.app.dto.municipio.MunicipioResponseDto;

public interface MunicipioService {

	List<MunicipioResponseDto> findAll();

	MunicipioResponseDto findByNombre(String municipio);

	MunicipioResponseDto create(MunicipioRequestDto municipioRequestDto);

	MunicipioResponseDto update(String municipio, MunicipioRequestDto municipioRequestDto);

	MunicipioResponseDto delete(String municipio);

}
