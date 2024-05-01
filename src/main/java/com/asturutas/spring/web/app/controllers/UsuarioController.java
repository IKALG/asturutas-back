package com.asturutas.spring.web.app.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asturutas.spring.web.app.models.Usuario;
import com.asturutas.spring.web.app.services.UsuarioService;

@Controller
public class UsuarioController {

	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping("/usuarios")
	public String mostrarUsuarios(Model model) {
		List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
		model.addAttribute("usuarios", usuarios);
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
