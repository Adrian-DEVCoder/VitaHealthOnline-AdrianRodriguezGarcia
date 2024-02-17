package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Servicios;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Paciente;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.PacienteDAO;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.PacienteDAOImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicioPacientes {

    PacienteDAO pacienteDAO = new PacienteDAOImpl();
    @Transactional(readOnly = true)
    public Paciente findById(int id){
        return pacienteDAO.getPaciente(id);
    }

    @Transactional(readOnly = true)
    public Paciente findByIdUsuario(int id){
        return pacienteDAO.getPacienteByIdUsuario(id);
    }

    @Transactional
    public void registrarPaciente(Paciente paciente){
        pacienteDAO.insertarActualizarPaciente(paciente);
    }

    @Transactional(readOnly = true)
    public List<Paciente> getAllPacientes(){
        return pacienteDAO.getAllPacientes();
    }
}
