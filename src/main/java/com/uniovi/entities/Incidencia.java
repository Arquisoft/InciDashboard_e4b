package com.uniovi.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.uniovi.entities.extras.*;


@Entity
public class Incidencia {
	@Id
	@GeneratedValue
	private Long id;
	
	//Nombre de la incidencia
	private String incidenceName;	
	//Descripción de la incidencia
	private String description;		
	//Localizacion de la incidencia
	private Location location;
	//Etiquetas
	@ElementCollection
	private List<String> tags;
	//Campos de la incidencia
	@ElementCollection
	private Map<String, String> fields;

	//Estado de la incidencia (ABIERTA,	EN PROCESO,	CERRADA, ANULADA)
	private Status status;
	//Comentarios sobre la incidencia
	private String comments;
	//Fecha en la que expira la incidencia
	private Date expirationDate;

	//Operario al cual esta asignada la incidencia
	@ManyToOne
	@JoinColumn(name = "operario")
	private Operario operario;
	
	public Incidencia() {}
	
	public Incidencia(String incidenceName, String descripcion, Location location, 
				List<String> tags, HashMap<String, String> fields, Status status, String comments, Date expirationDate) {
		this.incidenceName = incidenceName;
		this.description = descripcion;
		this.location = location;
		this.tags = tags;
		this.fields = fields;
		this.status = status;
		this.comments = comments;
		this.expirationDate = expirationDate;

	}

	public Incidencia(String incidenceName, String descripcion, Location location, List<String> tags) {
		this.incidenceName = incidenceName;
		this.description = descripcion;
		this.location = location;
		this.tags = tags;
		this.expirationDate = new Date();
	}
	
	public Incidencia(String incidenceName, String description, Location location) {
		this.incidenceName = incidenceName;
		this.description = description;
		this.location = location;
		this.expirationDate = new Date();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIncidenceName() {
		return incidenceName;
	}

	public void setIncidenceName(String incidenceName) {
		this.incidenceName = incidenceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Map<String, String> getFields() {
		return fields;
	}

	public void setFields(Map<String, String> fields) {
		this.fields = fields;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Operario getOperario() {
		return operario;
	}

	public void setOperario(Operario operario) {
		this.operario = operario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Incidencia other = (Incidencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Incidence [incidenceName=" + incidenceName + ", description=" + description + ", location=" + location + 
					", tags=" + tags + ", fields=" + fields + ", comments=" + ", status=" + status
						+ comments + ", expirationDate=" + expirationDate + "]";
	}
}