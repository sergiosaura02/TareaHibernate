/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sergiotareahibernate.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Sergio
 */
@Entity
@Table(name = "alumno_candidato_practica")
public class AlumnoCandidatoPractica implements Serializable{
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
    @Column(name = "estado")
    private Estado estado;

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
        hash = 53 * hash + Objects.hashCode(this.id);
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
        return "\n***** Candidatura con ID de alumno *****" + alumno.getId() + "\n- ID Alumno: " + alumno.getId() + "\n- ID Practica: " + practica.getId() + "\n- Fecha de solicitud: " + fechaSolicitud + "\n- Estado: " + estado;
    }
    
    
    
}
