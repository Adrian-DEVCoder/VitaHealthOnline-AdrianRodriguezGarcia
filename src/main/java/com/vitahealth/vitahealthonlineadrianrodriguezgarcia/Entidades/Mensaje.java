package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Entity
@Table(name = "MENSAJES")
public class Mensaje {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "miSecuencia")
    @SequenceGenerator(name = "miSecuencia", sequenceName = "MENSAJES_SEQ", allocationSize = 1)
    @Id
    private int id_mensaje;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_emisor")
    private Paciente paciente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_receptor")
    private Medico medico;
    private String contenido_mensaje;
    private Date fecha_envio;
    private Boolean isLeido;

    public Mensaje() {
    }

    public Mensaje(int id_mensaje, Paciente paciente, Medico medico, String contenido_mensaje, Date fecha_envio, Boolean isLeido) {
        this.id_mensaje = id_mensaje;
        this.paciente = paciente;
        this.medico = medico;
        this.contenido_mensaje = contenido_mensaje;
        this.fecha_envio = fecha_envio;
        this.isLeido = isLeido;
    }

    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
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

    public String getContenido_mensaje() {
        return contenido_mensaje;
    }

    public void setContenido_mensaje(String contenido_mensaje) {
        this.contenido_mensaje = contenido_mensaje;
    }

    public Date getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(Date fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public Boolean getLeido() {
        return isLeido;
    }

    public void setLeido(Boolean leido) {
        isLeido = leido;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "id_mensaje=" + id_mensaje +
                ", paciente=" + paciente +
                ", medico=" + medico +
                ", contenido_mensaje='" + contenido_mensaje + '\'' +
                ", fecha_envio=" + fecha_envio +
                ", isLeido=" + isLeido +
                '}';
    }
}
