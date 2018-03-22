package com.uniovi.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uniovi.services.IncidenceService;

@Controller
public class MainController {

    private static final Logger logger = Logger.getLogger(MainController.class);
    
    @Autowired
    private IncidenceService incidenceService;

    @RequestMapping("/")
    public String landing(Model model) {
		if( (SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) ) {
			logger.info("El usuario ha sido reenviado al login");
			return "redirect:/login";
		}
		model.addAttribute("incidencias", incidenceService.findAll());
		logger.info("El usuario ha sido reenviado a la vista de incidencias");
		return "/incidencias/all"; //Cambiar por el método del controlador encargado de generar la vista de las incidencias
    }



}