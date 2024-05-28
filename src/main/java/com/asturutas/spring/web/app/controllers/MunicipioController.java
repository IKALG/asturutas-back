package com.asturutas.spring.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.asturutas.spring.web.app.dto.municipio.MunicipioResponseDto;
import com.asturutas.spring.web.app.service.MunicipioService;

@Controller
public class MunicipioController {

	@Autowired
	private final MunicipioService municipioService;

	public MunicipioController(MunicipioService municipioService) {
		this.municipioService = municipioService;
	}

	@GetMapping("/municipios")
	public String mostrarMunicipios(Model model) {
		List<MunicipioResponseDto> municipios = municipioService.findAll();
		model.addAttribute("municipios", municipios);
		return "lista-municipios";
	}

}
