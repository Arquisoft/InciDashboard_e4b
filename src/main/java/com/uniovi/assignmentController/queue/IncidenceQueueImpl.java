package com.uniovi.assignmentController.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.assignmentController.assigner.IncidenceAssigner;

@Service
public class IncidenceQueueImpl implements IncidenceQueue{
	
	@Autowired
	private IncidenceAssigner incidenceAssigner;
	
	@Override
	public void addIncidence(String incidenceText) {
		Long incidenceId = Long.valueOf(incidenceText);
		incidenceAssigner.assign(incidenceId);
	}

}
