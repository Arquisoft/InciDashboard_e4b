package com.uniovi.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Incidencia {
	@Id
	@GeneratedValue
	private Long id;

	private String user;
	private String password;
	
	private String incidenceName;
	private String description;
	
	private String location;
	@ElementCollection
	private List<String> tags;
	@ElementCollection
	private Map<String, String> fields;

	
	private String status;
	private String comments;
	private Date expirationDate;

	
	/**
	 * Constructor vacio
	 */
	public Incidencia() {
	}
	
	/**
	 * Constructor con todos los parametros
	 * 
	 */
	public Incidencia(Long id, String user, String password, String incidenceName, String descripcion, String localization,
			 List<String> tags, HashMap<String, String> fields, String status, String comments, Date expirationDate) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
		this.incidenceName = incidenceName;
		this.description = descripcion;
		this.location = localization;
		this.tags = tags;
		this.fields = fields;
		this.status = status;
		this.comments = comments;
		this.expirationDate = expirationDate;

	}

	/**
	 * Constructor base
	 * 
	 * @param id
	 * @param user
	 * @param password
	 * @param incidenceName
	 * @param description
	 * @param localization
	 * @param tags
	 */

	public Incidencia(Long id, String user, String password, String incidenceName, String descripcion,
			String localization, List<String> tags) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
		this.incidenceName = incidenceName;
		this.description = descripcion;
		this.location = localization;
		this.tags = tags;

	}

	public Long getId() {
		return id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIncidenceName() {
		return incidenceName;
	}

	public void setIncidenceName(String incidenceName) {
		this.incidenceName = incidenceName;
	}

	public String getDescripcion() {
		return description;
	}

	public void setDescripcion(String descripcion) {
		this.description = descripcion;
	}

	public String getLocation() {
		return location;
	}

	public void setLocalization(String localizacion) {
		this.location = localizacion;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Map<String, String> getCampos() {
		return fields;
	}

	public void setCampos(HashMap<String, String> campos) {
		this.fields = campos;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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