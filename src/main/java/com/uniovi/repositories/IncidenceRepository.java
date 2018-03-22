package com.uniovi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Incidencia;
import com.uniovi.entities.Operario;
import com.uniovi.entities.extras.Status;

public interface IncidenceRepository extends CrudRepository<Incidencia, Long>{

	List<Incidencia> findAll();
	List<Incidencia> findByOperario(Operario operario);
	Incidencia findById(Long id);
	
	@Query("UPDATE Incidencia SET status=?1 WHERE id=?2")
	void updateIncidenciaStatus(Status nuevoEstado, Long id);
	
}
