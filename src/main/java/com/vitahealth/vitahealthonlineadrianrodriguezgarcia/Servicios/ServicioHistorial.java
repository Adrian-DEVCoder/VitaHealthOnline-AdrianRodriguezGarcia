package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Servicios;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Historial;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.HistorialDAO;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.HistorialDAOImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioHistorial {
    HistorialDAO historialDAO = new HistorialDAOImpl();

    @Transactional(readOnly = true)
    public Historial getHistorialByPacienteWithDiagnosticos(int id){
        return historialDAO.obtenerHistorialPorPacienteConDiagnosticos(id);
    }
}
