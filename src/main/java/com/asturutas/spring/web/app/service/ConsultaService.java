package com.asturutas.spring.web.app.service;

import java.util.List;

import com.asturutas.spring.web.app.dto.consulta.ConsultaRequestDto;
import com.asturutas.spring.web.app.dto.consulta.ConsultaResponseDto;

public interface ConsultaService {
	
	List<ConsultaResponseDto> findAll();

	ConsultaResponseDto create(ConsultaRequestDto consultaRequestDto);


}
