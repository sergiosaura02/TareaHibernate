/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sergiotareahibernate;

import com.mycompany.sergiotareahibernate.DAO.AlumnoCandidatoPracticaDAOImpl;
import com.mycompany.sergiotareahibernate.DAO.AlumnoDAOImpl;
import com.mycompany.sergiotareahibernate.DAO.EmpresaDAO;
import com.mycompany.sergiotareahibernate.DAO.EmpresaDAOImpl;
import com.mycompany.sergiotareahibernate.DAO.PracticaDAOImpl;
import com.mycompany.sergiotareahibernate.entities.Alumno;
import com.mycompany.sergiotareahibernate.entities.AlumnoCandidatoPractica;
import com.mycompany.sergiotareahibernate.entities.CandidatoID;
import com.mycompany.sergiotareahibernate.entities.Empresa;
import com.mycompany.sergiotareahibernate.entities.Estado;
import com.mycompany.sergiotareahibernate.entities.Practica;
import com.mycompany.sergiotareahibernate.utilities.HibernateUtil;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
		// ***** PRIMERA PARTE *****

		// ***** CONSULTAS SOBRE ALUMNOS *****
		// AlumnoDAOImpl alumnoDAOImpl = new AlumnoDAOImpl();
		// MOSTRAR TODOS LOS ALUMNOS
		// System.out.println(alumnoDAOImpl.findAll());
		// MOSTRAR ALUMNO POR ID
		// System.out.println(alumnoDAOImpl.findOneById(2));
		// INSERTAR ALUMNO
		// Alumno a = new Alumno("Sergio", 22, "DAM");
		// alumnoDAOImpl.save(a);
		// ELIMINAR ALUMNO
		// alumnoDAOImpl.delete(alumnoDAOImpl.findOneById(6));
		// ACTUALIZAR ALUMNO
		// alumnoDAOImpl.update(new Alumno(5,"Sara Rodríguez", 22, "ASIR"));
		// ***** CONSULTAS SOBRE EMPRESAS *****
		EmpresaDAOImpl empresaDAOImpl = new EmpresaDAOImpl();
		// MOSTRAR TODAS LAS EMPRESAS
		// System.out.println(empresaDAOImpl.findAll());

		// MOSTRAR EMPRESA POR ID
		// System.out.println(empresaDAOImpl.findOneById(2));
		// INSERTAR EMPRESA
		// Empresa e = new Empresa(1,"Sergio Multiplatform Company", "Desarrollo
		// Multiplataforma");
		// empresaDAOImpl.save(e);
		// ELIMINAR EMPRESA
		// empresaDAOImpl.delete(empresaDAOImpl.findOneById(6));
		// ACTUALIZAR EMPRESA
		// empresaDAOImpl.update(new Empresa(5,"AYESA","Desarrollo Web"));
		// MOSTRAR EMPRESAS POR SECTOR
		// System.out.println(empresaDAOImpl.findBySector("Desarrollo Web"));
		
		// ***** SEGUNDA PARTE *****
		menu();
		// CERRAR SESION
		HibernateUtil.closeSessionFactory();
		System.out.println("Se ha cerrado la sesión");

	}

	private static void menu() {
		AlumnoDAOImpl alumnoDAOImpl = new AlumnoDAOImpl();
		EmpresaDAOImpl empresaDAOImpl = new EmpresaDAOImpl();
		PracticaDAOImpl practicaDAOImpl = new PracticaDAOImpl();
		AlumnoCandidatoPracticaDAOImpl alumnoCandidatoPracticaDAOImpl = new AlumnoCandidatoPracticaDAOImpl();

		int menu = 1;
		while (menu > 0 && menu < 5) {
			boolean salirMenuPrincipal = false;

			System.out.println("\n***** MENU PRINCIPAL *****");
			System.out.println("Pulsa 1 -> Menu Alumno");
			System.out.println("Pulsa 2 -> Menu Candidato");
			System.out.println("Pulsa 3 -> Menu Practica");
			System.out.println("Pulsa 4 -> Menu Empresa");
			System.out.println("Pulsa otro -> Salir del Menu");
			Scanner sc = new Scanner(System.in);
			menu = sc.nextInt();
			sc.nextLine();

			while (salirMenuPrincipal != true) {
				switch (menu) {
				case 1 -> {
					System.out.println("\t***** MENU ALUMNOS *****");
					System.out.println("\tPulsa 1 -> Consultar todos los alumnos.");
					System.out.println("\tPulsa 2 -> Consultar todos los alumnos de un titulo.");
					System.out.println("\tPulsa 3 -> Dar de alta un alumno.");
					System.out.println("\tPulsa otro -> Volver al menu principal");
					int numPulsadoCase1 = sc.nextInt();
					sc.nextLine();

					switch (numPulsadoCase1) {
					case 1 -> System.out.println(alumnoDAOImpl.findAll());
					case 2 -> {
						System.out.println("Inserta el titulo:");
						System.out.println(alumnoDAOImpl.findAllForTitulo(sc.nextLine()));
					}
					case 3 -> {
						System.out.println("Inserta el nombre:");
						String nombre = sc.nextLine();

						System.out.println("Inserta la edad:");
						int edad = sc.nextInt();
						sc.nextLine();

						System.out.println("Inserta el titulo:");
						String titulo = sc.nextLine().toUpperCase();

						Alumno a = new Alumno(nombre, edad, titulo);

						alumnoDAOImpl.save(a);
					}

					default -> salirMenuPrincipal = true;
					}
				}

				case 2 -> {
					System.out.println("\t***** MENU CANDIDATOS *****");
					System.out.println("\tPulsa 1 -> Consultar los candidatos de una practica.");
					System.out.println("\tPulsa 2 -> Cambiar el estado de un candidato. ");
					System.out.println("\tPulsa 3 -> Crear un candidato.");
					System.out.println("\tPulsa otro -> Volver al menu principal");
					int numPulsadoCase2 = sc.nextInt();
					sc.nextLine();
					switch (numPulsadoCase2) {
					case 1 -> {
						System.out.println("Introduce el ID de la practica:");
						System.out.println(alumnoCandidatoPracticaDAOImpl.consultarCandidatosPractica(sc.nextInt()));
						sc.nextLine();
					}
					case 2 -> {
						System.out.println("Introduce el ID del alumno:");
						int idAlumno = sc.nextInt();
						sc.nextLine();

						System.out.println("Introduce el ID de la practica:");
						int idPractica = sc.nextInt();
						sc.nextLine();

						System.out.println("Inserta el estado del alumno (Aceptado, Rechazado, Pendiente):");
						System.out.println("En caso de introducir mal el estado se pondra por defecto -> Pendiente");
						String strEstado = sc.nextLine();
						alumnoCandidatoPracticaDAOImpl.cambiarEstadoCandidato(idAlumno, idPractica, strEstado);
					}
					case 3 -> {
						System.out.println("Inserta el ID del alumno:");
						int idAlumno = sc.nextInt();
						sc.nextLine();
						System.out.println("Inserta el ID de la practica:");
						int idPractica = sc.nextInt();
						sc.nextLine();

						CandidatoID id = new CandidatoID(idAlumno, idPractica);
						LocalDate fechaSolicitud = introducirFecha(
								"Introduce la fecha de solicitud con el formato dd/MM/yyyy");

						alumnoCandidatoPracticaDAOImpl
								.save(new AlumnoCandidatoPractica(id, fechaSolicitud, Estado.Pendiente));
					}
					default -> salirMenuPrincipal = true;
					}
				}

				case 3 -> {
					System.out.println("\t***** MENU PRACTICAS *****");
					System.out.println("\tPulsa 1 -> Consultar todas las practicas.");
					System.out.println("\tPulsa 2 -> Dar de alta una practica.");
					System.out.println("\tPulsa 3 -> Asignar un alumno a la practica.");
					System.out.println("\tPulsa otro -> Volver al menu principal");
					int numPulsadoCase3 = sc.nextInt();
					sc.nextLine();
					switch (numPulsadoCase3) {
					case 1 -> {
						System.out.println(practicaDAOImpl.findAll());
					}
					case 2 -> {
						LocalDate fechaInicio = introducirFecha(
								"Introduce la fecha de inicio con el formato dd/MM/yyyy");
						LocalDate fechaFin = LocalDate.now();
						do {
							fechaFin = introducirFecha("Introduce la fecha de fin con el formato dd/MM/yyyy");
							if (fechaFin.isBefore(fechaInicio)) {
								System.out.println("La fecha de fin no puede ser anterior a la fecha de inicio.");
							}
						} while (fechaFin.isBefore(fechaInicio));

						System.out.println("Introduce la descripcion de la practica:");
						String descripcion = sc.nextLine();

						System.out.println("Introduce el ID de la empresa de practicas:");
						Empresa empresa = empresaDAOImpl.findOneById(sc.nextInt());
						sc.nextLine();
						
						practicaDAOImpl.save(new Practica(fechaInicio, fechaFin, descripcion, empresa));

					}
					case 3 -> {
						System.out.println("Introduce el ID de la practica donde quieres insertar el alumno:");
						int idPractica = sc.nextInt();
						sc.nextLine();

						System.out.println("Introduce el ID del alumno que quieres insertar:");
						int idAlumno = sc.nextInt();
						sc.nextLine();

						practicaDAOImpl.insertarAlumno(idAlumno, idPractica);
					}
					default -> salirMenuPrincipal = true;
					}
				}

				case 4 -> {
					System.out.println("\t***** MENU EMPRESAS *****");
					System.out.println("\tPulsa 1 -> Consultar todas las empresas.");
					System.out.println("\tPulsa 2 -> Consultar todas las empresas de un sector.");
					System.out.println("\tPulsa 3 -> Dar de alta una empresa.");
					System.out.println("\tPulsa otro -> Volver al menu principal");
					int numPulsadoCase4 = sc.nextInt();
					sc.nextLine();
					switch (numPulsadoCase4) {
					case 1 -> {
						System.out.println(empresaDAOImpl.findAll());
					}
					case 2 -> {
						System.out.println("Introduce el sector:");
						System.out.println(empresaDAOImpl.findBySector(sc.nextLine()));
					}
					case 3 -> {
						System.out.println("Introduce el nombre de la empresa:");
						String nombreEmpresa = sc.nextLine().toUpperCase();

						System.out.println("Introduce el sector de la empresa:");
						String sectorEmpresa = sc.nextLine();

						Empresa empresa = new Empresa(nombreEmpresa, sectorEmpresa);
						empresaDAOImpl.save(empresa);
					}
					default -> salirMenuPrincipal = true;
					}
				}

				default -> {
					salirMenuPrincipal = true;
					menu = 5;
				}

				}
			}
		}
	}

	public static LocalDate introducirFecha(String introduceFraseFecha) {
		Scanner sc = new Scanner(System.in);
		boolean fechaValida = false;
		LocalDate fecha = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		do {
			System.out.println(introduceFraseFecha);
			String strFechaSolicitud = sc.nextLine();
			try {
				fecha = LocalDate.parse(strFechaSolicitud, dateTimeFormatter);
				fechaValida = true;
			} catch (DateTimeParseException ex) {
				System.out.println("El formato de la fecha es incorrecto");
				fechaValida = false;
			}

		} while (fechaValida == false);
		return fecha;
	}
}
