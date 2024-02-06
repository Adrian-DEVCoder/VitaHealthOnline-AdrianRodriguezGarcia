package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Pruebas;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Medico;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Paciente;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.MedicoDAO;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.MedicoDAOImpl;
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
        //PacienteDAO pacienteDAO = new PacienteDAOImpl();
        MedicoDAO medicoDAO = new MedicoDAOImpl();

        /* Instanciamos pacientes
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
        });*/

        // Instanciamos profesionales
        Medico m1 = new Medico();
        m1.setId_profesional(1);
        m1.setNombre_profesional("Luis");
        m1.setApellidos_profesional("Perez");
        m1.setEspecialidad("Enfermería Pediatrica");
        m1.setCorreo_electronico("luis.perez@gmail.com");
        m1.setTelefono("625413879");
        // Insertamos los medicos
        medicoDAO.insertarActualizarMedico(m1);
        // Mostramos los medicos
        medicoDAO.getAllMedicos().forEach(medico -> {
            System.out.println(medico);
        });
        // Cerramos los entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}
