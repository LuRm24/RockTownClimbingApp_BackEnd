package org.luciarodriguez.rocktownclimbingapp.repositories;

import org.luciarodriguez.rocktownclimbingapp.models.TipoEntrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad {@link TipoEntrada}.
 * <p>
 * Gestiona el acceso a los datos relacionados con los tipos de entrada del sistema RockTown Climbing,
 * incluyendo bonos, cumpleaños, clases u otras modalidades de acceso.
 * <p>
 * Al extender {@link JpaRepository}, hereda todos los métodos necesarios para realizar operaciones
 * CRUD sobre las entradas definidas en la base de datos.
 * <p>
 * Este repositorio puede ampliarse fácilmente para incluir filtros personalizados en el futuro,
 * como búsquedas por tipo, precio o público objetivo.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Repository
public interface TipoEntradaRepository extends JpaRepository<TipoEntrada, Long> {
}
