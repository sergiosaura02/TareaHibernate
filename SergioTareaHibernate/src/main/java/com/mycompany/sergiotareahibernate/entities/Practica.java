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
    private Empresa empresa;
    private Alumno alumno;
}
