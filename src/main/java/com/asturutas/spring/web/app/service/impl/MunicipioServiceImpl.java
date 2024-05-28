package com.asturutas.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asturutas.spring.web.app.dto.municipio.MunicipioRequestDto;
import com.asturutas.spring.web.app.dto.municipio.MunicipioResponseDto;
import com.asturutas.spring.web.app.entity.MunicipioEntity;
import com.asturutas.spring.web.app.mapper.MunicipioMapper;
import com.asturutas.spring.web.app.repository.MunicipioRepository;
import com.asturutas.spring.web.app.service.MunicipioService;

@Service
public class MunicipioServiceImpl implements MunicipioService {

	@Autowired
	private MunicipioRepository municipioRepository;

	@Autowired
	private MunicipioMapper municipioMapper;

	public List<MunicipioResponseDto> findAll() {
		List<MunicipioEntity> municipioEntityList = municipioRepository.findAll();
		if (municipioEntityList.isEmpty()) {
			return new ArrayList<>();
		} else {
			List<MunicipioResponseDto> municipioResponseDtoList = new ArrayList<>();
			for (MunicipioEntity municipioEntity : municipioEntityList) {
				MunicipioResponseDto municipioResponseDto = municipioMapper
						.entityToMunicipioResponseDto(municipioEntity);
				municipioResponseDtoList.add(municipioResponseDto);
			}
			return municipioResponseDtoList;
		}
	}

	public MunicipioResponseDto findById(String municipio) {
		Optional<MunicipioEntity> optionalMunicipioEntity = municipioRepository.findById(municipio);
		if (optionalMunicipioEntity.isPresent()) {
			MunicipioResponseDto municipioResponseDto = municipioMapper
					.entityToMunicipioResponseDto(optionalMunicipioEntity.get());
			return municipioResponseDto;
		} else {
			throw new IllegalArgumentException("No existe una municipio con el id: " + municipio);
		}
	}

	public MunicipioResponseDto create(MunicipioRequestDto municipioRequestDto) {
		MunicipioEntity municipioEntity = municipioMapper.requestDtoToEntity(municipioRequestDto);
		municipioRepository.save(municipioEntity);
		MunicipioResponseDto municipioResponseDto = municipioMapper.entityToMunicipioResponseDto(municipioEntity);
		return municipioResponseDto;
	}

	public MunicipioResponseDto update(String municipio, MunicipioRequestDto municipioDto) {
		MunicipioEntity municipioEntity = municipioMapper.requestDtoToEntity(municipio, municipioDto);
		municipioRepository.save(municipioEntity);
		MunicipioResponseDto municipioResponseDto = municipioMapper.entityToMunicipioResponseDto(municipioEntity);
		return municipioResponseDto;
	}

	public MunicipioResponseDto delete(String municipio) {
		MunicipioResponseDto municipioResponseDto = this.findById(municipio);
		MunicipioEntity municipioEntity = municipioMapper.responseDtoToEntity(municipio, municipioResponseDto);
		municipioRepository.delete(municipioEntity);
		return municipioResponseDto;
	}

}
