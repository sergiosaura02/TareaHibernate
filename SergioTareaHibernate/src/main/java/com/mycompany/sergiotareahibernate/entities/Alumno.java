/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sergiotareahibernate.entities;

import java.io.Serializable;
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
@Table(name = "alumno")
public class Alumno implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumno_id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "edad")
    private int edad;
    @Column(name = "titulo")
    private String titulo;

    public Alumno(int id, String nombre, int edad, String titulo) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.titulo = titulo;
    }

    public Alumno(String nombre, int edad, String titulo) {
        this.nombre = nombre;
        this.edad = edad;
        this.titulo = titulo;
    }

    public Alumno() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
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
        final Alumno other = (Alumno) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", titulo=" + titulo + '}';
    }
}
