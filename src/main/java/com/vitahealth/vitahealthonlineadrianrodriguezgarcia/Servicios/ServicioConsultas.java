package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Servicios;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Consulta;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.ConsultaDAO;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.ConsultaDAOImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ServicioConsultas {
    ConsultaDAO consultaDAO = new ConsultaDAOImpl();

    @Transactional(readOnly = true)
    public List<Consulta> getConsultasByPaciente(int id){
        return consultaDAO.obtenerConsultasPorPaciente(id);
    }
}
