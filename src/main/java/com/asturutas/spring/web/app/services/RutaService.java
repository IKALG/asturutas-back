package com.asturutas.spring.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asturutas.spring.web.app.models.Foto;
import com.asturutas.spring.web.app.models.Ruta;
import com.asturutas.spring.web.app.repositories.FotoRepository;
import com.asturutas.spring.web.app.repositories.RutaRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class RutaService {
	
	@Autowired
	private final RutaRepository rutaRepository;
	
    @Autowired
    private final FotoRepository fotoRepository;

	public RutaService(RutaRepository rutaRepository, FotoRepository fotoRepository) {
		super();
		this.rutaRepository = rutaRepository;
		this.fotoRepository = fotoRepository;
	}
	
	public List<Ruta> obtenerTodasLasRutas() {
		return rutaRepository.findAll();
	}
	
	public void guardarRuta(Ruta ruta) {
		rutaRepository.save(ruta);
	}
	
	public void guardarRutaConFotos(Ruta ruta, List<Foto> fotos) {
        // Guarda la ruta primero para obtener su ID
        rutaRepository.save(ruta);
        
        // Asocia cada foto con la ruta
        for (Foto foto : fotos) {
            foto.setRuta(ruta);
            fotoRepository.save(foto);
        }
    }


	public RutaRepository getRutaRepository() {
		return rutaRepository;
	}
}
