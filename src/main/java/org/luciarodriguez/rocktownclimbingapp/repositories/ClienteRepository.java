package org.luciarodriguez.rocktownclimbingapp.repositories;

import org.luciarodriguez.rocktownclimbingapp.models.Cliente;
import org.luciarodriguez.rocktownclimbingapp.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByDniContainingIgnoreCaseOrApellidosContainingIgnoreCaseOrTelefonoContainingIgnoreCase(
            String dni, String apellidos, String nombreUsuario
    );

}
