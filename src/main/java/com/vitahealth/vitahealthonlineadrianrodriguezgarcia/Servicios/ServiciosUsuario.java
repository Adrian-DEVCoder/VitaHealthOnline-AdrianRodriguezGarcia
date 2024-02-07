package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Servicios;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Usuario;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosUsuario {

    private final RepositorioUsuario repositorioUsuario;

    @Autowired
    public ServiciosUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Usuario findByNombre(String nombre) {
        return repositorioUsuario.findByNombre(nombre);
    }

    public void registrarUsuario(Usuario usuario) {
        // Lógica para registrar al usuario en la base de datos
        repositorioUsuario.save(usuario);
    }
}
