package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Mensaje;

import java.util.List;

public interface MensajeDAO {
    public boolean insertarActualizarMensaje(Mensaje mensaje);
    public List<Mensaje> getAllMensajes();
    public Mensaje getMensaje(int id);
    public boolean deleteMensaje(int id);
}
