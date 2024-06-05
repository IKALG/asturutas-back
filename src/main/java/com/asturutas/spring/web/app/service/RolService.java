	package com.asturutas.spring.web.app.service;

import java.util.Optional;

import com.asturutas.spring.web.app.entity.RolEntity;

public interface RolService {
	
	Optional<RolEntity> findById(Integer id);

}
