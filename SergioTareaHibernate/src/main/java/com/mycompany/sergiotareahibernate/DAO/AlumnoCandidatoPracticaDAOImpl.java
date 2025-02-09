/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sergiotareahibernate.DAO;

import com.mycompany.sergiotareahibernate.entities.AlumnoCandidatoPractica;
import com.mycompany.sergiotareahibernate.entities.Estado;
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
public class AlumnoCandidatoPracticaDAOImpl implements AlumnoCandidatoPracticaDAO {

	@Override
	public void update(AlumnoCandidatoPractica t) {
		HibernateUtil.getCurrentSession().beginTransaction();
		HibernateUtil.getCurrentSession().clear();
		HibernateUtil.getCurrentSession().update(t);
		HibernateUtil.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void delete(AlumnoCandidatoPractica t) {
		HibernateUtil.getCurrentSession().beginTransaction();
		HibernateUtil.getCurrentSession().clear();
		HibernateUtil.getCurrentSession().delete(t);
		HibernateUtil.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void save(AlumnoCandidatoPractica t) {
		try {
			HibernateUtil.getCurrentSession().beginTransaction();
			HibernateUtil.getCurrentSession().clear();
			HibernateUtil.getCurrentSession().save(t);
			HibernateUtil.getCurrentSession().getTransaction().commit();

		} catch (PersistenceException ex) {
			System.out.println(
					"No se ha podido crear el candidato. Comprueba que el ID del alumno y el ID de la practica sean validos.");
			System.out.println(
					"Hay que cerciorarse de que no exista dicho alumno siendo candidato de dicha práctica, ya que da error de duplicación.");
		}

	}

	@Override
	public List<AlumnoCandidatoPractica> findAll() {
		try {
			String strQuery = "FROM AlumnoCandidatoPractica";
			Query<AlumnoCandidatoPractica> query = HibernateUtil.getCurrentSession().createQuery(strQuery,
					AlumnoCandidatoPractica.class);
			return query.getResultList();
		} catch (NoResultException e) {
			System.out.println("No se ha podido devolver los resultados de los candidatos.");
			return null;
		}

	}

	public AlumnoCandidatoPractica findOneById(int idAlumno, int idPractica) {
		try {
			return HibernateUtil.getCurrentSession().createQuery(
					"FROM  AlumnoCandidatoPractica WHERE id.alumnoID = :idAlumno AND id.practicaID = :idPractica",
					AlumnoCandidatoPractica.class).setParameter("idAlumno", idAlumno)
					.setParameter("idPractica", idPractica).getSingleResult();
		} catch (NoResultException e) {
			System.out.println("No se ha podido devolver el resultado del candidato con ID de alumno " + idAlumno
					+ " e ID de práctica " + idPractica);
			return null;
		}

	}

	/**
	 * Este método no es compatible con la clave primaria compuesta de
	 * {@code AlumnoCandidatoPractica}. La entidad {@code AlumnoCandidatoPractica}
	 * usa una clave primaria compuesta{@code CandidatoID}}. No se puede buscar un
	 * {@code AlumnoCandidatoPractica} solo con un {@code int id}
	 * <p>
	 * En su lugar, usa {@link #findOneById(int, int)} con los identificadores
	 * correctos.
	 * <p>
	 *
	 * @param id No es un identificador válido para {@code AlumnoCandidatoPractica}.
	 * @throws UnsupportedOperationException Siempre lanza excepción.
	 * @deprecated Usa {@link #findOneById(int, int)} en su lugar.
	 */
	@Deprecated
	@Override
	public AlumnoCandidatoPractica findOneById(int id) {
		throw new UnsupportedOperationException("Usa findOneById (int idAlumno, int id_codigoModulo)");
	}

	@Override
	public List<AlumnoCandidatoPractica> consultarCandidatosPractica(int idPractica) {
		try {
			return HibernateUtil.getCurrentSession()
					.createQuery("FROM AlumnoCandidatoPractica WHERE id.practicaID = :practicaID")
					.setParameter("practicaID", idPractica).getResultList();

		} catch (NoResultException e) {
			System.out
					.println("No se han podido devolcer resultados de candidatos de la práctica con id " + idPractica);
			return null;
		}

	}

	@Override
	public void cambiarEstadoCandidato(Integer idAlumno, int idPractica, String strEstado) {
		try {
			AlumnoCandidatoPracticaDAOImpl alumnoCandidatoPracticaDAOImpl = new AlumnoCandidatoPracticaDAOImpl();
			AlumnoCandidatoPractica alumnoCandidatoPractica = alumnoCandidatoPracticaDAOImpl.findOneById(idAlumno,
					idPractica);
			Estado estado;
			switch (strEstado.toLowerCase()) {
			case "aceptado" -> estado = Estado.Aceptado;

			case "rechazado" -> estado = Estado.Rechazado;

			case "pendiente" -> estado = Estado.Pendiente;
			default -> {
				estado = Estado.Pendiente;
			}
			}
			alumnoCandidatoPractica.setEstado(estado);
			alumnoCandidatoPracticaDAOImpl.update(alumnoCandidatoPractica);

			AlumnoDAOImpl alumnoDAOImpl = new AlumnoDAOImpl();

			PracticaDAOImpl practicaDAOImpl = new PracticaDAOImpl();
			Practica practica = practicaDAOImpl.findOneById(idPractica);

			if (strEstado.equals("aceptado")) {
				practica.setAlumno(alumnoDAOImpl.findOneById(idAlumno));
				practicaDAOImpl.update(practica);
			} else {
				practica.setAlumno(null);
				practicaDAOImpl.update(practica);
			}

		} catch (NoResultException e) {
			System.out
					.println("No se ha podido actualizar el estado del candidato con los valores que has introducido.");
			System.out.println("Asegurate de que el ID del alumno y el ID de la práctica sean correctos.");
		}

	}
}
