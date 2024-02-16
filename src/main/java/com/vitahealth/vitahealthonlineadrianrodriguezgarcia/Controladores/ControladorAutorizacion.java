package com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Controladores;

import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Entidades.*;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.DiagnosticoDAO;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.DiagnosticoDAOImpl;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.PacienteDAO;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Repositorio.PacienteDAOImpl;
import com.vitahealth.vitahealthonlineadrianrodriguezgarcia.Servicios.*;
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
import java.util.Date;
import java.util.List;

@Controller
public class ControladorAutorizacion {

    private final PacienteDAO pacienteDAO = new PacienteDAOImpl();
    private final DiagnosticoDAO diagnosticoDAO = new DiagnosticoDAOImpl();
    private final ServicioUsuarios servicioUsuarios;
    private final ServicioPacientes servicioPacientes;
    private final ServicioConsultas servicioConsultas;
    private final ServicioDatosSalud servicioDatosSalud;
    private final ServicioHistorial servicioHistorial;
    private final ServicioDiagnosticos servicioDiagnosticos;

    @Autowired
    public ControladorAutorizacion(ServicioUsuarios servicioUsuarios, ServicioPacientes servicioPacientes, ServicioConsultas servicioConsultas, ServicioDatosSalud servicioDatosSalud, ServicioHistorial servicioHistorial, ServicioDiagnosticos servicioDiagnosticos) {
        this.servicioUsuarios = servicioUsuarios;
        this.servicioPacientes = servicioPacientes;
        this.servicioConsultas = servicioConsultas;
        this.servicioDatosSalud = servicioDatosSalud;
        this.servicioHistorial = servicioHistorial;
        this.servicioDiagnosticos = servicioDiagnosticos;
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

    @GetMapping("/consulta_en_linea")
    public String consultaEnLinea(){
        return "consulta_en_linea";
    }

    @GetMapping("/historial_clinico")
    public String historialClinico(){
        return "historial_clinico";
    }

    @GetMapping("/seguimiento_salud")
    public String seguimientoSalud(){
        return "seguimiento_salud";
    }

    @GetMapping("/mensajes")
    public String mensajes(){
        return "mensajes_paciente";
    }

    @GetMapping("/gestion_pacientes")
    public String gestionPacientes(Model model){
        List<Paciente> pacientes = pacienteDAO.getAllPacientes();
        if (!pacientes.isEmpty()) {
            model.addAttribute("pacientes",pacientes);
        }
        return "gestion_pacientes";
    }

    @GetMapping("/gestion_citas")
    public String gestionCitas(){
        return "gestion_citas";
    }

    @GetMapping("/historial_clinico_medico")
    public String historialClinicoMedicos(){
        return "historial_clinico_medico";
    }

    @GetMapping("/analisis_datos")
    public String analisisDatos(){
        return "analisis_datos";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "iniciarsesion";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "registro";
    }

    @GetMapping("/detalle_paciente")
    public String detallePaciente2(@RequestParam("id") int idPaciente, Model model){
        if(idPaciente != 0){
            Paciente paciente = servicioPacientes.findById(idPaciente);
            List<Consulta> consultas = servicioConsultas.getConsultasByPaciente(idPaciente);
            List<DatosSalud> datosSalud = servicioDatosSalud.getDatosSaludByPaciente(idPaciente);
            Historial historial = servicioHistorial.getHistorialByPacienteWithDiagnosticos(idPaciente);
            if(paciente != null){
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String fechaNacimientoFormatted = formatter.format(paciente.getFecha_nacimiento());
                model.addAttribute("paciente", paciente);
                model.addAttribute("consultas", consultas);
                model.addAttribute("datosSalud", datosSalud);
                model.addAttribute("historial", historial);
                model.addAttribute("fechaNacimiento", fechaNacimientoFormatted);
                for(Consulta con : consultas){
                    String fechaConsulta = formatter.format(con.getFecha_consulta());
                    model.addAttribute("fechaConsulta", fechaConsulta);
                }
                for(DatosSalud dat : datosSalud){
                    String fechaDatosSalud = formatter.format(dat.getFecha_dato());
                    model.addAttribute("fechaDatosSalud", fechaDatosSalud);
                }
                return "detalle_paciente";
            }
        }
        return "redirect:/gestion_pacientes";
    }

    @GetMapping("/noRegistrado")
    public String noRegistrado(){
        return "noRegistrado";
    }

    @GetMapping("/registro_paciente")
    public String registroPaciente(){
        return "registro_paciente";
    }

    @GetMapping("/perfil")
    public String editarPerfil(HttpSession session, Model model) {
        int userId = (int) session.getAttribute("userId");
        if (userId != 0) {
            Paciente paciente = servicioPacientes.findByIdUsuario(userId);
            Usuario usuario = servicioUsuarios.findById(userId);
            if (paciente != null) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String fechaNacimientoFormatted = formatter.format(paciente.getFecha_nacimiento());
                model.addAttribute("paciente", paciente);
                model.addAttribute("usuario", usuario);
                model.addAttribute("fechaNacimiento", fechaNacimientoFormatted);
                return "perfil_paciente";
            } else {
                return "redirect:/noRegistrado";
            }
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }

    @GetMapping("/agregar_registro_historial")
    public String agregarRegistroHistorial(){
        return "agregar_registro_historial";
    }

    @GetMapping("/no_historial")
    public String noHistorial(){
        return "no_historial";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
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

    @PostMapping("/register")
    public String register(@RequestParam("usuario") String nombre,
                           @RequestParam("contrasena") String contrasena,
                           @RequestParam("rol") String rol) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setContrasena(contrasena);
        nuevoUsuario.setRol(rol);
        servicioUsuarios.registrarUsuario(nuevoUsuario);
        return "redirect:/login";
    }

    @PostMapping("/insertarPaciente")
    public String insertarPaciente(@RequestParam("nombrePaciente") String nombrePaciente,
                                   @RequestParam("apellidosPaciente") String apellidosPaciente,
                                   @RequestParam("fechaNacimiento") String fechaNacimiento,
                                   @RequestParam("sexo") String sexo,
                                   @RequestParam("direccion") String direccion,
                                   @RequestParam("correoElectronico") String correoElectronico,
                                   @RequestParam("telefono") String telefono,
                                   HttpSession session,
                                   RedirectAttributes redirectAttributes) throws ParseException {
        int userId = (int) session.getAttribute("userId");
        if(userId != 0){
            Paciente nuevoPaciente = new Paciente();
            Usuario usuarioActual = servicioUsuarios.findById(userId);
            nuevoPaciente.setNombre_paciente(nombrePaciente);
            nuevoPaciente.setApellidos_paciente(apellidosPaciente);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaNacimientoDate = formatter.parse(fechaNacimiento);
            nuevoPaciente.setFecha_nacimiento(fechaNacimientoDate);
            nuevoPaciente.setSexo(sexo);
            nuevoPaciente.setDireccion(direccion);
            nuevoPaciente.setCorreo_electronico(correoElectronico);
            nuevoPaciente.setTelefono(telefono);
            nuevoPaciente.setUsuario(usuarioActual);
            servicioPacientes.registrarPaciente(nuevoPaciente);
            redirectAttributes.addFlashAttribute("successMessage", "Paciente insertado correctamente.");
            return "redirect:/perfil";
        } else {
            return "redirect:/noRegistrado";
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

    @PostMapping("/agregar_registro_historial")
    public String agregarRegistroHistorial2(@RequestParam("idHistorial") String idHistorials,
                                            @RequestParam("idPaciente") String idPaciente,
                                            @RequestParam("diagnostico") String diagnostico,
                                            @RequestParam("tratamiento") String tratamiento,
                                            RedirectAttributes redirectAttributes,
                                            HttpSession session){
        if(!idHistorials.isEmpty()){
            int idHistorial = Integer.parseInt(idHistorials);
            Historial historial = servicioHistorial.findById(idHistorial);
            if(historial != null){
                List<Diagnostico> diagnosticos = servicioDiagnosticos.getDiagnosticoByHistorial(idHistorial);
                Diagnostico nuevoDiagnostico = new Diagnostico();
                nuevoDiagnostico.setDiagnostico(diagnostico);
                nuevoDiagnostico.setTratamiento(tratamiento);
                servicioDiagnosticos.insertarDiagnostico(nuevoDiagnostico);
                diagnosticos.add(nuevoDiagnostico);
                historial.setDiagnosticos(diagnosticos);
                servicioHistorial.insertarHistorial(historial);
                return "redirect:/detalle_paciente";
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "El historial no fue encontrado");
                return "redirect:/gestion_pacientes";
            }
        } else {
            return "redirect:/no_historial?idPaciente="+idPaciente;
        }
    }
}