package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Entity
@Table(name = "PACIENTES")
public class Paciente {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "miSecuencia")
    @SequenceGenerator(name = "miSecuencia", sequenceName = "PACIENTES_SEQ", allocationSize = 1)
    @Id
    private int id_paciente;
    private String nombre_paciente;
    private String apellidos_paciente;
    private Date fecha_nacimiento;
    private String sexo;
    private String direccion;
    private String correo_electronico;
    private String telefono;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;
    @OneToMany(mappedBy = "paciente")
    private List<Historial> historiales;
    @OneToMany(mappedBy = "paciente")

    private List<DatosSalud> datosSalud;

    public Paciente() {
    }

    public Paciente(int id_paciente, String nombre_paciente, String apellidos_paciente, Date fecha_nacimiento, String sexo, String direccion, String correo_electronico, String telefono, Usuario usuario, List<Consulta> consultas, List<Historial> historiales, List<DatosSalud> datosSalud) {
        this.id_paciente = id_paciente;
        this.nombre_paciente = nombre_paciente;
        this.apellidos_paciente = apellidos_paciente;
        this.fecha_nacimiento = fecha_nacimiento;
        this.sexo = sexo;
        this.direccion = direccion;
        this.correo_electronico = correo_electronico;
        this.telefono = telefono;
        this.usuario = usuario;
        this.consultas = consultas;
        this.historiales = historiales;
        this.datosSalud = datosSalud;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getApellidos_paciente() {
        return apellidos_paciente;
    }

    public void setApellidos_paciente(String apellidos_paciente) {
        this.apellidos_paciente = apellidos_paciente;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<Historial> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(List<Historial> historiales) {
        this.historiales = historiales;
    }

    public List<DatosSalud> getDatosSalud() {
        return datosSalud;
    }

    public void setDatosSalud(List<DatosSalud> datosSalud) {
        this.datosSalud = datosSalud;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id_paciente=" + id_paciente +
                ", nombre_paciente='" + nombre_paciente + '\'' +
                ", apellidos_paciente='" + apellidos_paciente + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", sexo='" + sexo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", correo_electronico='" + correo_electronico + '\'' +
                ", telefono='" + telefono + '\'' +
                ", usuario=" + usuario +
                ", consultas=" + consultas +
                ", historiales=" + historiales +
                ", datosSalud=" + datosSalud +
                '}';
    }
}
