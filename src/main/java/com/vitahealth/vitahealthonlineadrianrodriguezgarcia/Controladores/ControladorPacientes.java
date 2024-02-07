package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ControladorPacientes {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
