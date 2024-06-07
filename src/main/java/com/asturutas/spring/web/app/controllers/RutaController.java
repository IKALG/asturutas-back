package com.asturutas.spring.web.app.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String findAll(Model model, Principal principal) {
		List<RutaResponseDto> rutas = rutaService.findAll();
	    model.addAttribute("user", principal != null ? principal.getName() : null);
		model.addAttribute("rutas", rutas);
		return "index";
	}
	
	@GetMapping("/mostrar/rutas")
	public String mostrarTodasLasRutas(Model model, Principal principal) {
		List<RutaResponseDto> rutas = rutaService.findAll();
	    model.addAttribute("user", principal != null ? principal.getName() : null);
		model.addAttribute("rutas", rutas);
		return "mostrar-rutas";
	}
	
    @GetMapping("/rutas/{id}")
    public String findById(Model model, @PathVariable Integer id) {
    	RutaResponseDto rutaResponseDto = rutaService.findById(id);
    	model.addAttribute("ruta", rutaResponseDto);
    	return "ruta-individual";
    }


    @GetMapping("/rutas/crear")
    public String create(Model model, Principal principal) {
        model.addAttribute("rutaRequestDto", new RutaRequestDto());
	    model.addAttribute("user", principal != null ? principal.getName() : null);
        model.addAttribute("actividades", actividadService.findAll());
        model.addAttribute("municipios", municipioService.findAll());
        return "añadir-ruta";
    }
    
    @PostMapping("/rutas/guardar")
	public String save(@ModelAttribute RutaRequestDto rutaRequestDto) {
	    rutaService.create(rutaRequestDto);
	    return "redirect:/"; // Redirige a la lista de usuarios si no hay errores
	}
    
    @GetMapping("rutas/editar/{id}")
    public String edit(Model model, @PathVariable Integer id) {
        RutaResponseDto rutaResponseDto = rutaService.findById(id);
        model.addAttribute("ruta", rutaResponseDto);
        model.addAttribute("actividades", actividadService.findAll());
        model.addAttribute("municipios", municipioService.findAll());
    	return "ruta-editar";
    }
    
    @PostMapping("rutas/actualizar/{id}")
    public String update(@PathVariable Integer id, @ModelAttribute RutaRequestDto rutaRequestDto) {
    	rutaService.update(id, rutaRequestDto);
    	return "redirect:/";
    }
    
    @PostMapping("rutas/eliminar/{id}")
    public String delete(@PathVariable Integer id) {
        rutaService.delete(id);
        return "por-usuario";
    }

    @GetMapping("rutas/eliminar/{id}")
    public String confirmDelete(Model model, @PathVariable Integer id) {
        RutaResponseDto rutaResponseDto = rutaService.findById(id);
        model.addAttribute("ruta", rutaResponseDto);
        return "confirmar-eliminacion"; // Página de confirmación de eliminación
    }
    
    
    @GetMapping("/rutas/actividad")
    public String findRutasByActividad(Model model) {
        model.addAttribute("actividades", actividadService.findAll());
        return "filtrar-por-actividad";
    }

    @PostMapping("/rutas/actividad/mostrar")
    public String mostrarRutasByActividad(Model model, @RequestParam String actividad) {
        List<RutaResponseDto> rutaResponseDtoList = rutaService.findRutasByActividad(actividad);
        model.addAttribute("rutasList", rutaResponseDtoList);
        return "por-actividad";
    }
    
    @GetMapping("/rutas/municipio")
    public String findRutasByMunicipio(Model model) {
        model.addAttribute("municipios", municipioService.findAll());
        return "filtrar-por-municipio";
    }

    @PostMapping("/rutas/municipio/mostrar")
    public String mostrarRutasByMunicipio(Model model, @RequestParam String municipio) {
        List<RutaResponseDto> rutaResponseDtoList = rutaService.findRutasByMunicipio(municipio);
        model.addAttribute("rutasList", rutaResponseDtoList);
        return "por-municipio";
    }
    
    @GetMapping("/rutas/usuario")
    public String findRutasByUsuario(Model model, Principal principal) {
	    model.addAttribute("user", principal != null ? principal.getName() : null);
        return "filtrar-por-usuario";
    }
    
    @PostMapping("rutas/usuario/mostrar")
    public String mostrarRutasByUsuario(Model model, @RequestParam String usuario) {
        List<RutaResponseDto> rutaResponseDtoList = rutaService.findRutasByUsuario(usuario);
        model.addAttribute("rutasList", rutaResponseDtoList);
        return "por-usuario";
    }
    
    @GetMapping("rutas/movilidad")
    public String findRutasPorMovilidad(Model model) {
    	List<RutaResponseDto> rutaResponseDtoList = rutaService.findRutasByMovilidad();
    	model.addAttribute("rutasList", rutaResponseDtoList);
    	return "movilidad-reducida";
    }
    
    
    @GetMapping("rutas/perros")
    public String findRutasPorPerros(Model model) {
    	List<RutaResponseDto> rutaResponseDtoList = rutaService.findRutasByPerros();
    	model.addAttribute("rutasList", rutaResponseDtoList);
    	return "para-perros";
    }
    
    @GetMapping("rutas/ninos")
    public String findRutasPorNinos(Model model) {
    	List<RutaResponseDto> rutaResponseDtoList = rutaService.findRutasByNinos();
    	model.addAttribute("rutasList", rutaResponseDtoList);
    	return "para-ninos";
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