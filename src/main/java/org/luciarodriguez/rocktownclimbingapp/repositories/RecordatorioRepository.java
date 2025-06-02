package org.luciarodriguez.rocktownclimbingapp.repositories;

import org.luciarodriguez.rocktownclimbingapp.models.Recordatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio JPA para la entidad {@link Recordatorio}.
 * <p>
 * Permite realizar operaciones CRUD sobre los recordatorios del sistema RockTown Climbing.
 * Cada recordatorio está vinculado a un {@link org.luciarodriguez.rocktownclimbingapp.models.Empleado},
 * y esta interfaz proporciona métodos para consultar los recordatorios por dicho vínculo.
 * <p>
 * Extiende {@link JpaRepository}, por lo que hereda todos los métodos básicos de persistencia.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Repository
public interface RecordatorioRepository extends JpaRepository<Recordatorio, Long> {

    /**
     * Devuelve una lista de recordatorios asociados a un empleado específico.
     *
     * @param empleadoId ID del empleado.
     * @return Lista de recordatorios correspondientes al empleado.
     */
    List<Recordatorio> findByEmpleado_Id(Long empleadoId);

}
