package com.uniovi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Notificacion;
import com.uniovi.repositories.NotificacionRepository;

@Service
public class NotificacionService {
	
	@Autowired
	private NotificacionRepository nr;
	
	public void addNotificacion(Notificacion notificacion) {
		nr.save(notificacion);
	}
	
	public List<Notificacion> getAllNotificacion(){
		return nr.findAll();
	}
	
	public Page<Notificacion> getNotificacionPorOperario(Pageable pageable, Long id){
		Page<Notificacion> notificacion = nr.findByOperario(pageable,id);
		return notificacion;
	}

}
