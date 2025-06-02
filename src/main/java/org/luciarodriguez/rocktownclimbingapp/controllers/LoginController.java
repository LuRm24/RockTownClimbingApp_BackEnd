package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.DTO.LoginRequest;
import org.luciarodriguez.rocktownclimbingapp.models.Empleado;
import org.luciarodriguez.rocktownclimbingapp.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST encargado del proceso de autenticación de empleados.
 * <p>
 * Este controlador proporciona un único endpoint para realizar el login,
 * validando el nombre de usuario y la contraseña recibidos en una solicitud
 * con formato JSON. La verificación de la contraseña se realiza utilizando
 * BCrypt para comparar hashes de forma segura.
 * <p>
 * Si las credenciales son válidas, devuelve una respuesta textual que indica el resultado del acceso.
 * <p>
 * Este endpoint se utiliza como parte del flujo de autenticación en la aplicación RockTown Climbing.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@RestController
public class LoginController {

    /**
     * Repositorio que permite acceder a los datos de los empleados.
     */
    @Autowired
    private EmpleadoRepository empleadoRepository;

    /**
     * Codificador de contraseñas basado en el algoritmo BCrypt.
     * Se utiliza para verificar si la contraseña introducida coincide con el hash almacenado.
     */
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * Endpoint para autenticar a un empleado mediante nombre de usuario y contraseña.
     * <p>
     * Verifica que ambos campos no estén vacíos, busca el empleado en la base de datos
     * y compara la contraseña proporcionada con la almacenada.
     *
     * @param request Objeto {@link LoginRequest} que contiene el nombre de usuario y la contraseña
     * @return Cadena de texto indicando el resultado: "ACCESO CONCEDIDO", "ACCESO DENEGADO" o "DATOS INVALIDOS"
     */
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
