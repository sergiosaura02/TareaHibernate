/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sergiotareahibernate.DAO;

import com.mycompany.sergiotareahibernate.entities.Alumno;
import com.mycompany.sergiotareahibernate.entities.Empresa;
import com.mycompany.sergiotareahibernate.entities.Practica;
import com.mycompany.sergiotareahibernate.utilities.HibernateUtil;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import org.hibernate.query.Query;

/**
 *
 * @author Sergio
 */
public class PracticaDAOImpl implements PracticaDAO {

    @Override
    public void update(Practica t) {
        HibernateUtil.getCurrentSession().beginTransaction();
        HibernateUtil.getCurrentSession().clear();
        HibernateUtil.getCurrentSession().update(t);
        HibernateUtil.getCurrentSession().getTransaction().commit();
    }

    @Override
    public void delete(Practica t) {
        HibernateUtil.getCurrentSession().beginTransaction();
        HibernateUtil.getCurrentSession().clear();
        HibernateUtil.getCurrentSession().delete(t);
        HibernateUtil.getCurrentSession().getTransaction().commit();
    }

    @Override
    public void save(Practica t) {
        try {
            HibernateUtil.getCurrentSession().beginTransaction();
            HibernateUtil.getCurrentSession().clear();
            HibernateUtil.getCurrentSession().save(t);
            HibernateUtil.getCurrentSession().getTransaction().commit();
        } catch (PersistenceException ex) {
            System.out.println("Error al crear la practica.");
            System.out.println("La empresa tiene que existir en la base de datos.");
        }

    }

    @Override
    public List<Practica> findAll() {
        String strQuery = "select p from Practica p";
        Query<Practica> query = HibernateUtil.getCurrentSession().createQuery(strQuery, Practica.class);
        return query.getResultList();
    }

    @Override
    public Practica findOneById(int id) {
        String strQuery = "select p from Practica p Where id = :id";
        Query<Practica> query = HibernateUtil.getCurrentSession().createQuery(strQuery, Practica.class);
        query.setParameter("id", id);

        try {
            Practica p = query.getSingleResult();
            return p;
        } catch (NoResultException ex) {
            System.out.println("No se ha recuperado ninguna Practica con el id: " + id);
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public void insertarAlumno(int idAlumno, int idPractica) {
        Alumno alumno = new AlumnoDAOImpl().findOneById(idAlumno);
        PracticaDAOImpl practicaDAOImpl = new PracticaDAOImpl();
        Practica practica = practicaDAOImpl.findOneById(idPractica);
        practica.setAlumno(alumno);
        practicaDAOImpl.update(practica);
    }

}
