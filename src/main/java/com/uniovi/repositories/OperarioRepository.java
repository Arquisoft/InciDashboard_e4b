package com.uniovi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Operario;

public interface OperarioRepository extends CrudRepository<Operario,Long>{

	Operario findByDni(String dni);
	Operario findById(long id);
	
}
