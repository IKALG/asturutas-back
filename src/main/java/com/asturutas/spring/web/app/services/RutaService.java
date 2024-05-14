package com.asturutas.spring.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asturutas.spring.web.app.models.Ruta;
import com.asturutas.spring.web.app.repositories.RutaRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class RutaService {
	
	@Autowired
	private final RutaRepository rutaRepository;

	
	public RutaService(RutaRepository rutaRepository) {
		super();
		this.rutaRepository = rutaRepository;
	}
	
	public List<Ruta> obtenerTodasLasRutas() {
		return rutaRepository.findAll();
	}
	
	public void guardarRuta(Ruta ruta) {
		rutaRepository.save(ruta);
	}


	public RutaRepository getRutaRepository() {
		return rutaRepository;
	}
}
