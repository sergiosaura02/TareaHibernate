/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sergiotareahibernate.entities;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Sergio
 */
@Entity
@Table(name = "practica")
public class Practica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "practica_id")
    private int id;
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    private Date fechaFin;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToOne
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;
    @OneToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    
    

    public Practica(int id, Date fechaInicio, Date fechaFin, String descripcion, Empresa empresa, Alumno alumno) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.empresa = empresa;
        this.alumno = alumno;
    }

    public Practica(Date fechaInicio, Date fechaFin, String descripcion, Empresa empresa, Alumno alumno) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.empresa = empresa;
        this.alumno = alumno;
    }

    public Practica() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
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
        final Practica other = (Practica) obj;
        return this.id == other.id;
    }
    
    
    @Override
    public String toString() {
        return "\n***** Practica *****" + id + "\n- Fecha de inicio: " + fechaInicio + "\n- Fecha de fin: " + fechaFin + "\n- Descripcion: " + descripcion + "\n- Empresa: " + empresa + "\n- Alumno: " + alumno;
    }
    
}
