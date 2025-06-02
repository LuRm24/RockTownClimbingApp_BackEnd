package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Empleado;
import org.luciarodriguez.rocktownclimbingapp.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que gestiona las operaciones relacionadas con los empleados
 * dentro del sistema RockTown Climbing.
 * <p>
 * Proporciona funcionalidades para consultar, registrar, actualizar y eliminar empleados,
 * además de búsquedas filtradas y gestión de credenciales de acceso.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Service
public class EmpleadoService {

    /**
     * Repositorio de persistencia para empleados.
     */
    private final EmpleadoRepository repo;

    /**
     * Constructor con inyección del repositorio.
     *
     * @param repo instancia del repositorio de empleados
     */
    @Autowired
    public EmpleadoService(EmpleadoRepository repo) {
        this.repo = repo;
    }

    /**
     * Busca un empleado por su nombre de usuario.
     *
     * @param nombreUsuario nombre de usuario del empleado
     * @return empleado correspondiente o {@code null} si no existe
     */
    public Empleado findByNombre(String nombreUsuario) {
        return repo.findByNombreUsuario(nombreUsuario);
    }

    /**
     * Busca un empleado por su identificador.
     *
     * @param id ID del empleado
     * @return un {@link Optional} que puede contener el empleado o estar vacío
     */
    public Optional<Empleado> findById(Long id) {
        return repo.findById(id);
    }

    /**
     * Busca empleados cuyo DNI, apellidos o nombre de usuario contengan los textos indicados (ignorando mayúsculas).
     *
     * @param dni           parte del DNI
     * @param apellidos     parte de los apellidos
     * @param nombreUsuario parte del nombre de usuario
     * @return lista de empleados que coincidan con al menos uno de los criterios
     */
    public List<Empleado> findMultiple(String dni, String apellidos, String nombreUsuario) {
        return repo.findByDniContainingIgnoreCaseOrApellidosContainingIgnoreCaseOrNombreUsuarioContainingIgnoreCase(
                dni, apellidos, nombreUsuario
        );
    }

    /**
     * Devuelve todos los empleados registrados en el sistema.
     *
     * @return lista completa de empleados
     */
    public List<Empleado> findAll() {
        return repo.findAll();
    }

    /**
     * Guarda un nuevo empleado o actualiza uno existente.
     *
     * @param emp objeto empleado a guardar
     * @return el empleado guardado
     */
    public Empleado save(Empleado emp) {
        return repo.save(emp);
    }

    /**
     * Elimina un empleado a partir de su ID.
     *
     * @param id identificador del empleado
     * @return {@code true} si fue eliminado, {@code false} si no existía
     */
    public boolean borrarPorId(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Actualiza los campos editables de un empleado ya existente.
     * Si se proporciona una nueva contraseña, esta se encripta antes de guardarla.
     *
     * @param empleado objeto con los nuevos datos
     * @return empleado actualizado
     * @throws RuntimeException si el empleado no existe
     */
    public Empleado updateEmpleado(Empleado empleado) {
        Empleado empleadoExistente = repo.findById(empleado.getId())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        empleadoExistente.setNombre(empleado.getNombre());
        empleadoExistente.setApellidos(empleado.getApellidos());
        empleadoExistente.setDireccion(empleado.getDireccion());
        empleadoExistente.setDni(empleado.getDni());
        empleadoExistente.setEmail(empleado.getEmail());
        empleadoExistente.setNombreUsuario(empleado.getNombreUsuario());
        empleadoExistente.setRol(empleado.getRol());
        empleadoExistente.setTelefono(empleado.getTelefono());

        // Encriptar nueva contraseña si se ha especificado
        if (empleado.getContrasenaHash() != null && !empleado.getContrasenaHash().isBlank()) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String contrasenaHasheada = encoder.encode(empleado.getContrasenaHash());
            empleadoExistente.setContrasenaHash(contrasenaHasheada);
        }

        return repo.save(empleadoExistente);
    }
}
