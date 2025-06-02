package org.luciarodriguez.rocktownclimbingapp.repositories;

import org.luciarodriguez.rocktownclimbingapp.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad {@link Producto}.
 * <p>
 * Proporciona acceso a las operaciones CRUD sobre productos disponibles
 * en el sistema RockTown Climbing, como snacks, bebidas u otros artículos
 * de venta en el centro.
 * <p>
 * Al extender {@link JpaRepository}, hereda todos los métodos necesarios
 * para insertar, consultar, actualizar y eliminar productos de la base de datos.
 * <p>
 * Si en el futuro se requiere lógica de búsqueda personalizada (por nombre,
 * rango de precio, etc.), puede añadirse fácilmente como nuevos métodos.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
