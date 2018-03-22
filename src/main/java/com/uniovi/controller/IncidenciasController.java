package com.uniovi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uniovi.entities.Incidencia;
import com.uniovi.repositories.IncidenceRepository;

@Controller
public class IncidenciasController {

	@Autowired
	private IncidenceRepository incidenceRepository;

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
//		Incidencia incidencia = 
//		Usuario usuario = usersService.getUserById(id);
//		List<Publicacion> publicaciones = postService.getPostFriends(usuario);
//		if(publicaciones == null)
//			model.addAttribute("noAmigo", true);
//		else {
//			model.addAttribute("noAmigo", false);
//		}
//		model.addAttribute("postsList", publicaciones);
//		model.addAttribute("activeUserPublication", false);
//		model.addAttribute("nombreUsuario", usuario.getName());
//		return "publications/list";
		System.err.println(estado);
		return null;
	}
}
