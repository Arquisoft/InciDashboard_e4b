package com.uniovi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uniovi.entities.Operario;
import com.uniovi.services.OperarioService;

@Controller
public class OperarioController {
	
	@Autowired
	private OperarioService operarioService;
    
    @RequestMapping(value="incidencias/list")
    public String getIncidencesList(Model model) {
	    	UserDetails logged = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    	Operario operario = operarioService.findByDni(logged.getUsername());    	
	    	model.addAttribute("incidencias", operario.getIncidencias());   	
		return "incidencias/list";
    }
}
