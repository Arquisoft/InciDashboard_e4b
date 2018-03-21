package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Incidencia;
import com.uniovi.entities.Operario;
import com.uniovi.entities.extras.Location;

/**
 * Servicio encargado de insertar unos datos iniciales en la base de datos.
 * @author Alejandro García Parrondo
 */
@Service
public class IncludeDataService {

	@Autowired
	private OperarioService operarioService;
	
	@Autowired
	private IncidenceService incidenceService;
	
	@PostConstruct
	public void init() {
		Operario operario1 = new Operario("Jose","000000Z");
		operario1.setPassword("123456");
		operario1.setPasswordConfirm("123456");
		
		Operario operario2 = new Operario("Jose","111111Z");
		operario2.setPassword("123456");
		operario2.setPasswordConfirm("123456");
		
		List<Incidencia> incidencias = new ArrayList<Incidencia>();
		for(int i=0;i<20;i++)
			incidencias.add(new Incidencia("Incidencia " + i,"Incidencia de prueba " + i, new Location(i,i)));
		
		operarioService.addOperario(operario1);
		operarioService.addOperario(operario2);
		
		incidencias.forEach(i -> incidenceService.saveIncidence(i));
	}
	
	
}
