package com.asturutas.spring.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asturutas.spring.web.app.models.Municipio;
import com.asturutas.spring.web.app.repositories.MunicipioRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class MunicipioService {
	
	@Autowired
	private final MunicipioRepository municipioRepository;

	public MunicipioService(MunicipioRepository municipioRepository) {
		super();
		this.municipioRepository = municipioRepository;
	}
	
	public List<Municipio> obtenerTodosLosMunicipios() {
		return municipioRepository.findAll();
	}
	
	

}
