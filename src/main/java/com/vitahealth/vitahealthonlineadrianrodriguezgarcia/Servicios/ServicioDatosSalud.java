package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Servicios;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.DatosSalud;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.DatosSaludDAO;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.DatosSaludDAOImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicioDatosSalud {
    DatosSaludDAO datosSaludDAO = new DatosSaludDAOImpl();

    @Transactional(readOnly = true)
    public List<DatosSalud> getDatosSaludByPaciente(int id){
        return datosSaludDAO.obtenerDatosSaludPorPaciente(id);
    }
}
