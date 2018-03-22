package com.uniovi.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Operario {

	@Id
	@GeneratedValue
	private long id;
	
	private String nombre;
	
	@Column(unique=true)
	private String dni;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "operario", cascade = CascadeType.ALL)
	private List<Incidencia> incidencias = new ArrayList<>();
	
	private String password;
	@Transient
	private String passwordConfirm;

	public Operario() { }
	
	public Operario(String nombre, String dni) {
		this(nombre, dni, new ArrayList<Incidencia>());
	}
	
	public Operario(String nombre, String dni, List<Incidencia> incidencia) {
		this.nombre = nombre;
		this.dni = dni;
		this.incidencias = incidencia;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public List<Incidencia> getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(List<Incidencia> incidencias) {
		this.incidencias = incidencias;
	}
	
}
