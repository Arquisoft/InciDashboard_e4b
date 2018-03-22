package com.uniovi.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.uniovi.entities.extras.*;


@Entity
public class Incidencia {
	//Numero de identificacion de la incidencia
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
	@Enumerated(EnumType.STRING)
	private Status status = Status.ABIERTA;
	//Comentarios sobre la incidencia
	private String comments;
	//Fecha en la que expira la incidencia
	private Date expirationDate;

	//Operario al cual esta asignada la incidencia
	@ManyToOne
	@JoinColumn(name = "operario")
	private Operario operario;
	
	/**
	 * Constructor vacio
	 */
	public Incidencia() {}
	
	/**
	 * Constructor con todos los atributos pasados por parametro
	 * @param incidenceName, nombre de incidencia
	 * @param descripcion, descripcion de la incidencia
	 * @param location, localizacion de la incidencia
	 * @param tags, etiquetas
	 * @param fields, campos
	 * @param status, estado de la incidencia
	 * @param comments, comentarios adicionales
	 * @param expirationDate, fecha de expiracion
	 */
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

	/**
	 * Resto de constructores
	 */
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

	/**
	 * Devuelve el numero de identificacion
	 * @return id, identificacion
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Asigna el numero de identificacion
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Devuelve el nombre de la incidencia
	 * @return incidenceName
	 */
	public String getIncidenceName() {
		return incidenceName;
	}

	/**
	 * Asigna el nombre de la incidencia
	 * @param incidenceName
	 */
	public void setIncidenceName(String incidenceName) {
		this.incidenceName = incidenceName;
	}

	/**
	 * Devuelve la descripcion de la incidencia
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Asigna una descripcion a la incidencia
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Devuelve la localizacion de la incidencia
	 * @return location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * Asigna una localizacion a la incidencia
	 * @param location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}

	/**
	 * Devuelve una lista de etiquetas que contiene la incidencia
	 * @return tags
	 */
	public List<String> getTags() {
		return tags;
	}

	/**
	 * Asigna la lista de etiquetas
	 * @param tags
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	/**
	 * Devuelve los campos de la incidencia
	 * @return
	 */
	public Map<String, String> getFields() {
		return fields;
	}

	/**
	 * Asigna los campos de la incidencia
	 * @param fields
	 */
	public void setFields(Map<String, String> fields) {
		this.fields = fields;
	}

	/**
	 * Devuelve el estado de la incidencia
	 * @return
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Asigna el estado de la incidencia
	 * (Se usa el enum 'Status'= { ABIERTA, EN_PROCESO, CERRADA, ANULADA }
	 * @param status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * Devuelve los comentarios de la incidencia
	 * @return comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * Asigna una cadena con los comentarios de la incidencia
	 * @param comments
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * Devuelve la fecha de expiracion de la incidencia
	 * @return expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * Asigna la fecha de expiracion de la incidencia
	 * @param expirationDate
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * Devuelve el operario asignado a la incidencia
	 * @return
	 */
	public Operario getOperario() {
		return operario;
	}

	/**
	 * Cambia al operario encargado de la incidencia
	 * @param operario
	 */
	public void setOperario(Operario operario) {
		this.operario = operario;
	}
	
	public boolean statusIs(String estado) {
		if(status.equals(Status.ABIERTA) && estado.equals("ABIERTA"))
			return true;
		if(status.equals(Status.CERRADA) && estado.equals("CERRADA"))
			return true;
		if(status.equals(Status.EN_PROCESO) && estado.equals("EN_PROCESO"))
			return true;
		if(status.equals(Status.ANULADA) && estado.equals("ANULADA"))
			return true;
		else return false;
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
		return "Incidence [incidenceName= " + incidenceName + ", description= " + description + 
				", location= " + location + ", tags= " + tags + ", fields= " + fields + 
					", comments= " + comments  + ", status= " + status + 
						", expirationDate= " + expirationDate + "]";
	}
}