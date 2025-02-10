/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sergiotareahibernate.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Sergio
 */
@Entity
@Table(name = "alumno_candidato_practica")
public class AlumnoCandidatoPractica implements Serializable {
	@EmbeddedId
	private CandidatoID id;
	@ManyToOne
	@JoinColumn(name = "alumno_id", insertable = false, updatable = false)
	private Alumno alumno;
	@ManyToOne
	@JoinColumn(name = "practica_id", insertable = false, updatable = false)
	private Practica practica;
	@Column(name = "fecha_solicitud")
	private LocalDate fechaSolicitud;
	@Column(name = "estado", columnDefinition = "ENUM('Pendiente','Aceptado', 'Rechazado')")
	@Enumerated(EnumType.STRING)
	private Estado estado;

	public AlumnoCandidatoPractica() {
	}

	public AlumnoCandidatoPractica(CandidatoID id, LocalDate fechaSolicitud, Estado estado) {
		this.id = id;
		this.fechaSolicitud = fechaSolicitud;
		this.estado = estado;
	}

	public AlumnoCandidatoPractica(CandidatoID id, LocalDate fechaSolicitud) {
		this.id = id;
		this.fechaSolicitud = fechaSolicitud;
	}

	public CandidatoID getId() {
		return id;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Practica getPractica() {
		return practica;
	}

	public void setPractica(Practica practica) {
		this.practica = practica;
	}

	public LocalDate getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(LocalDate fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 89 * hash + Objects.hashCode(this.id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final AlumnoCandidatoPractica other = (AlumnoCandidatoPractica) obj;
		return Objects.equals(this.id, other.id);
	}

	@Override
	public String toString() {
		return "\n\n***** Candidato con ID de alumno " + id.getAlumnoID() + " *****\n- Alumno ID: " + id.getAlumnoID()
				+ "\n- Practica ID: " + id.getPracticaID() + "\n- Fecha de solicitud: " + fechaSolicitud
				+ "\n- Estado: " + estado + "\n\n";
	}

}
