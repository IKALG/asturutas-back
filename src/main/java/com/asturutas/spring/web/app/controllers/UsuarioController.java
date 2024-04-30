package com.asturutas.spring.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asturutas.spring.web.app.repositories.UsuarioRepository;

@Controller
public class UsuarioController {

	private final UsuarioRepository usuarioRepository;

	public UsuarioController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/usuarios")
	public String mostrarUsuarios(Model model) {
		model.addAttribute("usuarios", usuarioRepository.findAll());
		return "lista-usuarios";
	}

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("message", "¡Hola desde Spring Boot!");
		return model;
	}

	@GetMapping("/prueba")
	public ModelAndView prueba() {
		ModelAndView model = new ModelAndView();
		model.setViewName("prueba");
		model.addObject("message", "¡Hola desde Spring Boot!");
		return model;
	}

}
