package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControladorAutorizacion {
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("usuario") String usuario, @RequestParam("contrasena") String contrasena, RedirectAttributes redirectAttributes){
        // Logica para verificar las credenciales del usuario
        if (usuario.equals("usuario_correcto") && contrasena.equals("contrasena_correcta")) {
            return "redirect:/pagina_principal";
        } else {
            redirectAttributes.addFlashAttribute("error", true);
            return "redirect:/login";
        }
    }
}
