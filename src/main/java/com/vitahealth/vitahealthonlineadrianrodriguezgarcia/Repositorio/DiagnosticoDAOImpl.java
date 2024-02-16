package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Diagnostico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class DiagnosticoDAOImpl implements DiagnosticoDAO{

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    String unidadPersistencia = "upAdrian";

    public DiagnosticoDAOImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory(unidadPersistencia);
    }

    @Override
    public boolean insertarActualizarDiagnostico(Diagnostico diagnostico) {
        entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(diagnostico);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception exception){
            return false;
        }
    }

    @Override
    public List<Diagnostico> getAllDiagnosticos() {
        entityManager = entityManagerFactory.createEntityManager();
        String hql = "FROM Diagnostico d";
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    @Override
    public Diagnostico getDiagnostico(int id) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Diagnostico.class, id);
    }

    @Override
    public boolean deleteDiagnostico(int id) {
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
    public List<Diagnostico> getDiagnosticosByHistorial(int id) {
        entityManager = entityManagerFactory.createEntityManager();
        String hql = "FROM Diagnostico d WHERE d.historial.id_historial = :id";
        Query query = entityManager.createQuery(hql);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
