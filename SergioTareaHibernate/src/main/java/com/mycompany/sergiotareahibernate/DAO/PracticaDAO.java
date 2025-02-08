/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.sergiotareahibernate.DAO;

import com.mycompany.sergiotareahibernate.entities.Practica;

/**
 *
 * @author Sergio
 */
public interface PracticaDAO extends Repository<Practica>{
    void insertarAlumno(int idAlumno, int idPractica);
}
