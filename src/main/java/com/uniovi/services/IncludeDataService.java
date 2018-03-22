package com.uniovi.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.assignmentController.assigner.IncidenceAssignerImpl;
import com.uniovi.entities.Incidencia;
import com.uniovi.entities.Notificacion;
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
	
	@Autowired
	private IncidenceAssignerImpl asignadorIncidencias;
	
	@Autowired 
	private NotificacionService notificacionService;
	
	@PostConstruct
	public void init() {
		Operario operario1 = new Operario("Jose","000000Z");
		operario1.setPassword("123456");
		operario1.setPasswordConfirm("123456");
		
		Operario operario2 = new Operario("Jose","111111Z");
		operario2.setPassword("123456");
		operario2.setPasswordConfirm("123456");
		
		operarioService.addOperario(operario1);
		operarioService.addOperario(operario2);
		
		
		
		for(int i=0;i<20;i++) {
			Incidencia incidencia = new Incidencia("Incidencia " + i,"Incidencia de prueba " + i, new Location(i,i));
			incidenceService.saveIncidence(incidencia);
			asignadorIncidencias.assign(incidencia.getId());
		}

		
	}
	
	
}
