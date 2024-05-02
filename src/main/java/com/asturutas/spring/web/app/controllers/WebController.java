package com.asturutas.spring.web.app.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asturutas.spring.web.app.models.Municipio;
import com.asturutas.spring.web.app.models.Usuario;
import com.asturutas.spring.web.app.services.MunicipioService;
import com.asturutas.spring.web.app.services.UsuarioService;

@Controller
public class WebController {

	private final UsuarioService usuarioService;
	private final MunicipioService municipioService;

	public WebController(UsuarioService usuarioService, MunicipioService municipioService) {
		this.usuarioService = usuarioService;
		this.municipioService = municipioService;
	}
	
	// Rutas prueba BBDD

	@GetMapping("/usuarios")
	public String mostrarUsuarios(Model model) {
		List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
		model.addAttribute("usuarios", usuarios);
		return "lista-usuarios";
	}
	
	@GetMapping("/municipios")
	public String mostrarMunicipios(Model model) {
		List<Municipio> municipios = municipioService.obtenerTodosLosMunicipios();
		model.addAttribute("municipios", municipios);
		return "lista-municipios";
	}
	
	// Rutas página web

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/contacto")
	public String contacto() {
		return "contacto";
	}
	
	@GetMapping("/movilidad-reducida")
	public String movilidadReducida() {
		return "movilidad-reducida";
	}
	
	@GetMapping("/para-perros")
	public String paraPerros() {
		return "para-perros";
	}
	
	@GetMapping("/para-ninos")
	public String paraNinos() {
		return "para-ninos";
	}
	
	@GetMapping("/por-actividad")
	public String porActividad() {
		return "por-actividad";
	}
	
	@GetMapping("/por-municipio")
	public String porMunicipio() {
		return "por-municipio";
	}
	
	@GetMapping("/quienes-somos")
	public String quienesSomos() {
		return "quienes-somos";
	}

	/*
	@GetMapping("/prueba")
	public ModelAndView prueba() {
		ModelAndView model = new ModelAndView();
		model.setViewName("prueba");
		model.addObject("message", "¡Hola desde Spring Boot!");
		return model;
	}
	*/

}
