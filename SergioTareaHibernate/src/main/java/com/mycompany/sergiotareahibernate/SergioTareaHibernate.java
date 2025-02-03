/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sergiotareahibernate;

import com.mycompany.sergiotareahibernate.DAO.AlumnoDAOImpl;
import com.mycompany.sergiotareahibernate.DAO.EmpresaDAO;
import com.mycompany.sergiotareahibernate.DAO.EmpresaDAOImpl;
import com.mycompany.sergiotareahibernate.entities.Alumno;
import com.mycompany.sergiotareahibernate.entities.Empresa;
import com.mycompany.sergiotareahibernate.utilities.HibernateUtil;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public class SergioTareaHibernate {

    public static void main(String[] args) {
        HibernateUtil.buildSessionFactory();
        //System.out.println("Se ha abierto la sesion");
        
        //***** CONSULTAS SOBRE ALUMNOS *****
        
        //AlumnoDAOImpl alumnoDAOImpl = new AlumnoDAOImpl();
        //MOSTRAR TODOS LOS ALUMNOS
        System.out.println(alumnoDAOImpl.findAll());
        
        //MOSTRAR ALUMNO POR ID
        //System.out.println(alumnoDAOImpl.findOneById(2));
        
        //INSERTAR ALUMNO
        //Alumno a = new Alumno("Sergio", 22, "DAM");
        //alumnoDAOImpl.save(a);
        
        //ELIMINAR ALUMNO
        //alumnoDAOImpl.delete(alumnoDAOImpl.findOneById(6));
        
        //ACTUALIZAR ALUMNO
        //alumnoDAOImpl.update(new Alumno(5,"Sara Rodríguez", 22, "ASIR"));
        
        //***** CONSULTAS SOBRE EMPRESAS *****
        
        EmpresaDAOImpl empresaDAOImpl = new EmpresaDAOImpl();
        //MOSTRAR TODAS LAS EMPRESAS
        //System.out.println(empresaDAOImpl.findAll());
        
        //MOSTRAR EMPRESA POR ID
        //System.out.println(empresaDAOImpl.findOneById(2));
        
        //INSERTAR EMPRESA
        //Empresa e = new Empresa(1,"Sergio Multiplatform Company", "Desarrollo Multiplataforma");
        //empresaDAOImpl.save(e);
        
        //ELIMINAR EMPRESA
        //empresaDAOImpl.delete(empresaDAOImpl.findOneById(6));
        
        //ACTUALIZAR EMPRESA
        //empresaDAOImpl.update(new Empresa(5,"AYESA","Desarrollo Web"));
        
        //MOSTRAR EMPRESAS POR SECTOR
        //System.out.println(empresaDAOImpl.findBySector("Desarrollo Web"));
        
        //CERRAR SESION
        HibernateUtil.closeSessionFactory();
        System.out.println("Se ha cerrado la sesion");
        
    }
}
