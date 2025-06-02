package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Producto;
import org.luciarodriguez.rocktownclimbingapp.repositories.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de gestionar las operaciones relacionadas con los productos
 * disponibles en el sistema RockTown Climbing.
 * <p>
 * Proporciona acceso a la consulta de todos los productos registrados.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Service
public class ProductoService {

    /**
     * Repositorio para acceder a los datos de productos.
     */
    private final ProductoRepository repo;

    /**
     * Constructor que inyecta el repositorio de productos.
     *
     * @param repo repositorio de productos
     */
    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    /**
     * Devuelve una lista con todos los productos registrados en la base de datos.
     *
     * @return lista de objetos {@link Producto}
     */
    public List<Producto> findAll() {
        return repo.findAll();
    }
}
