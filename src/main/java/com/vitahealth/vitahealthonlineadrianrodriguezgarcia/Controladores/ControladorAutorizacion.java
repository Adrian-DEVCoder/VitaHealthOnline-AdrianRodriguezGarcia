package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Controladores;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class ControladorAutorizacion {

    @GetMapping("/login")
    public String loginPage() {
        return "iniciarsesion"; // Vista para el formulario de inicio de sesión
    }

    @PostMapping("/login")
    public String login(@RequestParam("usuario") String usuario,
                        @RequestParam("contrasena") String contrasena,
                        RedirectAttributes redirectAttributes) {
        // Lógica para verificar las credenciales del usuario
        if (usuario.equals("usuario_correcto") && contrasena.equals("contrasena_correcta")) {
            // Si las credenciales son válidas, establecer la sesión y redirigir a la página principal
            // Por ejemplo, podrías establecer la sesión utilizando Spring Security
            return "redirect:/pagina_principal";
        } else {
            // Si las credenciales no son válidas, redirigir de nuevo al formulario de inicio de sesión con un mensaje de error
            redirectAttributes.addFlashAttribute("error", true);
            return "redirect:/login";
        }
    }

    @GetMapping("/register")
    public String registerPage() {
        return "registro"; // Vista para el formulario de registro de usuarios
    }

    @PostMapping("/register")
    public String register(@RequestParam("nombre") String nombre,
                           @RequestParam("contrasena") String contrasena,
                           RedirectAttributes redirectAttributes) {
        return null;
    }

    @GetMapping("/logout")
    public String logout() {
        // Lógica para cerrar la sesión del usuario
        return "redirect:/login"; // Redirigir al usuario a la página de inicio de sesión después de cerrar sesión
    }
}
