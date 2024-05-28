package com.asturutas.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asturutas.spring.web.app.dto.actividadRuta.ActividadRutaRequestDto;
import com.asturutas.spring.web.app.dto.actividadRuta.ActividadRutaResponseDto;
import com.asturutas.spring.web.app.entity.ActividadRutaEntity;
import com.asturutas.spring.web.app.mapper.ActividadRutaMapper;
import com.asturutas.spring.web.app.repository.ActividadRutaRepository;
import com.asturutas.spring.web.app.service.ActividadRutaService;

@Service
public class ActividadRutaServiceImpl implements ActividadRutaService {

	@Autowired
	private ActividadRutaRepository actividadRutaRepository;

	@Autowired
	private ActividadRutaMapper actividadRutaMapper;

	public List<ActividadRutaResponseDto> findAll() {
		List<ActividadRutaEntity> actividadRutaEntityList = actividadRutaRepository.findAll();
		if (actividadRutaEntityList.isEmpty()) {
			return new ArrayList<>();
		} else {
			List<ActividadRutaResponseDto> actividadRutaResponseDtoList = new ArrayList<>();
			for (ActividadRutaEntity actividadRutaEntity : actividadRutaEntityList) {
				ActividadRutaResponseDto actividadRutaResponseDto = actividadRutaMapper
						.entityToActividadRutaResponseDto(actividadRutaEntity);
				actividadRutaResponseDtoList.add(actividadRutaResponseDto);
			}
			return actividadRutaResponseDtoList;
		}
	}

	public ActividadRutaResponseDto findById(int id) {
		Optional<ActividadRutaEntity> optionalActividadRutaEntity = actividadRutaRepository.findById(id);
		if (optionalActividadRutaEntity.isPresent()) {
			ActividadRutaResponseDto actividadRutaResponseDto = actividadRutaMapper
					.entityToActividadRutaResponseDto(optionalActividadRutaEntity.get());
			return actividadRutaResponseDto;
		} else {
			throw new IllegalArgumentException("No existe una actividadRuta con el id: " + id);
		}
	}

	public ActividadRutaResponseDto create(ActividadRutaRequestDto actividadRutaRequestDto) {
		ActividadRutaEntity actividadRutaEntity = actividadRutaMapper.requestDtoToEntity(actividadRutaRequestDto);
		actividadRutaRepository.save(actividadRutaEntity);
		ActividadRutaResponseDto actividadRutaResponseDto = actividadRutaMapper
				.entityToActividadRutaResponseDto(actividadRutaEntity);
		return actividadRutaResponseDto;
	}

	public ActividadRutaResponseDto update(int id, ActividadRutaRequestDto actividadRutaDto) {
		ActividadRutaEntity actividadRutaEntity = actividadRutaMapper.requestDtoToEntity(id, actividadRutaDto);
		actividadRutaRepository.save(actividadRutaEntity);
		ActividadRutaResponseDto actividadRutaResponseDto = actividadRutaMapper
				.entityToActividadRutaResponseDto(actividadRutaEntity);
		return actividadRutaResponseDto;
	}

	public ActividadRutaResponseDto delete(int id) {
		ActividadRutaResponseDto actividadRutaResponseDto = this.findById(id);
		ActividadRutaEntity actividadRutaEntity = actividadRutaMapper.responseDtoToEntity(id, actividadRutaResponseDto);
		actividadRutaRepository.delete(actividadRutaEntity);
		return actividadRutaResponseDto;
	}
}
