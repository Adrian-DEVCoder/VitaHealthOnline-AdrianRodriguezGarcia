package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Controladores;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.DTO.PacienteDTO;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Usuario;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Servicios.ServicioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class ControladorAutorizacion {

    private final ServicioUsuarios servicioUsuarios;

    @Autowired
    public ControladorAutorizacion(ServicioUsuarios servicioUsuarios) {
        this.servicioUsuarios = servicioUsuarios;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/pagina_medico")
    public String paginaMedico() {
        return "pagina_medico";
    }

    @GetMapping("/pagina_paciente")
    public String paginaPaciente() {
        return "pagina_paciente";
    }

    // Mapeo para el logueo
    @GetMapping("/login")
    public String loginPage() {
        return "iniciarsesion";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        RedirectAttributes redirectAttributes,
                        Model model) {
        Usuario usuario = servicioUsuarios.findByNombreAndContrasena(username, password);
        if (usuario != null) {
            String rol = usuario.getRol();
            if(rol.equalsIgnoreCase("Medico")){
                return "redirect:/pagina_medico";
            } else {
                return "redirect:/pagina_paciente";
            }
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "iniciarsesion";
        }
    }

    // Mapeo para el registro
    @GetMapping("/register")
    public String registerPage() {
        return "registro";
    }

    @PostMapping("/register")
    public String register(@RequestParam("usuario") String nombre,
                           @RequestParam("contrasena") String contrasena,
                           @RequestParam("rol") String rol,
                           RedirectAttributes redirectAttributes) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setContrasena(contrasena);
        nuevoUsuario.setRol(rol);
        servicioUsuarios.registrarUsuario(nuevoUsuario);
        return "redirect:/login";
    }

    @GetMapping("/perfil")
    public String editarPerfil() {
        // Devuelves la vista de edición de perfil
        return "perfil_paciente";
    }


    @GetMapping("/logout")
    public String logout() {
        // Lógica para cerrar la sesión del usuario
        return "redirect:/login"; // Redirigir al usuario a la página de inicio de sesión después de cerrar sesión
    }


}
