package com.uniovi.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Operario;

/**
 * Servicio encargado de insertar unos datos iniciales en la base de datos.
 * @author Alejandro García Parrondo
 */
@Service
public class IncludeDataService {

	@Autowired
	private OperarioService operarioService;
	
	@PostConstruct
	public void init() {
		Operario operario = new Operario("Jose","512341Z");
		operario.setPassword("123456");
		operario.setPasswordConfirm("123456");
		
		operarioService.addOperario(operario);
	}
	
	
}
