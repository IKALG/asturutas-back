package com.asturutas.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asturutas.spring.web.app.dto.usuario.UsuarioRequestDto;
import com.asturutas.spring.web.app.dto.usuario.UsuarioResponseDto;
import com.asturutas.spring.web.app.entity.UsuarioEntity;
import com.asturutas.spring.web.app.mapper.UsuarioMapper;
import com.asturutas.spring.web.app.repository.UsuarioRepository;
import com.asturutas.spring.web.app.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioMapper usuarioMapper;

	public List<UsuarioResponseDto> findAll() {
		List<UsuarioEntity> usuarioEntityList = usuarioRepository.findAll();
		if (usuarioEntityList.isEmpty()) {
			return new ArrayList<>();
		} else {
			List<UsuarioResponseDto> usuarioResponseDtoList = new ArrayList<>();
			for (UsuarioEntity usuarioEntity : usuarioEntityList) {
				UsuarioResponseDto usuarioResponseDto = usuarioMapper.entityToUsuarioResponseDto(usuarioEntity);
				usuarioResponseDtoList.add(usuarioResponseDto);
			}
			return usuarioResponseDtoList;
		}
	}

	public UsuarioResponseDto findById(String usuario) {
		Optional<UsuarioEntity> optionalUsuarioEntity = usuarioRepository.findById(usuario);
		if (optionalUsuarioEntity.isPresent()) {
			UsuarioResponseDto usuarioResponseDto = usuarioMapper
					.entityToUsuarioResponseDto(optionalUsuarioEntity.get());
			return usuarioResponseDto;
		} else {
			throw new IllegalArgumentException("No existe una usuario con el id: " + usuario);
		}
	}

	public UsuarioResponseDto create(UsuarioRequestDto usuarioRequestDto) {
		UsuarioEntity usuarioEntity = usuarioMapper.requestDtoToEntity(usuarioRequestDto);
		usuarioRepository.save(usuarioEntity);
		UsuarioResponseDto usuarioResponseDto = usuarioMapper.entityToUsuarioResponseDto(usuarioEntity);
		return usuarioResponseDto;
	}

	public UsuarioResponseDto update(String usuario, UsuarioRequestDto usuarioDto) {
		UsuarioEntity usuarioEntity = usuarioMapper.requestDtoToEntity(usuario, usuarioDto);
		usuarioRepository.save(usuarioEntity);
		UsuarioResponseDto usuarioResponseDto = usuarioMapper.entityToUsuarioResponseDto(usuarioEntity);
		return usuarioResponseDto;
	}

	public UsuarioResponseDto delete(String usuario) {
		UsuarioResponseDto usuarioResponseDto = this.findById(usuario);
		UsuarioEntity usuarioEntity = usuarioMapper.responseDtoToEntity(usuario, usuarioResponseDto);
		usuarioRepository.delete(usuarioEntity);
		return usuarioResponseDto;
	}

}
