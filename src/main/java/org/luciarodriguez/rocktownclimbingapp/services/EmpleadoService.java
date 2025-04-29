package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Empleado;
import org.luciarodriguez.rocktownclimbingapp.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    private final EmpleadoRepository repo;

    @Autowired
    public EmpleadoService(EmpleadoRepository repo) {

        this.repo = repo;
    }

    public Empleado findByNombre(String nombreUsuario) {
        return repo.findByNombreUsuario(nombreUsuario);
    }


    public Optional<Empleado> findById(Long id) {
        return repo.findById(id);
    }

    public List<Empleado> findMultiple(String dni, String apellidos, String nombreUsuario) {
        return repo.findByDniContainingIgnoreCaseOrApellidosContainingIgnoreCaseOrNombreUsuarioContainingIgnoreCase(
                dni, apellidos, nombreUsuario
        );
    }

    public List<Empleado> findAll() {
        return repo.findAll();
    }

    public Empleado save(Empleado emp) {
        return repo.save(emp);
    }

    public boolean borrarPorId(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    public Empleado updateEmpleado(Empleado empleado) {
            Empleado empleadoExistente = repo.findById(empleado.getId())
                    .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

            // Actualizamos campos editables
            empleadoExistente.setNombre(empleado.getNombre());
            empleadoExistente.setApellidos(empleado.getApellidos());
            empleadoExistente.setDireccion(empleado.getDireccion());
            empleadoExistente.setDni(empleado.getDni());
            empleadoExistente.setEmail(empleado.getEmail());
            empleadoExistente.setNombreUsuario(empleado.getNombreUsuario());
            empleadoExistente.setRol(empleado.getRol());
            empleadoExistente.setTelefono(empleado.getTelefono());

            // Si la contraseña viene nueva, la actualizamos hasheada
            if (empleado.getContrasenaHash() != null && !empleado.getContrasenaHash().isBlank()) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                String contrasenaHasheada = encoder.encode(empleado.getContrasenaHash());
                empleadoExistente.setContrasenaHash(contrasenaHasheada);
            }

            return repo.save(empleadoExistente);
    }


}
