package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Pruebas;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.*;
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
        HistorialDAO historialDAO = new HistorialDAOImpl();
        DatosSaludDAO datosSaludDAO = new DatosSaludDAOImpl();
        MensajeDAO mensajeDAO = new MensajeDAOImpl();

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
        Date fechaConsulta = java.sql.Date.valueOf(LocalDate.of(2024, 2, 6));
        c1.setFecha_consulta(fechaConsulta);
        c1.setTipo_consulta("Online");
        c1.setEstado_consulta("Programada");
        // Insertamos las consultas
        consultaDAO.insertarActualizarConsulta(c1);
        // Mostramos las consultas
        consultaDAO.getAllConsultas().forEach(consulta -> {
            System.out.println(consulta);
        });

        // Instanciamos historiales
        Historial h1 = new Historial();
        h1.setId_historial(1);
        h1.setPaciente(p1);
        h1.setMedico(m1);
        Date fechaRegistro = java.sql.Date.valueOf(LocalDate.of(2024,2,5));
        h1.setFecha_registro(fechaRegistro);
        h1.setDiagnostico("Artritis Rumatoide");
        h1.setTratamiento("Se proporciona un vendaje, para estabilizar y aliviar la articulacion");
        h1.setNotas("Realizar vida sana");
        // Insertamos el historial
        historialDAO.insertarActualizarHistorial(h1);
        // Mostramos los historiales
        historialDAO.getAllHistoriales().forEach(historial -> {
            System.out.println(historial);
        });

        // Instanciamos datos de salud
        DatosSalud d1 = new DatosSalud();
        d1.setId_dato(1);
        d1.setPaciente(p1);
        Date fechaDato = java.sql.Date.valueOf(LocalDate.of(2024, 2, 1));
        d1.setFecha_dato(fechaDato);
        d1.setTipo_dato("Lectura de Glucosa");
        d1.setValor_dato("120");
        d1.setUnidad_medida("mg/dL");
        // Insertamos los datos de salud
        datosSaludDAO.insertarActualizarDatosSalud(d1);
        // Mostramos los datos de salud
        datosSaludDAO.getAllDatosSalud().forEach(datosSalud -> {
            System.out.println(datosSalud);
        });

        // Instanciamos mensajes
        Mensaje men1 = new Mensaje();
        men1.setId_mensaje(1);
        men1.setPaciente(p1);
        men1.setMedico(m1);
        men1.setContenido_mensaje("Buenas. Quiero solicitar un analisis sanguineo. Un saludo");
        Date fechaEnvio = java.sql.Date.valueOf(LocalDate.of(2024,2,4));
        men1.setFecha_envio(fechaEnvio);
        men1.setLeido(true);
        // Insertamos los mensajes
        mensajeDAO.insertarActualizarMensaje(men1);
        // Mostramos los mensajes
        mensajeDAO.getAllMensajes().forEach(mensaje -> {
            System.out.println(mensaje);
        });

        // Cerramos los entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}
