package com.uniovi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uniovi.entities.Incidencia;
import com.uniovi.repositories.IncidenceRepository;

@Controller
public class IncidenciasController {

	@Autowired
	private IncidenceRepository incidenceRepository;

	@RequestMapping("incidencias/location/{id}")
	public String getLocationInci(Model model, @PathVariable Long id) {
		Incidencia incidencia = incidenceRepository.findById(id);
		if (incidencia != null) {
			model.addAttribute("incidencia", incidencia);
			return "incidencias/map";
		}
		return "/";
	}
}
