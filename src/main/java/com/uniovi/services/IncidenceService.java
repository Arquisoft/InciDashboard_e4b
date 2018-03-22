package com.uniovi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Incidencia;
import com.uniovi.entities.Operario;
import com.uniovi.repositories.IncidenceRepository;

@Service
public class IncidenceService {

	@Autowired
	private IncidenceRepository incidenceRepository;

	
	public List<Incidencia> findAll(){
		return incidenceRepository.findAll();
	}
	
	public List<Incidencia> findByOperario(Operario operario){
		return incidenceRepository.findByOperario(operario);
	}
	
	public Incidencia findById(Long id) {
		return incidenceRepository.findById(id);
	}
	
	public void saveIncidence(Incidencia incidencia) {
		incidenceRepository.save(incidencia);
	}
	
	public void removeIncidence(Incidencia incidencia) {
		incidenceRepository.delete(incidencia);
	}
	
}
