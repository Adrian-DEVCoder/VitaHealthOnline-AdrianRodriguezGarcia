package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Entity
@Table(name = "HISTORIALES")
public class Historial {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "miSecuencia")
    @SequenceGenerator(name = "miSecuencia", sequenceName = "HISTORIALES_SEQ", allocationSize = 1)
    @Id
    private int id_historial;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico")
    private Medico medico;
    private Date fecha_registro;
    private String diagnostico;
    private String tratamiento;
    private String notas;

    public Historial() {
    }

    public Historial(int id_historial, Paciente paciente, Medico medico, Date fecha_registro, String diagnostico, String tratamiento, String notas) {
        this.id_historial = id_historial;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha_registro = fecha_registro;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.notas = notas;
    }

    public int getId_historial() {
        return id_historial;
    }

    public void setId_historial(int id_historial) {
        this.id_historial = id_historial;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
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

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "Historial{" +
                "id_historial=" + id_historial +
                ", paciente=" + paciente +
                ", medico=" + medico +
                ", fecha_registro=" + fecha_registro +
                ", diagnostico='" + diagnostico + '\'' +
                ", tratamiento='" + tratamiento + '\'' +
                ", notas='" + notas + '\'' +
                '}';
    }
}
