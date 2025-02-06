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
    @Column(name = "empresa_id")
    private int empresaID;

    public CandidatoID() {
    }

    public CandidatoID(int alumnoID, int empresaID) {
        this.alumnoID = alumnoID;
        this.empresaID = empresaID;
    }
}
