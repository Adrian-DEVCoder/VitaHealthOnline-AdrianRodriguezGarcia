package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Medico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class MedicoDAOImpl implements MedicoDAO{

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    String unidadPersistencia = "upAdrian";

    public MedicoDAOImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory(unidadPersistencia);
    }

    @Override
    public boolean insertarActualizarMedico(Medico medico) {
        entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(medico);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception exception){
            return false;
        }
    }

    @Override
    public List<Medico> getAllMedicos() {
        entityManager = entityManagerFactory.createEntityManager();
        String hql = "FROM Medico m";
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    @Override
    public Medico getMedico(int id) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Medico.class, id);
    }

    @Override
    public boolean deleteMedico(int id) {
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
}
