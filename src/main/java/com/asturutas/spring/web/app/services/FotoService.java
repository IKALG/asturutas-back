package com.asturutas.spring.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asturutas.spring.web.app.models.Foto;
import com.asturutas.spring.web.app.repositories.FotoRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class FotoService {
	
	@Autowired
	private final FotoRepository fotoRepository;

	public FotoService(FotoRepository fotoRepository) {
		super();
		this.fotoRepository = fotoRepository;
	}


	public List<Foto> obtenerTodasLasFotos() {
		return fotoRepository.findAll();
	}
	
	public void guardarFoto(List<Foto> list) {
		fotoRepository.saveAll(list);
	}
	
	

	@Override
	public String toString() {
		return "FotoService [fotoRepository=" + fotoRepository + "]";
	}
	
	


	
	

}
