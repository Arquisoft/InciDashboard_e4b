package com.uniovi.entities;

import java.util.function.Predicate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class FiltroPropiedades {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String fieldName;
	private String value;
	private int operation;
	
	@ManyToOne
	@JoinColumn(name = "operario")
	private Operario operario;
	
	@Transient
	public final static int COMPARACION_IGUALDAD = 0;
	@Transient
	public final static int COMPARACION_DISTINTOS = 1;
	@Transient
	public final static int COMPARACION_MAYOR = 2;
	@Transient
	public final static int COMPARACION_MENOR = 3;
	
	@Transient
	private Predicate<Incidencia>[] aplicacionFiltro;
	
	public FiltroPropiedades() {}
	
	public FiltroPropiedades(String fieldName, String value, int operation) {
		this.fieldName = fieldName;
		this.value = value;
		this.operation = operation;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public Operario getOperario() {
		return operario;
	}

	public void setOperario(Operario operario) {
		this.operario = operario;
	}

	@SuppressWarnings("unchecked")
	private void createFilter() {
		aplicacionFiltro = (Predicate<Incidencia>[])new Predicate[4];
		aplicacionFiltro[0] = i -> i.getFields().get(fieldName).toUpperCase().equals(value.toUpperCase());
		aplicacionFiltro[1] = i -> !i.getFields().get(fieldName).toUpperCase().equals(value.toUpperCase());
		aplicacionFiltro[2] = i -> Double.parseDouble(i.getFields().get(fieldName)) > Double.parseDouble(value);
		aplicacionFiltro[3] = i -> Double.parseDouble(i.getFields().get(fieldName)) < Double.parseDouble(value);
	}
	
	public boolean applicateFilter(Incidencia incidencia) {
		createFilter();
		return aplicacionFiltro[operation].test(incidencia);
	}
	
}
