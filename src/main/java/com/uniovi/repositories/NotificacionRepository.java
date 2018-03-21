package com.uniovi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Notificacion;


public interface NotificacionRepository extends CrudRepository<Notificacion, Long>{

	List<Notificacion> findAll();
	List<Notificacion> findByOperario(Long operario);
	

}
