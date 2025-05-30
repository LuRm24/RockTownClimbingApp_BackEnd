package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.DTO.LoginRequest;
import org.luciarodriguez.rocktownclimbingapp.models.Empleado;
import org.luciarodriguez.rocktownclimbingapp.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        if (request.getNombreUsuario() == null || request.getContrasena() == null ||
                request.getNombreUsuario().isBlank() || request.getContrasena().isBlank()) {
            return "DATOS INVALIDOS";
        }

        Empleado empleado = empleadoRepository.findByNombreUsuario(request.getNombreUsuario());


        if (empleado != null && passwordEncoder.matches(request.getContrasena(), empleado.getContrasenaHash())) {
            return "ACCESO CONCEDIDO";
        } else {
            return "ACCESO DENEGADO";
        }
    }

}
