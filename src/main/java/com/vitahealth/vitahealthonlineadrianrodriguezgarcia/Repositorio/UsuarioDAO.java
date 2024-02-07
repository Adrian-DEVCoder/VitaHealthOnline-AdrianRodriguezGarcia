package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Usuario;

import java.util.List;

public interface UsuarioDAO {
    public boolean insertarActualizarUsuario(Usuario usuario);
    public List<Usuario> getAllUsuarios();
    public Usuario getUsuario(int id);
    public boolean deleteUsuario(int id);
}
