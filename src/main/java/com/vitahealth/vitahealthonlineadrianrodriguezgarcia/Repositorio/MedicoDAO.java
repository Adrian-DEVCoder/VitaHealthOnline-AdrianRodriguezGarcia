package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Medico;

import java.util.List;

public interface MedicoDAO {
    public boolean insertarActualizarMedico(Medico medico);
    public List<Medico> getAllMedicos();
    public Medico getMedico(int id);
    public boolean deleteMedico(int id);
}
