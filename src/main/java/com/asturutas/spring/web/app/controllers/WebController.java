package com.asturutas.spring.web.app.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asturutas.spring.web.app.models.Municipio;
import com.asturutas.spring.web.app.models.Ruta;
import com.asturutas.spring.web.app.models.Usuario;
import com.asturutas.spring.web.app.services.MunicipioService;
import com.asturutas.spring.web.app.services.RutaService;
import com.asturutas.spring.web.app.services.UsuarioService;

@Controller
public class WebController {

	private final UsuarioService usuarioService;
	private final MunicipioService municipioService;
	private final RutaService rutaService;

	public WebController(UsuarioService usuarioService, MunicipioService municipioService, RutaService rutaService) {
		this.usuarioService = usuarioService;
		this.municipioService = municipioService;
		this.rutaService = rutaService;
	}
	
	// Rutas de prueba BBDD

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
	
//	@GetMapping("/rutas")
//	public String mostrarRutas(Model model) {
//		List<Ruta> rutas = rutaService.obtenerTodasLasRutas();
//		model.addAttribute("rutas", rutas);
//		return "lista-rutas";
//	}
	
	@GetMapping("/crearRuta")
	public String anadirRuta(Model model) {
        model.addAttribute("ruta", new Ruta()); // Añade una nueva instancia de Ruta al modelo
        return "añadir-ruta"; // Retorna el nombre de la vista que contiene el formulario
    }
	
	@PostMapping("/guardarRuta")
    public String guardarRuta(@ModelAttribute Ruta ruta) {
//		System.out.println(ruta);
        // Simplemente llamamos al método del servicio para guardar la ruta
        rutaService.guardarRuta(ruta);
        // Redireccionar a alguna vista después de guardar la ruta
        return "redirect:/rutas"; // Cambia "rutaGuardada" por la URL de la vista que deseas mostrar después de guardar la ruta
    }
	
	@GetMapping("/rutas")
	public ModelAndView rutas() {
		ModelAndView model = new ModelAndView();
		List<Ruta> rutas = rutaService.obtenerTodasLasRutas();
		model.setViewName("lista-rutas");
		model.addObject("rutas",rutas);
		return model;
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
