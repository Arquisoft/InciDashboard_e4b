package com.uniovi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Incidencia;
import com.uniovi.entities.Operario;
import com.uniovi.repositories.OperarioRepository;

@Service
public class OperarioService {

	@Autowired
	private OperarioRepository operarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public List<Operario> findAll(){
		return operarioRepository.findAll();
	}
	
	public Operario findByDni(String dni) {
		return operarioRepository.findByDni(dni);
	}
	
	public Operario findById(long id) {
		return operarioRepository.findById(id);
	}
	
	public void addOperario(Operario operario) {
		operario.setPassword(bCryptPasswordEncoder.encode(operario.getPasswordConfirm()));
		operarioRepository.save(operario);
	}
	
	public void removeOperario(Operario operario) {
		operarioRepository.delete(operario);
	}
	
	public List<Incidencia> getIncidencesByAgent(Operario operario){
		return operario.getIncidencias();
	}
	
}
