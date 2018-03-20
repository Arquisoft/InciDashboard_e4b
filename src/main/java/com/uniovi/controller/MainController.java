package com.uniovi.controller;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private static final Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping("/")
    public String landing() {
		if( (SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) ) {
			logger.info("El usuario ha sido reenviado al login");
			return "redirect:/login";
		}
		
		logger.info("El usuario ha sido reenviado a la vista de incidencias");
		return "index"; //Cambiar por el método del controlador encargado de generar la vista de las incidencias
    }



}