package com.asturutas.spring.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.asturutas.spring.web.app.models.Ruta;
import com.asturutas.spring.web.app.services.RutaService;

@Controller
public class RutaController {

	@Autowired
	private final RutaService rutaService;
	
	public RutaController(RutaService rutaService) {
		this.rutaService = rutaService;
	}
	
	
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

	
}
