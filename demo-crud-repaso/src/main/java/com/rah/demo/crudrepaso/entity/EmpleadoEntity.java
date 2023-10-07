package com.rah.demo.crudrepaso.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "empleados")
public class EmpleadoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cargo;
	private LocalDate fechaInicioLaborar;
	private LocalDate fechaFinLaborar;

	@OneToOne(mappedBy = "empleadoEntity", cascade = CascadeType.ALL)
	@JsonManagedReference
	private PersonaEntity personaEntity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public LocalDate getFechaInicioLaborar() {
		return fechaInicioLaborar;
	}

	public void setFechaInicioLaborar(LocalDate fechaInicioLaborar) {
		this.fechaInicioLaborar = fechaInicioLaborar;
	}

	public LocalDate getFechaFinLaborar() {
		return fechaFinLaborar;
	}

	public void setFechaFinLaborar(LocalDate fechaFinLaborar) {
		this.fechaFinLaborar = fechaFinLaborar;
	}

	public PersonaEntity getPersonaEntity() {
		return personaEntity;
	}

	public void setPersonaEntity(PersonaEntity personaEntity) {
		this.personaEntity = personaEntity;
	}

}
