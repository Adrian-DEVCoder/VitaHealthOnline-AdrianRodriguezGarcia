package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Paciente;

import java.util.List;

public interface PacienteDAO {
    public boolean insertarActualizarPaciente(Paciente paciente);
    public List<Paciente> getAllPacientes();
    public Paciente getPaciente(int id);
    public boolean deletePaciente(int id);
    public Paciente getPacienteByIdUsuario(int idUsuario);
}
