package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Historial;
import jakarta.persistence.*;

import java.util.List;

public class HistorialDAOImpl implements HistorialDAO{

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    String unidadPersistencia = "upAdrian";

    public HistorialDAOImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory(unidadPersistencia);
    }

    @Override
    public boolean insertarActualizarHistorial(Historial historial) {
        entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(historial);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception exception){
            return false;
        }
    }

    @Override
    public List<Historial> getAllHistoriales() {
        entityManager = entityManagerFactory.createEntityManager();
        String hql = "FROM Historial h";
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    @Override
    public Historial getHistorial(int id) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Historial.class, id);
    }

    @Override
    public boolean deleteHistorial(int id) {
        entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(id);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception exception){
            return false;
        }
    }

    @Override
    public Historial obtenerHistorialPorPacienteConDiagnosticos(int id) {
        entityManager = entityManagerFactory.createEntityManager();
        try {
            String jpql = "SELECT h FROM Historial h LEFT JOIN FETCH h.diagnosticos WHERE h.paciente.id = :id";
            return entityManager.createQuery(jpql, Historial.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
