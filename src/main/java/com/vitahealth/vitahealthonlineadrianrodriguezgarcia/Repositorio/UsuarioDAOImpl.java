package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO{

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    String unidadPersistencia = "upAdrian";

    public UsuarioDAOImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory(unidadPersistencia);
    }

    @Override
    public boolean insertarActualizarUsuario(Usuario usuario) {
        entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(usuario);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception exception){
            return false;
        }
    }

    @Override
    public Usuario findByNombreAndContrasena(String nombre, String contrasena) {
        entityManager = entityManagerFactory.createEntityManager();
        try {
            // Consulta JPQL para buscar un usuario por su nombre y contraseña
            String jpql = "SELECT u FROM Usuario u WHERE u.nombre = :nombre AND u.contrasena = :contrasena";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("nombre", nombre);
            query.setParameter("contrasena", contrasena);
            // Ejecutar la consulta y devolver el resultado único o null si no se encuentra ningún usuario
            return (Usuario) query.getSingleResult();
        } catch (Exception exception) {
            // Si no se encuentra ningún usuario con el nombre y contraseña dados, devolver null
            return null;
        }
    }


    @Override
    public List<Usuario> getAllUsuarios() {
        entityManager = entityManagerFactory.createEntityManager();
        String hql = "FROM Usuario u";
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    @Override
    public Usuario getUsuario(int id) {
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public boolean deleteUsuario(int id) {
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
