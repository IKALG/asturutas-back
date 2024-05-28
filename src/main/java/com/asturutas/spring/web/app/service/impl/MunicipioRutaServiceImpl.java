package com.asturutas.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asturutas.spring.web.app.dto.municipioRuta.MunicipioRutaRequestDto;
import com.asturutas.spring.web.app.dto.municipioRuta.MunicipioRutaResponseDto;
import com.asturutas.spring.web.app.entity.MunicipioRutaEntity;
import com.asturutas.spring.web.app.mapper.MunicipioRutaMapper;
import com.asturutas.spring.web.app.repository.MunicipioRutaRepository;

@Service
public class MunicipioRutaServiceImpl {

	@Autowired
	private MunicipioRutaRepository municipioRutaRepository;

	@Autowired
	private MunicipioRutaMapper municipioRutaMapper;

	public List<MunicipioRutaResponseDto> findAll() {
		List<MunicipioRutaEntity> municipioRutaEntityList = municipioRutaRepository.findAll();
		if (municipioRutaEntityList.isEmpty()) {
			return new ArrayList<>();
		} else {
			List<MunicipioRutaResponseDto> municipioRutaResponseDtoList = new ArrayList<>();
			for (MunicipioRutaEntity municipioRutaEntity : municipioRutaEntityList) {
				MunicipioRutaResponseDto municipioRutaResponseDto = municipioRutaMapper
						.entityToMunicipioRutaResponseDto(municipioRutaEntity);
				municipioRutaResponseDtoList.add(municipioRutaResponseDto);
			}
			return municipioRutaResponseDtoList;
		}
	}

	public MunicipioRutaResponseDto findById(int id) {
		Optional<MunicipioRutaEntity> optionalMunicipioRutaEntity = municipioRutaRepository.findById(id);
		if (optionalMunicipioRutaEntity.isPresent()) {
			MunicipioRutaResponseDto municipioRutaResponseDto = municipioRutaMapper
					.entityToMunicipioRutaResponseDto(optionalMunicipioRutaEntity.get());
			return municipioRutaResponseDto;
		} else {
			throw new IllegalArgumentException("No existe una municipioRuta con el id: " + id);
		}
	}

	public MunicipioRutaResponseDto create(MunicipioRutaRequestDto municipioRutaRequestDto) {
		MunicipioRutaEntity municipioRutaEntity = municipioRutaMapper.requestDtoToEntity(municipioRutaRequestDto);
		municipioRutaRepository.save(municipioRutaEntity);
		MunicipioRutaResponseDto municipioRutaResponseDto = municipioRutaMapper
				.entityToMunicipioRutaResponseDto(municipioRutaEntity);
		return municipioRutaResponseDto;
	}

	public MunicipioRutaResponseDto update(int id, MunicipioRutaRequestDto municipioRutaDto) {
		MunicipioRutaEntity municipioRutaEntity = municipioRutaMapper.requestDtoToEntity(id, municipioRutaDto);
		municipioRutaRepository.save(municipioRutaEntity);
		MunicipioRutaResponseDto municipioRutaResponseDto = municipioRutaMapper
				.entityToMunicipioRutaResponseDto(municipioRutaEntity);
		return municipioRutaResponseDto;
	}

	public MunicipioRutaResponseDto delete(int id) {
		MunicipioRutaResponseDto municipioRutaResponseDto = this.findById(id);
		MunicipioRutaEntity municipioRutaEntity = municipioRutaMapper.responseDtoToEntity(id, municipioRutaResponseDto);
		municipioRutaRepository.delete(municipioRutaEntity);
		return municipioRutaResponseDto;
	}

}
