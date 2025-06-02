package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Empleado;
import org.luciarodriguez.rocktownclimbingapp.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para la gestión de empleados en la aplicación RockTown Climbing.
 * <p>
 * Proporciona endpoints para realizar operaciones CRUD sobre empleados,
 * autenticación (login con verificación de contraseña encriptada),
 * y búsquedas avanzadas por DNI, apellidos o nombre de usuario.
 * <p>
 * Toda la lógica de negocio se delega en el servicio {@link EmpleadoService}.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    /**
     * Obtiene la lista completa de empleados registrados.
     *
     * @return Lista de objetos {@link Empleado}
     */
    @GetMapping("/select-all")
    public List<Empleado> getAll() {
        return service.findAll();
    }

    /**
     * Busca empleados por DNI, apellidos o nombre de usuario.
     * Todos los parámetros son opcionales y se aplican como filtros combinados.
     *
     * @param dni           DNI del empleado (opcional)
     * @param apellidos     Apellidos del empleado (opcional)
     * @param nombreUsuario Nombre de usuario del empleado (opcional)
     * @return Lista de empleados coincidentes
     */
    @GetMapping("/find-employee")
    public List<Empleado> findByDniOrApellidosOrNombreUsuario(
            @RequestParam(required = false) String dni,
            @RequestParam(required = false) String apellidos,
            @RequestParam(required = false) String nombreUsuario) {

        return service.findMultiple(dni, apellidos, nombreUsuario);
    }

    /**
     * Busca un empleado por su identificador.
     *
     * @param id ID del empleado
     * @return Objeto {@link Empleado} si existe, o {@code 404 Not Found} si no se encuentra
     */
    @GetMapping("/find")
    public ResponseEntity<Empleado> findById(@RequestParam Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Autenticación de empleados por nombre de usuario y contraseña.
     * Compara la contraseña introducida (en texto plano) con la almacenada (encriptada con BCrypt).
     *
     * @param loginData Objeto {@link Empleado} con nombre de usuario y contraseña en el cuerpo de la solicitud
     * @return {@code 200 OK} si las credenciales son correctas, o {@code 401 Unauthorized} si no lo son
     */
    @PostMapping("/login")
    public ResponseEntity<Empleado> login(@RequestBody Empleado loginData) {
        Empleado empleado = service.findByNombre(loginData.getNombreUsuario());
        if (empleado != null) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (encoder.matches(loginData.getContrasenaHash(), empleado.getContrasenaHash())) {
                return ResponseEntity.ok(empleado);
            }
        }
        return ResponseEntity.status(401).build(); // No autorizado
    }

    /**
     * Inserta un nuevo empleado en la base de datos.
     *
     * @param empleado Objeto {@link Empleado} a insertar
     * @return {@code true} si se insertó correctamente, {@code false} si no
     */
    @PostMapping("/insert")
    public boolean save(@RequestBody Empleado empleado) {
        Empleado insertado = service.save(empleado);
        return insertado != null;
    }

    /**
     * Elimina un empleado según su ID.
     *
     * @param id ID del empleado a eliminar
     * @return {@code 200 OK} si se eliminó correctamente, o {@code 404 Not Found} si no existe
     */
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

    /**
     * Actualiza un empleado existente con los nuevos datos proporcionados.
     *
     * @param empleadoActualizado Objeto {@link Empleado} con los datos actualizados
     * @return Empleado actualizado con respuesta HTTP {@code 200 OK}
     */
    @PutMapping("/update")
    public ResponseEntity<Empleado> updateEmpleado(@RequestBody Empleado empleadoActualizado) {
        Empleado actualizado = service.updateEmpleado(empleadoActualizado);
        return ResponseEntity.ok(actualizado);
    }
}
