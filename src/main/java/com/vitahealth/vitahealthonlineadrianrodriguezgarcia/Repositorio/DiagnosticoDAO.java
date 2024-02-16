package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio;
import java.util.List;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Diagnostico;

public interface DiagnosticoDAO {
    public boolean insertarActualizarDiagnostico(Diagnostico diagnostico);
    public List<Diagnostico> getAllDiagnosticos();
    public Diagnostico getDiagnostico(int id);
    public boolean deleteDiagnostico(int id);
    public List<Diagnostico> getDiagnosticosByHistorial(int id);
}
