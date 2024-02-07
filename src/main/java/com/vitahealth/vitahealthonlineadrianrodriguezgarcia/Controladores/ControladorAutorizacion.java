package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Controladores;

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

    @GetMapping("/login")
    public String loginPage() {
        return "iniciarsesion"; // Vista para el formulario de inicio de sesión
    }

    @GetMapping("/pagina_medico")
    public String paginaMedico() {
        // Lógica para mostrar la página para médicos
        return "pagina_medico"; // Nombre de la vista para la página de médicos
    }

    @GetMapping("/pagina_paciente")
    public String paginaPaciente() {
        // Lógica para mostrar la página para pacientes
        return "pagina_paciente"; // Nombre de la vista para la página de pacientes
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        RedirectAttributes redirectAttributes,
                        Model model) {
        // Lógica para verificar las credenciales del usuario utilizando el servicio
        Usuario usuario = servicioUsuarios.findByNombreAndContrasena(username, password);
        if (usuario != null) {
            String rol = usuario.getRol();
            if(rol.equalsIgnoreCase("Medico")){
                return "redirect:/pagina_medico";
            } else {
                return "redirect:/pagina_paciente";
            }
        } else {
            // Si las credenciales no son válidas, agregar un mensaje de error al modelo
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            // Devolver la vista de inicio de sesión
            return "iniciarsesion";
        }
    }


    @GetMapping("/register")
    public String registerPage() {
        return "registro"; // Vista para el formulario de registro de usuarios
    }

    @PostMapping("/register")
    public String register(@RequestParam("usuario") String nombre,
                           @RequestParam("contrasena") String contrasena,
                           @RequestParam("rol") String rol,
                           RedirectAttributes redirectAttributes) {
        // Crear un nuevo usuario y guardarlo en la base de datos
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setContrasena(contrasena);
        nuevoUsuario.setRol(rol);
        servicioUsuarios.registrarUsuario(nuevoUsuario);
        // Redirigir al usuario a la página de inicio de sesión después de registrarse
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout() {
        // Lógica para cerrar la sesión del usuario
        return "redirect:/login"; // Redirigir al usuario a la página de inicio de sesión después de cerrar sesión
    }
}
