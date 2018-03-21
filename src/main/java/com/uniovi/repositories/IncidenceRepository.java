package com.uniovi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Incidencia;
import com.uniovi.entities.Operario;

public interface IncidenceRepository extends CrudRepository<Incidencia, Long>{

	List<Incidencia> findAll();
	List<Incidencia> findByOperario(Operario operario);
	Incidencia findById(Long id);
	
}
