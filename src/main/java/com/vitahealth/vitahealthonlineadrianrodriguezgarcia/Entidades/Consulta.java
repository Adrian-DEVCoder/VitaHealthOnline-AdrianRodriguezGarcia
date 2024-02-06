package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Entity
@Table(name = "CONSULTAS")
public class Consulta {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "miSecuencia")
    @SequenceGenerator(name = "miSecuencia", sequenceName = "CONSULTAS_SEQ", allocationSize = 1)
    @Id
    private int id_consulta;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico")
    private Medico medico;
    private Date fecha_consulta;
    private String tipo_consulta;
    private String estado_consulta;

    public Consulta() {
    }

    public Consulta(int id_consulta, Paciente paciente, Medico medico, Date fecha_consulta, String tipo_consulta, String estado_consulta) {
        this.id_consulta = id_consulta;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha_consulta = fecha_consulta;
        this.tipo_consulta = tipo_consulta;
        this.estado_consulta = estado_consulta;
    }

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
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

    public Date getFecha_consulta() {
        return fecha_consulta;
    }

    public void setFecha_consulta(Date fecha_consulta) {
        this.fecha_consulta = fecha_consulta;
    }

    public String getTipo_consulta() {
        return tipo_consulta;
    }

    public void setTipo_consulta(String tipo_consulta) {
        this.tipo_consulta = tipo_consulta;
    }

    public String getEstado_consulta() {
        return estado_consulta;
    }

    public void setEstado_consulta(String estado_consulta) {
        this.estado_consulta = estado_consulta;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id_consulta=" + id_consulta +
                ", paciente=" + paciente +
                ", medico=" + medico +
                ", fecha_consulta=" + fecha_consulta +
                ", tipo_consulta='" + tipo_consulta + '\'' +
                ", estado_consulta='" + estado_consulta + '\'' +
                '}';
    }
}
