package org.luciarodriguez.rocktownclimbingapp.repositories;

import org.luciarodriguez.rocktownclimbingapp.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {


    List<Empleado> findByDniContainingIgnoreCaseOrApellidosContainingIgnoreCaseOrNombreUsuarioContainingIgnoreCase(
            String dni, String apellidos, String nombreUsuario
    );
    Empleado findByNombreUsuario(String nombreUsuario);

}
