package com.asturutas.spring.web.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asturutas.spring.web.app.models.Ruta;
import com.asturutas.spring.web.app.repositories.RutaRepository;

@Service
public class RutaService {
	
	private final RutaRepository rutaRepository;

	
	public RutaService(RutaRepository rutaRepository) {
		super();
		this.rutaRepository = rutaRepository;
	}
	
	public List<Ruta> obtenerTodasLasRutas() {
		return rutaRepository.findAll();
	}


	public RutaRepository getRutaRepository() {
		return rutaRepository;
	}
	
	
	
	

}
