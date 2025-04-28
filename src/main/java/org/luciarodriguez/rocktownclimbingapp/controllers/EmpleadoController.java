package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Empleado;
import org.luciarodriguez.rocktownclimbingapp.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<Empleado> findByDniOrApellidosOrNombreUsuario(
            @RequestParam(required = false) String dni,
            @RequestParam(required = false) String apellidos,
            @RequestParam(required = false) String nombreUsuario) {

        return service.findMultiple(dni, apellidos, nombreUsuario);
    }

    @GetMapping("/find")
    public Empleado findById(
            @RequestParam(required = false) Long id) {
        Optional<Empleado> empleado = service.findById(id);
        return empleado.get();
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
    public boolean save(@RequestBody Empleado empleado) {
        Empleado insertado = service.save(empleado);
        return insertado != null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarEmpleado(@PathVariable Long id) {
        Optional<Empleado> empleado = service.findById(id);
        if (empleado.isPresent()) {
            service.borrarPorId(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
