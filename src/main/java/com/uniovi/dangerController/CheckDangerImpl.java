package com.uniovi.dangerController;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.FiltroPropiedades;
import com.uniovi.entities.Incidencia;
import com.uniovi.entities.Operario;
import com.uniovi.services.FilterService;

@Service
public class CheckDangerImpl implements DangerAssigner{

	@Autowired
	private FilterService filterService;
	
	private static final Logger logger = Logger.getLogger(CheckDangerImpl.class);
	
	@Override
	public void checkDanger(Incidencia incidencia, Operario operario) {
		List<FiltroPropiedades> filtros = filterService.findByOperario(operario);
		
		for(FiltroPropiedades filtro : filtros) {
			if(filtro.applicateFilter(incidencia)) {
				logger.info("La incidencia " + incidencia.getId() + " se considera peligrosa por el filtro " + filtro.getId());
			}
		}
	}

}
