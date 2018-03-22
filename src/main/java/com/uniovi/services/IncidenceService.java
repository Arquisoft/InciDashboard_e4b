package com.uniovi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Incidencia;
import com.uniovi.entities.Operario;
import com.uniovi.entities.extras.Status;
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
	
	public void updateStatusIncidence(Long id, String estado) {
		if("abierta".equals(estado))
			incidenceRepository.updateIncidenciaStatus(Status.ABIERTA, id);
		else if("enProceso".equals(estado))
			incidenceRepository.updateIncidenciaStatus(Status.EN_PROCESO, id);
		else if("cerrada".equals(estado))
			incidenceRepository.updateIncidenciaStatus(Status.CERRADA, id);
		else if("anulada".equals(estado))
			incidenceRepository.updateIncidenciaStatus(Status.ANULADA, id);
	}
	
}
