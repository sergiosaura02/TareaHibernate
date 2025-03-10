/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sergiotareahibernate.DAO;

import com.mycompany.sergiotareahibernate.entities.Alumno;
import com.mycompany.sergiotareahibernate.utilities.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.query.Query;

/**
 *
 * @author Sergio
 */
public class AlumnoDAOImpl implements AlumnoDAO {

	@Override
	public void update(Alumno t) {
		HibernateUtil.getCurrentSession().beginTransaction();
		HibernateUtil.getCurrentSession().clear();
		HibernateUtil.getCurrentSession().update(t);
		HibernateUtil.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void delete(Alumno t) {
		HibernateUtil.getCurrentSession().beginTransaction();
		HibernateUtil.getCurrentSession().clear();
		HibernateUtil.getCurrentSession().delete(t);
		HibernateUtil.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void save(Alumno t) {
		HibernateUtil.getCurrentSession().beginTransaction();
		HibernateUtil.getCurrentSession().clear();
		HibernateUtil.getCurrentSession().save(t);
		HibernateUtil.getCurrentSession().getTransaction().commit();
	}

	@Override
	public List<Alumno> findAll() {
		try {
			String strQuery = "select a from Alumno a";
			Query<Alumno> query = HibernateUtil.getCurrentSession().createQuery(strQuery, Alumno.class);
			return query.getResultList();

		} catch (NoResultException e) {
			System.out.println("No se ha podido recuperar alumnos.");
			return null;
		}

	}

	@Override
	public Alumno findOneById(int id) {
		String strQuery = "select a from Alumno a Where id = :id";
		Query<Alumno> query = HibernateUtil.getCurrentSession().createQuery(strQuery, Alumno.class);
		query.setParameter("id", id);

		try {
			Alumno a = query.getSingleResult();
			return a;
		} catch (NoResultException ex) {
			System.out.println("No existe el Alumno con el id: " + id);
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public List<Alumno> findAllForTitulo(String titulo) {
		try {
			return HibernateUtil.getCurrentSession().createQuery("FROM Alumno WHERE titulo = :titulo", Alumno.class)
					.setParameter("titulo", titulo.toUpperCase()).getResultList();
		} catch (NoResultException e) {
			System.out.println("No se ha podido recuperar alumnos con el titulo " + titulo);
			return null;
		}

	}

}
