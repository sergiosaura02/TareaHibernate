/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sergiotareahibernate.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Sergio
 */
@Embeddable
public class CandidatoID implements Serializable {
    @Column(name = "alumno_id")
    private int alumnoID;
    @Column(name = "practica_id")
    private int practicaID;
    public CandidatoID() {
    }

    public CandidatoID(int alumnoID, int practicaID) {
        this.alumnoID = alumnoID;
        this.practicaID = practicaID;
    }

    public int getAlumnoID() {
        return alumnoID;
    }

    public int getPracticaID() {
        return practicaID;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.alumnoID;
        hash = 73 * hash + this.practicaID;
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
        final CandidatoID other = (CandidatoID) obj;
        if (this.alumnoID != other.alumnoID) {
            return false;
        }
        return this.practicaID == other.practicaID;
    }
    
}
