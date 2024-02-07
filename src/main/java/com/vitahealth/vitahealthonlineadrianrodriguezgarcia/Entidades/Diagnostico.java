package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "DIAGNOSTICOS")
public class Diagnostico {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "miSecuencia")
    @SequenceGenerator(name = "miSecuencia", sequenceName = "DIAGNOSTICOS_SEQ", allocationSize = 1)
    @Id
    private int id_diagnostico;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_historial")
    private Historial historial;
    private String diagnostico;
    private String tratamiento;

    public Diagnostico() {
    }

    public Diagnostico(int id_diagnostico, Historial historial, String diagnostico, String tratamiento) {
        this.id_diagnostico = id_diagnostico;
        this.historial = historial;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    public int getId_diagnostico() {
        return id_diagnostico;
    }

    public void setId_diagnostico(int id_diagnostico) {
        this.id_diagnostico = id_diagnostico;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    @Override
    public String toString() {
        return "Diagnostico{" +
                "id_diagnostico=" + id_diagnostico +
                ", diagnostico='" + diagnostico + '\'' +
                ", tratamiento='" + tratamiento + '\'' +
                '}';
    }
}
