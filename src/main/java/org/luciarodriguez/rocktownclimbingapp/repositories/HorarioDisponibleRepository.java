package org.luciarodriguez.rocktownclimbingapp.repositories;

import org.luciarodriguez.rocktownclimbingapp.models.HorarioDisponible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad {@link HorarioDisponible}.
 * <p>
 * Proporciona operaciones CRUD para la gestión de los horarios disponibles
 * asociados a actividades en el sistema RockTown Climbing.
 * <p>
 * Esta interfaz extiende {@link JpaRepository}, lo que permite obtener,
 * guardar, actualizar y eliminar instancias de {@code HorarioDisponible}
 * sin necesidad de implementar métodos manualmente.
 * <p>
 * Ideal para gestionar la disponibilidad de clases, eventos o sesiones
 * programadas en el rocódromo.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Repository
public interface HorarioDisponibleRepository extends JpaRepository<HorarioDisponible, Long> {
}
