package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Consulta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ConsultaDAOImpl implements ConsultaDAO{

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    String unidadPersistencia = "upAdrian";

    public ConsultaDAOImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory(unidadPersistencia);
    }

    @Override
    public boolean insertarActualizarConsulta(Consulta consulta) {
        entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(consulta);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception exception){
            return false;
        }
    }

    @Override
    public List<Consulta> getAllConsultas() {
        entityManager = entityManagerFactory.createEntityManager();
        String hql = "FROM Consulta c";
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    @Override
    public Consulta getConsulta(int id) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Consulta.class, id);
    }

    @Override
    public boolean deleteConsulta(int id) {
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
