package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Paciente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class PacienteDAOImpl implements PacienteDAO{
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    String unidadPersistencia = "upAdrian";

    public PacienteDAOImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory(unidadPersistencia);
    }

    @Override
    public boolean insertarActualizarPaciente(Paciente paciente) {
        entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(paciente);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception exception){
            return false;
        }
    }

    @Override
    public List<Paciente> getAllPacientes() {
        entityManager = entityManagerFactory.createEntityManager();
        String hql = "FROM Paciente p";
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    @Override
    public Paciente getPaciente(int id) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Paciente.class, id);
    }

    @Override
    public boolean deletePaciente(int id) {
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
    public Paciente getPacienteByIdUsuario(int idUsuario) {
        entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            String hql = "FROM Paciente p WHERE p.usuario ="+idUsuario;
            Query query = entityManager.createQuery(hql);
            Paciente paciente = (Paciente) query.getSingleResult();
            entityManager.getTransaction().commit();
            return paciente;
        } catch (Exception exception){
            return null;
        }
    }
}
