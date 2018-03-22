package com.uniovi.dangerController;

import com.uniovi.entities.Incidencia;
import com.uniovi.entities.Operario;

public interface DangerAssigner {

	void checkDanger(Incidencia incidencia, Operario operario);
	
}
