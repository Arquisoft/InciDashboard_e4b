package com.uniovi.controller;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uniovi.Application;
import com.uniovi.entities.Notificacion;
import com.uniovi.entities.Operario;
import com.uniovi.services.NotificacionService;
import com.uniovi.services.OperarioService;

public class NotificacionController {
	static Logger log = LoggerFactory.getLogger(Application.class);
	
	
	@Autowired
	private NotificacionService ns;
	
	@Autowired
	private OperarioService os;

	/**
	 * Metodo que muestra las notificaciones de un operario 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/notificaciones/list")
	public String getInvitations(Model model, Pageable pageable) {
		Page<Notificacion> notificaciones = new PageImpl<Notificacion>(new LinkedList<Notificacion>());
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String dni = auth.getName();
		Operario operario = os.findByDni(dni);

		notificaciones = ns.getNotificacionPorOperario(pageable, operario.getId());
		
	
	
		model.addAttribute("page", notificaciones);
		model.addAttribute("notificacionList", notificaciones.getContent());

		log.info("Listando notificaciones de:"+ operario.getNombre());
		return "/notificaciones/list";
	}
}
