package com.uniovi.entities;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class OperarioTest {

	@Test
	public void idEqualsTest() {
		Operario operario1 = new Operario();
		operario1.setId(1);

		Operario operario2 = new Operario();
		operario2.setId(1);

		assertEquals(operario1.getId(), operario2.getId());
	}

	@Test
	public void idDifferentTest() {
		Operario operario1 = new Operario();
		operario1.setId(1);

		Operario operario2 = new Operario();
		operario2.setId(2);

		assertNotEquals(operario1.getId(), operario2.getId());
	}

	@Test
	public void nameEqualsTest() {
		Operario operario1 = new Operario();
		operario1.setNombre("Operario");

		Operario operario2 = new Operario();
		operario2.setNombre("Operario");

		assertEquals(operario1.getNombre(), operario2.getNombre());
	}

	@Test
	public void nameDifferentTest() {
		Operario operario1 = new Operario();
		operario1.setNombre("Operario");

		Operario operario2 = new Operario();
		operario2.setNombre("OtroOperario");

		assertNotEquals(operario1.getNombre(), operario2.getNombre());
	}

	@Test
	public void dniEqualsTest() {
		Operario operario1 = new Operario();
		operario1.setDni("00000Z");

		Operario operario2 = new Operario();
		operario2.setDni("00000Z");

		assertEquals(operario1.getDni(), operario2.getDni());
	}

	@Test
	public void dniDifferentTest() {
		Operario operario1 = new Operario();
		operario1.setDni("00000Z");

		Operario operario2 = new Operario();
		operario2.setDni("11111Z");

		assertNotEquals(operario1.getDni(), operario2.getDni());
	}

	@Test
	public void incidenceEqualsTest() {
		Operario operario1 = new Operario();
		Incidencia test = new Incidencia();
		test.setId(1L);

		operario1.setIncidencias(new ArrayList<Incidencia>() {
			private static final long serialVersionUID = 1L;
			{
				add(test);
			}
		});

		Operario operario2 = new Operario();
		operario2.setIncidencias(new ArrayList<Incidencia>() {
			private static final long serialVersionUID = 1L;
			{
				add(test);
			}
		});

		assertEquals(operario1.getIncidencias(), operario2.getIncidencias());
	}

	@Test
	public void incidenceDifferentTest() {
		Operario operario1 = new Operario();
		Incidencia incidencia1 = new Incidencia();
		incidencia1.setId(1L);

		Incidencia incidencia2 = new Incidencia();
		incidencia2.setId(2L);

		operario1.setIncidencias(new ArrayList<Incidencia>() {
			private static final long serialVersionUID = 1L;
			{
				add(incidencia1);
			}
		});

		Operario operario2 = new Operario();
		operario2.setIncidencias(new ArrayList<Incidencia>() {
			private static final long serialVersionUID = 1L;
			{
				add(incidencia2);
			}
		});

		operario1.getIncidencias().stream()
		.forEach( i1 -> operario2.getIncidencias().stream()
				.forEach( i2 -> assertNotEquals(i1,i2)) );
	}

	@Test
	public void passwordEqualsTest() {
		Operario operario1 = new Operario();
		operario1.setPassword("password");

		Operario operario2 = new Operario();
		operario2.setPassword("password");


		assertEquals(operario1.getPassword(), operario2.getPassword());
	}

	@Test
	public void passwordDifferentTest() {
		Operario operario1 = new Operario();
		operario1.setPassword("password");

		Operario operario2 = new Operario();
		operario2.setPassword("password2");


		assertNotEquals(operario1.getPassword(), operario2.getPassword());
	}


	@Test
	public void notificationsEqualsTest() {
		Notificacion notificacion = new Notificacion();
		notificacion.setId(1L);

		Operario operario1 = new Operario();
		operario1.setNotificaciones(new ArrayList<Notificacion>(){
			private static final long serialVersionUID = 1L;
			{
				add(notificacion);
			}
		});

		Operario operario2 = new Operario();
		operario2.setNotificaciones(new ArrayList<Notificacion>(){
			private static final long serialVersionUID = 1L;
			{
				add(notificacion);
			}
		});

		operario1.getNotificaciones().stream()
		.forEach(n1 -> operario2.getNotificaciones().stream()
		.forEach(n2 -> assertEquals(n1,n2)));
	}

	@Test
	public void notificationsDifferentTest() {
		Notificacion notificacion1 = new Notificacion();
		notificacion1.setId(1L);
		
		Notificacion notificacion2 = new Notificacion();
		notificacion1.setId(2L);

		Operario operario1 = new Operario();
		operario1.setNotificaciones(new ArrayList<Notificacion>(){
			private static final long serialVersionUID = 1L;
			{
				add(notificacion1);
			}
		});

		Operario operario2 = new Operario();
		operario2.setNotificaciones(new ArrayList<Notificacion>(){
			private static final long serialVersionUID = 1L;
			{
				add(notificacion2);
			}
		});

		operario1.getNotificaciones().stream()
		.forEach(n1 -> operario2.getNotificaciones().stream()
		.forEach(n2 -> assertNotEquals(n1,n2)));
	}
	
}
