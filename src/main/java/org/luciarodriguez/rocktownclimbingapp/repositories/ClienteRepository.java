package org.luciarodriguez.rocktownclimbingapp.repositories;

import org.luciarodriguez.rocktownclimbingapp.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio JPA para la entidad {@link Cliente}.
 * <p>
 * Permite realizar operaciones CRUD sobre los clientes registrados en
 * el sistema del rocódromo RockTown Climbing, así como búsquedas
 * personalizadas mediante consultas derivadas.
 * <p>
 * Extiende {@link JpaRepository}, lo que proporciona acceso directo a
 * operaciones comunes sin necesidad de implementación manual.
 * <p>
 * Incluye un método personalizado para buscar clientes por DNI, apellidos o teléfono,
 * ignorando mayúsculas y minúsculas y permitiendo coincidencias parciales.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    /**
     * Busca clientes cuyo DNI, apellidos o teléfono contengan una subcadena específica,
     * ignorando mayúsculas y minúsculas.
     *
     * @param dni           Parte del DNI a buscar (puede ser null o vacío).
     * @param apellidos     Parte de los apellidos a buscar (puede ser null o vacío).
     * @param nombreUsuario Parte del número de teléfono a buscar (puede ser null o vacío).
     * @return Lista de clientes que coinciden con al menos uno de los criterios.
     */
    List<Cliente> findByDniContainingIgnoreCaseOrApellidosContainingIgnoreCaseOrTelefonoContainingIgnoreCase(
            String dni, String apellidos, String nombreUsuario
    );
}
