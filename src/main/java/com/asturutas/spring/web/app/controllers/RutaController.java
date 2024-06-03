package com.asturutas.spring.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asturutas.spring.web.app.dto.ruta.RutaRequestDto;
import com.asturutas.spring.web.app.dto.ruta.RutaResponseDto;
import com.asturutas.spring.web.app.service.ActividadService;
import com.asturutas.spring.web.app.service.MunicipioService;
import com.asturutas.spring.web.app.service.RutaService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Rutas", description = "Api de rutas")
@Controller
public class RutaController {

	@Autowired
	private RutaService rutaService;
	
	@Autowired
	private MunicipioService municipioService;
	
	@Autowired
	private ActividadService actividadService;

	@GetMapping("/")
	public String findAll(Model model) {
		List<RutaResponseDto> rutas = rutaService.findAll();
		model.addAttribute("rutas", rutas);
		return "index";
	}


    @GetMapping("/rutas/crear")
    public String create(Model model) {
        model.addAttribute("rutaRequestDto", new RutaRequestDto());
        model.addAttribute("actividades", actividadService.findAll());
        model.addAttribute("municipios", municipioService.findAll());
        return "añadir-ruta";
    }
    
    @PostMapping("/rutas/guardar")
	public String save(@ModelAttribute RutaRequestDto rutaRequestDto) {
	    rutaService.create(rutaRequestDto);
	    return "redirect:/rutas/"; // Redirige a la lista de usuarios si no hay errores
	}
    
    @GetMapping("/rutas/{id}")
    public String findById(Model model, @PathVariable Integer id) {
    	RutaResponseDto rutaResponseDto = rutaService.findById(id);
    	model.addAttribute("ruta", rutaResponseDto);
    	return "ruta-individual";
    }
    
    
//	@GetMapping("/rutas")
//	public ModelAndView rutas() {
//		ModelAndView model = new ModelAndView();
//		List<RutaResponseDto> rutas = rutaService.findAll();
//		model.setViewName("lista-rutas");
//		model.addObject("rutas", rutas);
//		return model;
//	}

}