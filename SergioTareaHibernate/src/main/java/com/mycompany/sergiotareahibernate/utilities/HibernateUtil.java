/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sergiotareahibernate.utilities;

import com.mycompany.sergiotareahibernate.entities.*;
import java.sql.Statement;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Sergio
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Session session;

    
    public static void buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Alumno.class);
        configuration.addAnnotatedClass(Empresa.class);
        configuration.addAnnotatedClass(CandidatoID.class);
        configuration.addAnnotatedClass(Practica.class);
        configuration.addAnnotatedClass(AlumnoCandidatoPractica.class);


        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    
    public static void openSession() {
        session = sessionFactory.openSession();
    }

    
    public static Session getCurrentSession() {
        if ((session == null) || (!session.isOpen())) {
            openSession();
        }
        return session;
    }

    
    public static void closeSessionFactory() {
        if (session != null) {
            session.close();
        }
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
