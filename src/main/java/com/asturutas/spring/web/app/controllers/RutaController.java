package com.asturutas.spring.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asturutas.spring.web.app.dto.ruta.RutaRequestDto;
import com.asturutas.spring.web.app.dto.ruta.RutaResponseDto;
import com.asturutas.spring.web.app.service.RutaService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Rutas", description = "Api de rutas")
@Controller
@RequestMapping("/rutas")
public class RutaController {

	@Autowired
	private RutaService rutaService;

	@GetMapping("/")
	public String findAll(Model model) {
		List<RutaResponseDto> rutas = rutaService.findAll();
		model.addAttribute("rutas", rutas);
		return "lista-rutas";
	}

	@GetMapping("/crearRuta")
	public String anadirRuta(Model model) {
		model.addAttribute("ruta", new RutaRequestDto()); // Añade una nueva instancia de Ruta al modelo
		return "añadir-ruta"; // Retorna el nombre de la vista que contiene el formulario
	}

	@PostMapping("/guardarRuta")
	public String guardarRuta(@ModelAttribute RutaRequestDto rutaRequestDto) {
		rutaService.create(rutaRequestDto);
		return "redirect:/rutas"; // Cambia "rutas" por la URL de la vista que deseas mostrar después de guardar
									// la ruta
	}

	@GetMapping("/rutas")
	public ModelAndView rutas() {
		ModelAndView model = new ModelAndView();
		List<RutaResponseDto> rutas = rutaService.findAll();
		model.setViewName("lista-rutas");
		model.addObject("rutas", rutas);
		return model;
	}

}