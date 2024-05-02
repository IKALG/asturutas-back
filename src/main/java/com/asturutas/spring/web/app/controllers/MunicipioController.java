package com.asturutas.spring.web.app.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.asturutas.spring.web.app.models.Municipio;
import com.asturutas.spring.web.app.services.MunicipioService;


@Controller
public class MunicipioController {
	
	private final MunicipioService municipioService;

	public MunicipioController(MunicipioService municipioService) {
		super();
		this.municipioService = municipioService;
	}
	
	@GetMapping("/municipios")
	public String mostrarMunicipios(Model model) {
		List<Municipio> municipios = municipioService.obtenerTodosLosMunicipios();
		model.addAttribute("municipios", municipios);
		return "lista-municipios";
	}
	

}
