package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Entity
@Table(name = "DATOSSALUD")
public class DatosSalud {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "miSecuencia")
    @SequenceGenerator(name = "miSecuencia", sequenceName = "DATOS_SEQ", allocationSize = 1)
    @Id
    private int id_dato;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    private Date fecha_dato;
    private String tipo_dato;
    private String valor_dato;
    private String unidad_medida;

    public DatosSalud() {
    }

    public DatosSalud(int id_dato, Paciente paciente, Date fecha_dato, String tipo_dato, String valor_dato, String unidad_medida) {
        this.id_dato = id_dato;
        this.paciente = paciente;
        this.fecha_dato = fecha_dato;
        this.tipo_dato = tipo_dato;
        this.valor_dato = valor_dato;
        this.unidad_medida = unidad_medida;
    }

    public int getId_dato() {
        return id_dato;
    }

    public void setId_dato(int id_dato) {
        this.id_dato = id_dato;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFecha_dato() {
        return fecha_dato;
    }

    public void setFecha_dato(Date fecha_dato) {
        this.fecha_dato = fecha_dato;
    }

    public String getTipo_dato() {
        return tipo_dato;
    }

    public void setTipo_dato(String tipo_dato) {
        this.tipo_dato = tipo_dato;
    }

    public String getValor_dato() {
        return valor_dato;
    }

    public void setValor_dato(String valor_dato) {
        this.valor_dato = valor_dato;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    @Override
    public String toString() {
        return "DatosSalud{" +
                "id_dato=" + id_dato +
                ", paciente=" + paciente +
                ", fecha_dato=" + fecha_dato +
                ", tipo_dato='" + tipo_dato + '\'' +
                ", valor_dato='" + valor_dato + '\'' +
                ", unidad_medida='" + unidad_medida + '\'' +
                '}';
    }
}
