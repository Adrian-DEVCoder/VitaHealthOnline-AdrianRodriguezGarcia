package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Consulta;

import java.util.List;

public interface ConsultaDAO {
    public boolean insertarActualizarConsulta(Consulta consulta);
    public List<Consulta> getAllConsultas();
    public Consulta getConsulta(int id);
    public boolean deleteConsulta(int id);
    public List<Consulta> obtenerConsultasPorPaciente(int id);
}
