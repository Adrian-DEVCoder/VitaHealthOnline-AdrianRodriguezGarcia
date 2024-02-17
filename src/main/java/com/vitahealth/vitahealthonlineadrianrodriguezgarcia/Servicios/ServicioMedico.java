package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Servicios;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Medico;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.MedicoDAO;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.MedicoDAOImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicioMedico {
    MedicoDAO medicoDAO = new MedicoDAOImpl();

    @Transactional
    public void insertarMedico(Medico medico){
        medicoDAO.insertarActualizarMedico(medico);
    }

    @Transactional(readOnly = true)
    public boolean tieneDatosRegistrados(int userId) {
        return medicoDAO.getMedicoByUsuario(userId) != null;
    }

    @Transactional(readOnly = true)
    public Medico getMedicoById(int id){
        return medicoDAO.getMedico(id);
    }

    @Transactional(readOnly = true)
    public List<Medico> getAllMedicos(){
        return medicoDAO.getAllMedicos();
    }
}
