package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Servicios;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Usuario;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.UsuarioDAO;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.UsuarioDAOImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioUsuarios {

    UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    @Transactional(readOnly = true)
    public Usuario findByNombreAndContrasena(String nombre, String contrasena){
        return usuarioDAO.findByNombreAndContrasena(nombre, contrasena);
    }

    @Transactional
    public void registrarUsuario(Usuario usuario){
        usuarioDAO.insertarActualizarUsuario(usuario);
    }
}
