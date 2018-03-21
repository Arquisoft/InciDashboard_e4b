package com.uniovi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Operario;

public interface OperarioRepository extends CrudRepository<Operario,Long>{

	List<Operario> findAll();
	Operario findByDni(String dni);
	Operario findById(long id);
	
}
