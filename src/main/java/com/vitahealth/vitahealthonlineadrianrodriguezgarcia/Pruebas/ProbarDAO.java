package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Pruebas;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Consulta;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Medico;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Paciente;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.*;
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
        MedicoDAO medicoDAO = new MedicoDAOImpl();
        ConsultaDAO consultaDAO = new ConsultaDAOImpl();

        //Instanciamos pacientes
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

        //Instanciamos profesionales
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

        // Instanciamos consultas
        Consulta c1 = new Consulta();
        c1.setId_consulta(1);
        c1.setPaciente(p1);
        c1.setMedico(m1);
        Date fecha = java.sql.Date.valueOf(LocalDate.of(2024, 2, 6));
        c1.setFecha_consulta(fecha);
        c1.setTipo_consulta("Online");
        c1.setEstado_consulta("Programada");
        // Insertamos las consultas
        consultaDAO.insertarActualizarConsulta(c1);
        // Mostramos las consultas
        consultaDAO.getAllConsultas().forEach(consulta -> {
            System.out.println(consulta);
        });

        // Cerramos los entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}
