package org.luciarodriguez.rocktownclimbingapp.repositories;

import org.luciarodriguez.rocktownclimbingapp.models.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad {@link Actividad}.
 * <p>
 * Proporciona acceso a operaciones CRUD sobre actividades registradas
 * en el sistema del rocódromo RockTown Climbing.
 * <p>
 * Esta interfaz extiende {@link JpaRepository}, lo que permite realizar
 * búsquedas, inserciones, actualizaciones y eliminaciones sin necesidad
 * de implementar manualmente los métodos.
 * <p>
 * Puedes añadir consultas personalizadas si se requiere una lógica de búsqueda avanzada.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {
}
