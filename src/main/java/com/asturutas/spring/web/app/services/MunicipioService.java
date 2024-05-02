package com.asturutas.spring.web.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asturutas.spring.web.app.models.Municipio;
import com.asturutas.spring.web.app.repositories.MunicipioRepository;

@Service
public class MunicipioService {
	
	private final MunicipioRepository municipioRepository;

	public MunicipioService(MunicipioRepository municipioRepository) {
		super();
		this.municipioRepository = municipioRepository;
	}
	
	public List<Municipio> obtenerTodosLosMunicipios() {
		return municipioRepository.findAll();
	}
	
	

}
