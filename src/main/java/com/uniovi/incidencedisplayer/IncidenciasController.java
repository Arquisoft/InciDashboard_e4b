package com.uniovi.incidencedisplayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uniovi.entities.Incidencia;
import com.uniovi.incidencecontroller.repositories.IncidenceRepository;
import com.uniovi.incidencecontroller.services.IncidenceService;

/**
 * Controlador encargado de gestionar las direcciones relacionadas con las incidencias.
 */
@Controller
public class IncidenciasController {

	@Autowired
	private IncidenceRepository incidenceRepository;
	
	@Autowired
	private IncidenceService incidenceService;

	@RequestMapping("/incidencias/location/{id}")
	public String getLocationInci(Model model, @PathVariable Long id) {
		Incidencia incidencia = incidenceRepository.findById(id);
		if (incidencia != null) {
			model.addAttribute("incid", incidencia);
			return "incidencias/map";
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/incidence/update", method=RequestMethod.GET)
	public String updateStatus(@RequestParam(defaultValue = "") Long id, 
				@RequestParam(defaultValue = "") String estado) {
		incidenceService.updateStatusIncidence(id, estado);
		return "incidencias/list";
	}
	
	@RequestMapping(value = "/incidencias/all", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("incidencias", incidenceService.findAll());
		return "incidencias/all";
	}
}
