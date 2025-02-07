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
import java.util.Scanner;

/**
 *
 * @author Sergio
 */
public class SergioTareaHibernate {

    public static void main(String[] args) {
        HibernateUtil.buildSessionFactory();
        System.out.println("Se ha abierto la sesion");

        //***** CONSULTAS SOBRE ALUMNOS *****
        //AlumnoDAOImpl alumnoDAOImpl = new AlumnoDAOImpl();
        //MOSTRAR TODOS LOS ALUMNOS
        //System.out.println(alumnoDAOImpl.findAll());
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

    private static void menu() {
        System.out.println("***** MENU PRINCIPAL *****");
        System.out.println("Pulsa 1 -> Menu Alumno");
        System.out.println("Pulsa 2 -> Menu Candidato");
        System.out.println("Pulsa 3 -> Menu Practica");
        System.out.println("Pulsa 4 -> Menu Empresa");

        Scanner sc = new Scanner(System.in);
        int menu = sc.nextInt();
        sc.nextLine();

        switch (menu) {
            case 1:
                System.out.println("***** MENU ALUMNOS *****");
                System.out.println("\tPulsa 0 -> Volver al menu principal");
                System.out.println("\tPulsa 1 -> Consultar todos los alumnos.");
                System.out.println("\tPulsa 2 -> Consultar todos los alumnos de un titulo.");
                System.out.println("\tPulsa 3 -> Dar de alta un alumno.");
                System.out.println("\tPulsa 4 -> Asignar un alumno como candidato de una practica.");
                System.out.println("\tPulsa 5 -> Asignar un alumno a una practica.");
                if(sc.nextInt() == 0){
                    menu();
                }
                break;

            case 2:
                System.out.println("***** MENU CANDIDATOS *****");
                System.out.println("\tPulsa 1 -> Consultar los candidatos de una práctica.");
                System.out.println("\tPulsa 2 -> Cambiar el estado de un candidato. ");
                System.out.println("\tPulsa 3 -> Asignar un alumno como candidato de una practica.");

            case 3:
                System.out.println("***** MENU PRACTICAS *****");
                System.out.println("\tPulsa 1 -> Consultar todas las practicas.");
                System.out.println("\tPulsa 2 -> Dar de alta una practica.");

            case 4:
                System.out.println("***** MENU EMPRESAS *****");
                System.out.println("Pulsa 1 -> Consultar todas las empresas.");
                System.out.println("Pulsa 2 -> Consultar todas las empresas de un sector."); 
                System.out.println("Pulsa 3 -> Dar de alta una empresa.");

            default:
                throw new AssertionError();
        }

    }
    
    private static void volverMenuPrincipal(){
        
    }
}
