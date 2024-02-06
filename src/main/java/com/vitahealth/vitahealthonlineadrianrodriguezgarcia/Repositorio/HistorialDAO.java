package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Historial;

import java.util.List;

public interface HistorialDAO {
    public boolean insertarActualizarHistorial(Historial historial);
    public List<Historial> getAllHistoriales();
    public Historial getHistorial(int id);
    public boolean deleteHistorial(int id);
}
