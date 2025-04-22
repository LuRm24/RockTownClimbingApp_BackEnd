package org.luciarodriguez.rocktownclimbingapp.repositories;

import org.luciarodriguez.rocktownclimbingapp.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    Empleado findByNombre(String nombre);
    Empleado findByNombreAndContrasenaHash(String nombre, String contrasenaHash);
    Empleado findByDniOrApellidosOrNombreUsuario(String dni, String apellidos, String nombreUsuario);
}
