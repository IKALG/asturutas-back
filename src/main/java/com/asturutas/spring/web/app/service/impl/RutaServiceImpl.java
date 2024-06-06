package com.asturutas.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asturutas.spring.web.app.dto.ruta.RutaRequestDto;
import com.asturutas.spring.web.app.dto.ruta.RutaResponseDto;
import com.asturutas.spring.web.app.entity.RutaEntity;
import com.asturutas.spring.web.app.mapper.RutaMapper;
import com.asturutas.spring.web.app.repository.RutaRepository;
import com.asturutas.spring.web.app.service.ActividadService;
import com.asturutas.spring.web.app.service.MunicipioService;
import com.asturutas.spring.web.app.service.RutaService;

@Service
public class RutaServiceImpl implements RutaService {

	@Autowired
	private RutaRepository rutaRepository;

	@Autowired
	private RutaMapper rutaMapper;
	
	@Autowired
	private ActividadService actividadService;
	
	@Autowired
	private MunicipioService municipioService;

	public List<RutaResponseDto> findAll() {
		List<RutaEntity> rutaEntityList = rutaRepository.findAll();
		if (rutaEntityList.isEmpty()) {
			return new ArrayList<>();
		} else {
			List<RutaResponseDto> rutaResponseDtoList = new ArrayList<>();
			for (RutaEntity rutaEntity : rutaEntityList) {
				RutaResponseDto rutaResponseDto = rutaMapper.entityToRutaResponseDto(rutaEntity);
				rutaResponseDtoList.add(rutaResponseDto);
			}
			return rutaResponseDtoList;
		}
	}

	@Override
	public RutaResponseDto findById(int id) {
		Optional<RutaEntity> optionalRutaEntity = rutaRepository.findById(id);
		if (optionalRutaEntity.isPresent()) {
			RutaResponseDto rutaResponseDto = rutaMapper.entityToRutaResponseDto(optionalRutaEntity.get());
			return rutaResponseDto;
		} else {
			throw new IllegalArgumentException("No existe una ruta con el id: " + id);
		}
	}

	@Override
	public RutaResponseDto create(RutaRequestDto rutaRequestDto) {
		RutaEntity rutaEntity = rutaMapper.requestDtoToEntity(rutaRequestDto);
		rutaRepository.save(rutaEntity);
		RutaResponseDto rutaResponseDto = rutaMapper.entityToRutaResponseDto(rutaEntity);
		return rutaResponseDto;
	}

	@Override
	public RutaResponseDto update(int id, RutaRequestDto rutaDto) {
		RutaEntity rutaEntity = rutaMapper.requestDtoToEntity(id, rutaDto);
		rutaRepository.save(rutaEntity);
		RutaResponseDto rutaResponseDto = rutaMapper.entityToRutaResponseDto(rutaEntity);
		return rutaResponseDto;
	}

	@Override
	public RutaResponseDto delete(int id) {
		RutaResponseDto rutaResponseDto = this.findById(id);
		RutaEntity rutaEntity = rutaMapper.responseDtoToEntity(id, rutaResponseDto);
		rutaRepository.delete(rutaEntity);
		return rutaResponseDto;
	}

	@Override
	public List<RutaResponseDto> findRutasByActividad(String actividad) {
		List<RutaEntity> rutaEntityList = rutaRepository.findRutasByActividad(actividad);
		if(rutaEntityList.isEmpty()) {
			return new ArrayList<>();
		} else {
			List <RutaResponseDto> rutaResponseDtoList = new ArrayList<>();
			for (RutaEntity rutaEntity : rutaEntityList) {
				RutaResponseDto rutaResponseDto = rutaMapper.entityToRutaResponseDto(rutaEntity);
				rutaResponseDtoList.add(rutaResponseDto);
			}
			return rutaResponseDtoList;
		}
	}

	@Override
	public List<RutaResponseDto> findRutasByMunicipio(String municipio) {
		List <RutaEntity> rutaEntityList = rutaRepository.findRutasByMunicipio(municipio);
		if(rutaEntityList.isEmpty()) {
			return new ArrayList<>();
		} else {
			List <RutaResponseDto> rutaResponseDtoList = new ArrayList<>();
			for (RutaEntity rutaEntity : rutaEntityList) {
				RutaResponseDto rutaResponseDto = rutaMapper.entityToRutaResponseDto(rutaEntity);
				rutaResponseDtoList.add(rutaResponseDto);
			}
			return rutaResponseDtoList;
		}
	}
	
	@Override
	public List<RutaResponseDto> findRutasByUsuario(String usuario) {
		List <RutaEntity> rutaEntityList = rutaRepository.findRutasByUsuario(usuario);
		if(rutaEntityList.isEmpty()) {
			return new ArrayList<>();
		} else {
			List <RutaResponseDto> rutaResponseDtoList = new ArrayList<>();
			for (RutaEntity rutaEntity : rutaEntityList) {
				RutaResponseDto rutaResponseDto = rutaMapper.entityToRutaResponseDto(rutaEntity);
				rutaResponseDtoList.add(rutaResponseDto);
			}
			return rutaResponseDtoList;
		}
	}

	@Override
	public List<RutaResponseDto> findRutasByMovilidad() {
		List <RutaEntity> rutaEntityList = rutaRepository.findRutasByMovilidad();
		if(rutaEntityList.isEmpty()) {
			return new ArrayList<>();
		} else {
			List <RutaResponseDto> rutaResponseDtoList = new ArrayList<>();
			for (RutaEntity rutaEntity : rutaEntityList) {
				RutaResponseDto rutaResponseDto = rutaMapper.entityToRutaResponseDto(rutaEntity);
				rutaResponseDtoList.add(rutaResponseDto);
			}
			return rutaResponseDtoList;
		}
	}

	@Override
	public List<RutaResponseDto> findRutasByPerros() {
		List <RutaEntity> rutaEntityList = rutaRepository.findRutasByPerros();
		if(rutaEntityList.isEmpty()) {
			return new ArrayList<>();
		} else {
			List <RutaResponseDto> rutaResponseDtoList = new ArrayList<>();
			for (RutaEntity rutaEntity : rutaEntityList) {
				RutaResponseDto rutaResponseDto = rutaMapper.entityToRutaResponseDto(rutaEntity);
				rutaResponseDtoList.add(rutaResponseDto);
			}
			return rutaResponseDtoList;
		}
	}

	@Override
	public List<RutaResponseDto> findRutasByNinos() {
		List <RutaEntity> rutaEntityList = rutaRepository.findRutasByNinos();
		if(rutaEntityList.isEmpty()) {
			return new ArrayList<>();
		} else {
			List <RutaResponseDto> rutaResponseDtoList = new ArrayList<>();
			for (RutaEntity rutaEntity : rutaEntityList) {
				RutaResponseDto rutaResponseDto = rutaMapper.entityToRutaResponseDto(rutaEntity);
				rutaResponseDtoList.add(rutaResponseDto);
			}
			return rutaResponseDtoList;
		}
	}

}
