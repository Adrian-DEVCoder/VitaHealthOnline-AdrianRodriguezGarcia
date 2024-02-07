package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Controladores;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Usuario;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Servicios.ServiciosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControladorAutorizacion {

    private final ServiciosUsuario usuarioServicio;

    @Autowired
    public ControladorAutorizacion(ServiciosUsuario usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @GetMapping("/login")
    public String mostrarFormularioLogin(Model model) {
        model.addAttribute("error", false);
        return "login";
    }

    @PostMapping("/login")
    public String iniciarSesion(@RequestParam("usuario") String usuario,
                                @RequestParam("contrasena") String contrasena,
                                RedirectAttributes redirectAttributes) {
        // Lógica para verificar las credenciales del usuario
        Usuario user = usuarioServicio.findByNombre(usuario);
        if (user != null && user.getContrasena().equals(contrasena)) {
            return "redirect:/pagina_principal";
        } else {
            redirectAttributes.addFlashAttribute("error", true);
            return "redirect:/login";
        }
    }

    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("registroExitoso", false);
        return "registro";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@RequestParam("usuario") String usuario,
                                   @RequestParam("contrasena") String contrasena,
                                   @RequestParam("rol") String rol,
                                   RedirectAttributes redirectAttributes) {
        // Lógica para registrar al usuario en la base de datos
        Usuario nuevoUsuario = new Usuario(usuario, contrasena,rol); // Aquí debes especificar el rol
        usuarioServicio.registrarUsuario(nuevoUsuario);
        redirectAttributes.addFlashAttribute("registroExitoso", true);
        return "redirect:/login";
    }
}
