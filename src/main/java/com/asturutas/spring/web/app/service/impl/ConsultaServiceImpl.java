package com.asturutas.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asturutas.spring.web.app.dto.consulta.ConsultaRequestDto;
import com.asturutas.spring.web.app.dto.consulta.ConsultaResponseDto;
import com.asturutas.spring.web.app.entity.ConsultaEntity;
import com.asturutas.spring.web.app.mapper.ConsultaMapper;
import com.asturutas.spring.web.app.repository.ConsultaRepository;
import com.asturutas.spring.web.app.service.ConsultaService;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository;

	@Autowired
	private ConsultaMapper consultaMapper;

	public List<ConsultaResponseDto> findAll() {
		List<ConsultaEntity> consultaEntityList = consultaRepository.findAll();
		if (consultaEntityList.isEmpty()) {
			return new ArrayList<>();
		} else {
			List<ConsultaResponseDto> consultaResponseDtoList = new ArrayList<>();
			for (ConsultaEntity consultaEntity : consultaEntityList) {
				ConsultaResponseDto consultaResponseDto = consultaMapper
						.entityToConsultaResponseDto(consultaEntity);
				consultaResponseDtoList.add(consultaResponseDto);
			}
			return consultaResponseDtoList;
		}
	}

	public ConsultaResponseDto create(ConsultaRequestDto consultaRequestDto) {
		ConsultaEntity consultaEntity = consultaMapper.requestDtoToEntity(consultaRequestDto);
		consultaRepository.save(consultaEntity);
		ConsultaResponseDto consultaResponseDto = consultaMapper.entityToConsultaResponseDto(consultaEntity);
		return consultaResponseDto;
	}

}
