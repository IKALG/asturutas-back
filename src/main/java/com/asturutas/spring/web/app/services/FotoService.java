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
	
	public void guardarFoto(Foto foto) {
		fotoRepository.save(foto);
	}

	@Override
	public String toString() {
		return "FotoService [fotoRepository=" + fotoRepository + "]";
	}
	
	


	
	

}
