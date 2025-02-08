/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sergiotareahibernate.DAO;

import com.mycompany.sergiotareahibernate.entities.Alumno;
import com.mycompany.sergiotareahibernate.entities.AlumnoCandidatoPractica;
import java.util.List;

/**
 *
 * @author Sergio
 */
public interface AlumnoCandidatoPracticaDAO extends Repository<AlumnoCandidatoPractica>{
    List<AlumnoCandidatoPractica> consultarCandidatosPractica(int idPractica);
    void cambiarEstadoCandidato(int idAlumno, int idPractica, String estado);
}
