package com.asturutas.spring.web.app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.asturutas.spring.web.app.entity.RolEntity;
import com.asturutas.spring.web.app.repository.RolRepository;
import com.asturutas.spring.web.app.service.RolService;

public class RolServiceImpl implements RolService {
	
	@Autowired
	private RolRepository rolRepository;

	@Override
	public Optional<RolEntity> findById(Integer id) {
		Optional<RolEntity> rolEntity = rolRepository.findById(id);
		return rolEntity;
	}

}
