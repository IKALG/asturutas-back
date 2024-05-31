package com.asturutas.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asturutas.spring.web.app.dto.actividad.ActividadRequestDto;
import com.asturutas.spring.web.app.dto.actividad.ActividadResponseDto;
import com.asturutas.spring.web.app.entity.ActividadEntity;
import com.asturutas.spring.web.app.mapper.ActividadMapper;
import com.asturutas.spring.web.app.repository.ActividadRepository;
import com.asturutas.spring.web.app.service.ActividadService;

@Service
public class ActividadServiceImpl implements ActividadService {

	@Autowired
	private ActividadRepository actividadRepository;

	@Autowired
	private ActividadMapper actividadMapper;

	public List<ActividadResponseDto> findAll() {
		List<ActividadEntity> actividadEntityList = actividadRepository.findAll();
		if (actividadEntityList.isEmpty()) {
			return new ArrayList<>();
		} else {
			List<ActividadResponseDto> actividadResponseDtoList = new ArrayList<>();
			for (ActividadEntity actividadEntity : actividadEntityList) {
				ActividadResponseDto actividadResponseDto = actividadMapper
						.entityToActividadResponseDto(actividadEntity);
				actividadResponseDtoList.add(actividadResponseDto);
			}
			return actividadResponseDtoList;
		}
	}

	public ActividadResponseDto findByNombre(String actividad) {
		Optional<ActividadEntity> optionalActividadEntity = actividadRepository.findByNombre(actividad);
		if (optionalActividadEntity.isPresent()) {
			ActividadResponseDto actividadResponseDto = actividadMapper.entityToActividadResponseDto(optionalActividadEntity.get());
			return actividadResponseDto;
		} else {
			throw new IllegalArgumentException("No existe una actividad con el id: " + actividad);
		}
	}

	public ActividadResponseDto create(ActividadRequestDto actividadRequestDto) {
		ActividadEntity actividadEntity = actividadMapper.requestDtoToEntity(actividadRequestDto);
		actividadRepository.save(actividadEntity);
		ActividadResponseDto actividadResponseDto = actividadMapper.entityToActividadResponseDto(actividadEntity);
		return actividadResponseDto;
	}

	public ActividadResponseDto update(String actividad, ActividadRequestDto actividadDto) {
		ActividadEntity actividadEntity = actividadMapper.requestDtoToEntity(actividad, actividadDto);
		actividadRepository.save(actividadEntity);
		ActividadResponseDto actividadResponseDto = actividadMapper.entityToActividadResponseDto(actividadEntity);
		return actividadResponseDto;
	}

	public ActividadResponseDto delete(String actividad) {
		ActividadResponseDto actividadResponseDto = this.findByNombre(actividad);
		ActividadEntity actividadEntity = actividadMapper.responseDtoToEntity(actividad, actividadResponseDto);
		actividadRepository.delete(actividadEntity);
		return actividadResponseDto;
	}

}
