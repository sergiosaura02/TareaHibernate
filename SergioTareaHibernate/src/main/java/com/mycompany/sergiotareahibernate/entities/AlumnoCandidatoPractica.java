/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sergiotareahibernate.entities;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Sergio
 */
@Entity
@Table(name = "alumno_candidato_practica")
public class AlumnoCandidatoPractica {
    @Id
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;
    @Id
    private Practica practica;
    @Column(name = "fecha_solicitud")
    private Date fechaSolicitud;
    @Column(name = "estado")
    private Estado estado;

    public AlumnoCandidatoPractica(Alumno alumno, Practica practica, Date fechaSolicitud, Estado estado) {
        this.alumno = alumno;
        this.practica = practica;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
    }

    public AlumnoCandidatoPractica(Practica practica, Date fechaSolicitud, Estado estado) {
        this.practica = practica;
        this.fechaSolicitud = fechaSolicitud;
        this.estado = estado;
    }

    public AlumnoCandidatoPractica() {
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

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
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
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.alumno);
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
        return Objects.equals(this.alumno, other.alumno);
    }

    

    @Override
    public String toString() {
        return "\n***** AlumnoCandidatoPractica  con ID de alumno *****" + alumno.getId() + "\n- ID Alumno: " + alumno.getId() + "\n- ID Practica: " + practica.getId() + "\n- Fecha de solicitud: " + fechaSolicitud + "\n- Estado: " + estado;
    }
    
    
    
}
