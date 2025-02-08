/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sergiotareahibernate.DAO;

import com.mycompany.sergiotareahibernate.entities.Alumno;
import com.mycompany.sergiotareahibernate.entities.AlumnoCandidatoPractica;
import com.mycompany.sergiotareahibernate.entities.Estado;
import com.mycompany.sergiotareahibernate.utilities.HibernateUtil;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.exception.ConstraintViolationException;
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
            System.out.println("No se ha podido crear el candidato. Comprueba que el ID del alumno y el ID de la practica sean validos.");
            System.out.println("Hay que cerciorarse de que tanto el alumno como la practica existan para poder crear el candidato.");
        }

    }

    @Override
    public List<AlumnoCandidatoPractica> findAll() {
        String strQuery = "FROM AlumnoCandidatoPractica";
        Query<AlumnoCandidatoPractica> query = HibernateUtil.getCurrentSession().createQuery(strQuery, AlumnoCandidatoPractica.class);
        return query.getResultList();
    }

    public AlumnoCandidatoPractica findOneById(int idAlumno, int idPractica) {
        return HibernateUtil.getCurrentSession().
                createQuery("FROM  AlumnoCandidatoPractica WHERE id.alumnoID = :idAlumno AND id.practicaID = :idPractica", AlumnoCandidatoPractica.class).
                setParameter("idAlumno", idAlumno).
                setParameter("idPractica", idPractica).
                getSingleResult();
    }

    /**
     * Este método no es compatible con la clave primaria compuesta de
     * {@code AlumnoCandidatoPractica}. La entidad
     * {@code AlumnoCandidatoPractica} usa una clave primaria
     * compuesta{@code CandidatoID}}. No se puede buscar un
     * {@code AlumnoCandidatoPractica} solo con un {@code int id}
     * <p>
     * En su lugar, usa {@link #findOneById(int, int)} con los identificadores
     * correctos.
     * <p>
     *
     * @param id No es un identificador válido para
     * {@code AlumnoCandidatoPractica}.
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
        return HibernateUtil.getCurrentSession().
                createQuery("FROM AlumnoCandidatoPractica WHERE id.practicaID = :practicaID").
                setParameter("practicaID", idPractica).
                getResultList();
    }

    @Override
    public void cambiarEstadoCandidato(int idAlumno, int idPractica, String strEstado) {
        AlumnoCandidatoPracticaDAOImpl alumnoCandidatoPracticaDAOImpl = new AlumnoCandidatoPracticaDAOImpl();
        AlumnoCandidatoPractica alumnoCandidatoPractica = alumnoCandidatoPracticaDAOImpl.findOneById(idAlumno, idPractica);
        Estado estado;
        switch (strEstado.toLowerCase()) {
            case "aceptado" ->
                estado = Estado.Aceptado;

            case "rechazado" ->
                estado = Estado.Rechazado;

            case "pendiente" ->
                estado = Estado.Pendiente;
            default -> {
                estado = Estado.Pendiente;
            }
        }
        alumnoCandidatoPractica.setEstado(estado);
        alumnoCandidatoPracticaDAOImpl.update(alumnoCandidatoPractica);
        
    }
}
