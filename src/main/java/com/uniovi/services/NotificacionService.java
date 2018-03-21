package com.uniovi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.uniovi.entities.Notificacion;
import com.uniovi.repositories.NotificacionRepository;

public class NotificacionService {
	
	@Autowired
	private NotificacionRepository nr;
	
	public void addNotificacion(Notificacion notificacion) {
		nr.save(notificacion);
	}
	
	public List<Notificacion> getAllNotificacion(){
		return nr.findAll();
	}
	
	public List<Notificacion> getNotificacionPorOperario(Long id){
		return nr.findByOperario(id);
	}

}
