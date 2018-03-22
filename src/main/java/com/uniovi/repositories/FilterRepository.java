package com.uniovi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.FiltroPropiedades;
import com.uniovi.entities.Operario;

public interface FilterRepository extends CrudRepository<FiltroPropiedades,Long>{

	List<FiltroPropiedades> findAll();
	List<FiltroPropiedades> findByOperario(Operario operario);
	FiltroPropiedades findById(Long id);
	
}
