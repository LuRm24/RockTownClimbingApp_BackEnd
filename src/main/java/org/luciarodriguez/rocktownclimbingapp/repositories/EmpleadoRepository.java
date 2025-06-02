package org.luciarodriguez.rocktownclimbingapp.repositories;

import org.luciarodriguez.rocktownclimbingapp.models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio JPA para la entidad {@link Empleado}.
 * <p>
 * Gestiona el acceso a los datos de los empleados del sistema RockTown Climbing.
 * Hereda de {@link JpaRepository}, lo que permite realizar operaciones CRUD estándar.
 * <p>
 * Además, define métodos personalizados para búsquedas por campos clave como DNI,
 * apellidos o nombre de usuario.
 * <p>
 * Esta interfaz es utilizada por los servicios para abstraer la lógica de acceso a datos.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    /**
     * Busca empleados cuyo DNI, apellidos o nombre de usuario contengan el texto especificado,
     * ignorando mayúsculas y minúsculas.
     *
     * @param dni           Parte del DNI a buscar (puede ser null o vacío).
     * @param apellidos     Parte de los apellidos a buscar (puede ser null o vacío).
     * @param nombreUsuario Parte del nombre de usuario a buscar (puede ser null o vacío).
     * @return Lista de empleados que coincidan con al menos uno de los criterios.
     */
    List<Empleado> findByDniContainingIgnoreCaseOrApellidosContainingIgnoreCaseOrNombreUsuarioContainingIgnoreCase(
            String dni, String apellidos, String nombreUsuario
    );

    /**
     * Busca un empleado por su nombre de usuario exacto (case-sensitive).
     *
     * @param nombreUsuario Nombre de usuario del empleado.
     * @return El empleado correspondiente o {@code null} si no se encuentra.
     */
    Empleado findByNombreUsuario(String nombreUsuario);
}
