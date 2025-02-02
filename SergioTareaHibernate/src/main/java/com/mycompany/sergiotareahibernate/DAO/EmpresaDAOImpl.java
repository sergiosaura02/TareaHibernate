/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sergiotareahibernate.DAO;

import com.mycompany.sergiotareahibernate.entities.Empresa;
import com.mycompany.sergiotareahibernate.utilities.HibernateUtil;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.query.Query;

/**
 *
 * @author Sergio
 */
public class EmpresaDAOImpl implements EmpresaDAO{

    @Override
    public void update(Empresa t) {
        HibernateUtil.getCurrentSession().beginTransaction();
        HibernateUtil.getCurrentSession().clear();
        HibernateUtil.getCurrentSession().update(t);
        HibernateUtil.getCurrentSession().getTransaction().commit();
    }

    @Override
    public void delete(Empresa t) {
        HibernateUtil.getCurrentSession().beginTransaction();
        HibernateUtil.getCurrentSession().clear();
        HibernateUtil.getCurrentSession().delete(t);
        HibernateUtil.getCurrentSession().getTransaction().commit();
    }

    @Override
    public void save(Empresa t) {
        HibernateUtil.getCurrentSession().beginTransaction();
        HibernateUtil.getCurrentSession().clear();
        HibernateUtil.getCurrentSession().save(t);
        HibernateUtil.getCurrentSession().getTransaction().commit();
    }

    @Override
    public List<Empresa> findAll() {
        String strQuery = "select e from Empresa e";
        Query<Empresa> query = HibernateUtil.getCurrentSession().createQuery(strQuery, Empresa.class);
        return query.getResultList();
    }

    @Override
    public Empresa findOneById(int id) {
        String strQuery = "select e from Empresa e Where id = :id";
        Query<Empresa> query = HibernateUtil.getCurrentSession().createQuery(strQuery, Empresa.class);
        query.setParameter("id", id);

        try {
            Empresa e = query.getSingleResult();
            return e;
        } catch (NoResultException ex) {
            System.out.println("No se ha recuperado ninguna Empresa con el id: " + id);
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public List<Empresa> findBySector(String sector){
        String strQuery = "Select e from Empresa e Where sector = :sector";
        Query<Empresa> query = HibernateUtil.getCurrentSession().createQuery(strQuery, Empresa.class);
        query.setParameter("sector", sector);
        return query.getResultList();
    }
    
}
