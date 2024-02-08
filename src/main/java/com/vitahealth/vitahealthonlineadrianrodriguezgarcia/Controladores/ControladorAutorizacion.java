package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Controladores;

//import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.DTO.PacienteDTO;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Paciente;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.Usuario;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Servicios.ServicioPacientes;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Servicios.ServicioUsuarios;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Controller
public class ControladorAutorizacion {

    private final ServicioUsuarios servicioUsuarios;
    private final ServicioPacientes servicioPacientes;

    @Autowired
    public ControladorAutorizacion(ServicioUsuarios servicioUsuarios, ServicioPacientes servicioPacientes) {
        this.servicioUsuarios = servicioUsuarios;
        this.servicioPacientes = servicioPacientes;
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
                        HttpSession session,
                        RedirectAttributes redirectAttributes,
                        Model model) {
        Usuario usuario = servicioUsuarios.findByNombreAndContrasena(username, password);
        if (usuario != null) {
            session.setAttribute("userId", usuario.getId_usuario());
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
    public String editarPerfil(HttpSession session, Model model) throws ParseException {
        int userId = (int) session.getAttribute("userId");
        if (userId != 0) {
            Paciente paciente = servicioPacientes.findByIdUsuario(userId);
            Usuario usuario = servicioUsuarios.findById(userId);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String fechaNacimientoFormatted = formatter.format(paciente.getFecha_nacimiento());
            model.addAttribute("paciente", paciente);
            model.addAttribute("usuario", usuario);
            model.addAttribute("fechaNacimiento", fechaNacimientoFormatted);
            return "perfil_paciente";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/guardarCambios")
    public String guardarCambios(@RequestParam("nombrePaciente") String nombrePaciente,
                                 @RequestParam("apellidosPaciente") String apellidosPaciente,
                                 @RequestParam("fechaNacimiento") String fechaNacimiento,
                                 @RequestParam("sexo") String sexo,
                                 @RequestParam("direccion") String direccion,
                                 @RequestParam("correoElectronico") String correoElectronico,
                                 @RequestParam("telefono") String telefono,
                                 @RequestParam("nombreUsuario") String nombreUsuario,
                                 @RequestParam("contrasena") String contrasena,
                                 HttpSession session,
                                 RedirectAttributes redirectAttributes) throws ParseException {
        int userId = (int) session.getAttribute("userId");
        if(userId != 0){
            Paciente paciente = servicioPacientes.findByIdUsuario(userId);
            Usuario usuario = servicioUsuarios.findById(userId);
            paciente.setNombre_paciente(nombrePaciente);
            paciente.setApellidos_paciente(apellidosPaciente);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNacimientoDate = formatter.parse(fechaNacimiento);
            paciente.setFecha_nacimiento(fechaNacimientoDate);
            paciente.setSexo(sexo);
            paciente.setDireccion(direccion);
            paciente.setCorreo_electronico(correoElectronico);
            paciente.setTelefono(telefono);
            usuario.setNombre(nombreUsuario);
            usuario.setContrasena(contrasena);
            servicioPacientes.registrarPaciente(paciente);
            servicioUsuarios.registrarUsuario(usuario);
            redirectAttributes.addFlashAttribute("successMessage", "Cambios guardados correctamente.");
            return "redirect:/perfil";
        } else {
            return "redirect:/perfil";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        // Lógica para cerrar la sesión del usuario
        return "redirect:/login"; // Redirigir al usuario a la página de inicio de sesión después de cerrar sesión
    }


}
