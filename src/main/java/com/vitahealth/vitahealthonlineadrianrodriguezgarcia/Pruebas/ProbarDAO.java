package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Pruebas;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Paciente;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.PacienteDAO;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.PacienteDAOImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Date;

public class ProbarDAO {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("upAdrian");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        PacienteDAO pacienteDAO = new PacienteDAOImpl();
        // Instanciamos pacientes
        Paciente p1 = new Paciente();
        p1.setId_paciente(1);
        p1.setNombre_paciente("Pepe");
        p1.setApellidos_paciente("Lopez");
        Date fechaNacimiento = java.sql.Date.valueOf(LocalDate.of(2009, 5, 9));
        p1.setFecha_nacimiento(fechaNacimiento);
        p1.setSexo("Hombre");
        p1.setDireccion("Calle Zaragoza, 3");
        p1.setCorreo_electronico("pepe.lopez@gmail.com");
        p1.setTelefono("654281937");
        // Insertamos el paciente
        pacienteDAO.insertarActualizarPaciente(p1);
        // Mostramos los pacientes
        pacienteDAO.getAllPacientes().forEach(paciente -> {
            System.out.println(paciente);
        });
        // Cerramos los entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}
