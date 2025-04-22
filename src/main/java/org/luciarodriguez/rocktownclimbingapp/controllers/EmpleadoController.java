package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Empleado;
import org.luciarodriguez.rocktownclimbingapp.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    private final EmpleadoService service;
    public EmpleadoController(EmpleadoService service) { this.service = service; }

    @GetMapping("/select-all")
    public List<Empleado> getAll() { return service.findAll(); }

    @GetMapping("/find-employee")
    public Empleado findByDniOrApellidosOrNombreUsuario(@RequestParam String dni, @RequestParam String apellidos,
                                                       @RequestParam String nombreUsuario){
        return service.findByDniOrApellidosOrNombreUsuario(dni, apellidos, nombreUsuario);
    }

    @GetMapping("/find-and")
    public Long findByNombreAndContrasenaHash(@RequestParam String nombre, @RequestParam String contrasenaHash){
        Empleado empleado =  service.findByNombre(nombre);
        Long idEmp = -1L;

        if (empleado != null) {
            String hashedPassword = empleado.getContrasenaHash();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (encoder.matches(contrasenaHash, hashedPassword)) {
                idEmp = empleado.getId();
            }
        }

        return idEmp;
    }

    @PostMapping("/insert")
    public boolean save(@RequestParam String nombre,
                         @RequestParam String apellidos,
                         @RequestParam String rol,
                         @RequestParam String dni,
                         @RequestParam String direccion,
                         @RequestParam String nombreUsuario,
                         @RequestParam String email,
                         @RequestParam String contrasenaHash) {

        //Encriptar la contraseña antes de guardar
        BCryptPasswordEncoder hashedPassword = new BCryptPasswordEncoder();

        //Crear empleado
        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setApellidos(apellidos);
        empleado.setRol(rol);
        empleado.setDni(dni);
        empleado.setDireccion(direccion);
        empleado.setNombreUsuario(nombreUsuario);
        empleado.setEmail(email);
        empleado.setContrasenaHash(hashedPassword.encode(contrasenaHash));

        Empleado insertado = service.save(empleado);
        return insertado != null;
    }


    @PostMapping("/delete")
    public boolean borrarEmpleado(@RequestParam Long id) {
        Optional<Empleado> empleado = service.findById(id);
        if (empleado.isPresent()) {
            return service.borrarPorId(id);
        } else {
            return false;
        }
    }
}
