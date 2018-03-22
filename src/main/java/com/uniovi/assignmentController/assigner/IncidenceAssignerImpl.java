package com.uniovi.assignmentController.assigner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Incidencia;
import com.uniovi.entities.Operario;
import com.uniovi.services.IncidenceService;
import com.uniovi.services.OperarioService;

@Service
public class IncidenceAssignerImpl implements IncidenceAssigner{

	@Autowired
	private OperarioService operarioService;
	
	@Autowired
	private IncidenceService incidenceService;
	
	@Override
	public void assign(Long id) {
		Operario toAssign = chooseOperario();
		Incidencia incidencia = incidenceService.findById(id);
		incidencia.setOperario(toAssign);
		incidenceService.saveIncidence(incidencia);
	}
	
	private Operario chooseOperario() {
		List<Operario> operarios = operarioService.findAll();
		operarios.sort((o1, o2) -> Integer.compare(o1.getIncidencias().size(), o2.getIncidencias().size()));
		
		if(operarios.size()>0)
			return operarios.get(0);
		
		return null;
	}

}
