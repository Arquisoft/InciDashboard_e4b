package com.uniovi.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Notificacion;


public interface NotificacionRepository extends CrudRepository<Notificacion, Long>{

	List<Notificacion> findAll();
	Page<Notificacion> findByOperario(Pageable pageable, Long operario);
	

}
