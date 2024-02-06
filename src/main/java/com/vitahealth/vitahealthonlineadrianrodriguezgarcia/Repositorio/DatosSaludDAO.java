package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.DatosSalud;

import java.util.List;

public interface DatosSaludDAO {
    public boolean insertarActualizarDatosSalud(DatosSalud datosSalud);
    public List<DatosSalud> getAllDatosSalud();
    public DatosSalud getDatosSalud(int id);
    public boolean deleteDatosSalud(int id);
}
