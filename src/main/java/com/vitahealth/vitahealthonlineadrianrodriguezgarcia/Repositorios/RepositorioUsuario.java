package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorios;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
    Usuario findByNombre(String nombre);
    Usuario findByNombreAndContrasena(String nombre, String contrasena);
}
