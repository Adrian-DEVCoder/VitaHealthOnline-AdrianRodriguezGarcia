package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "MEDICOS")
public class Medico {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "miSecuencia")
    @SequenceGenerator(name = "miSecuencia", sequenceName = "MEDICOS_SEQ", allocationSize = 1)
    @Id
    private int id_profesional;
    private String nombre_profesional;
    private String apellidos_profesional;
    private String especialidad;
    private String correo_electronico;
    private String telefono;

    public Medico() {
    }

    public Medico(int id_profesional, String nombre_profesional, String apellidos_profesional, String especialidad, String correo_electronico, String telefono) {
        this.id_profesional = id_profesional;
        this.nombre_profesional = nombre_profesional;
        this.apellidos_profesional = apellidos_profesional;
        this.especialidad = especialidad;
        this.correo_electronico = correo_electronico;
        this.telefono = telefono;
    }

    public int getId_profesional() {
        return id_profesional;
    }

    public void setId_profesional(int id_profesional) {
        this.id_profesional = id_profesional;
    }

    public String getNombre_profesional() {
        return nombre_profesional;
    }

    public void setNombre_profesional(String nombre_profesional) {
        this.nombre_profesional = nombre_profesional;
    }

    public String getApellidos_profesional() {
        return apellidos_profesional;
    }

    public void setApellidos_profesional(String apellidos_profesional) {
        this.apellidos_profesional = apellidos_profesional;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Medico{" +
                "id_profesional=" + id_profesional +
                ", nombre_profesional='" + nombre_profesional + '\'' +
                ", apellidos_profesional='" + apellidos_profesional + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", correo_electronico='" + correo_electronico + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
