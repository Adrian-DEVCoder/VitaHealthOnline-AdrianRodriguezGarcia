package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Servicios;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Diagnostico;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.DiagnosticoDAO;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.DiagnosticoDAOImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicioDiagnosticos {
    DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAOImpl();

    @Transactional(readOnly = true)
    public List<Diagnostico> getDiagnosticoByHistorial(int id){
        return diagnosticoDAO.getDiagnosticosByHistorial(id);
    }

    @Transactional
    public void insertarDiagnostico(Diagnostico diagnostico){
        diagnosticoDAO.insertarActualizarDiagnostico(diagnostico);
    }
}
