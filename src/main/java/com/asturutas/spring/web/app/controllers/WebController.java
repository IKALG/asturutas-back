package com.asturutas.spring.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	public WebController() {
	}

//	@GetMapping("/rutas")
//	public String mostrarRutas(Model model) {
//		List<Ruta> rutas = rutaService.obtenerTodasLasRutas();
//		model.addAttribute("rutas", rutas);
//		return "lista-rutas";
//	}

	// Rutas página web

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
	 * @GetMapping("/prueba") public ModelAndView prueba() { ModelAndView model =
	 * new ModelAndView(); model.setViewName("prueba"); model.addObject("message",
	 * "¡Hola desde Spring Boot!"); return model; }
	 */

}
