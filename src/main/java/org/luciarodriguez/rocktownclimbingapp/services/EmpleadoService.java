package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Empleado;
import org.luciarodriguez.rocktownclimbingapp.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Empleado findByNombre(String nombre) {
        return repo.findByNombre(nombre);
    }

    public Optional<Empleado> findById(Long id) {
        return repo.findById(id);
    }

    public Empleado findByNombreAndContrasenaHash(String nombre, String constrasenaHash){
        return repo.findByNombreAndContrasenaHash(nombre, constrasenaHash);
    }

    public Empleado findByDniOrApellidosOrNombreUsuario(String dni, String apellidos, String nombreUsuario) {
        return repo.findByDniOrApellidosOrNombreUsuario(dni, apellidos, nombreUsuario);
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
}
