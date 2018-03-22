package com.uniovi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.uniovi.entities.FiltroPropiedades;
import com.uniovi.entities.Operario;
import com.uniovi.repositories.FilterRepository;

@Service
public class FilterService {

	@Autowired
	private FilterRepository filterRepository;
	
	@Autowired
	private OperarioService operarioService;
	
	public List<FiltroPropiedades> findAll(){
		return filterRepository.findAll();
	}
	
	public List<FiltroPropiedades> findByOperario(Operario operario){
		return filterRepository.findByOperario(operario);
	}
	
	public List<FiltroPropiedades> findByLogged(){
		UserDetails logged = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Operario operario = operarioService.findByDni(logged.getUsername()); 
    	return findByOperario(operario);
	}
	
	public FiltroPropiedades findById(Long id) {
		return filterRepository.findById(id);
	}
	
	public void addFilter(FiltroPropiedades filtro) {
		UserDetails logged = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Operario operario = operarioService.findByDni(logged.getUsername()); 
		filtro.setOperario(operario);
		filterRepository.save(filtro);
	}
	
	public void removeFilter(FiltroPropiedades filtro) {
		filterRepository.delete(filtro);
	}
	
}
