package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.DatosSalud;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class DatosSaludDAOImpl implements DatosSaludDAO{

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    String unidadPersistencia;

    public DatosSaludDAOImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory(unidadPersistencia);
    }

    @Override
    public boolean insertarActualizarDatosSalud(DatosSalud datosSalud) {
        entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(datosSalud);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception exception){
            return false;
        }
    }

    @Override
    public List<DatosSalud> getAllDatosSalud() {
        entityManager = entityManagerFactory.createEntityManager();
        String hql = "FROM DatosSalud d";
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    @Override
    public DatosSalud getDatosSalud(int id) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(DatosSalud.class, id);
    }

    @Override
    public boolean deleteDatosSalud(int id) {
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
    public List<DatosSalud> obtenerDatosSaludPorPaciente(int id) {
        entityManager = entityManagerFactory.createEntityManager();
        String hql = "FROM DatosSalud ds WHERE ds.paciente.id_paciente = :id";
        Query query = entityManager.createQuery(hql);
        query.setParameter("id",id);
        return query.getResultList();
    }
}
