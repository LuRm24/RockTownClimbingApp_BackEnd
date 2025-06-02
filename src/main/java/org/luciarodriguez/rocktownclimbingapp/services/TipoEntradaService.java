package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.TipoEntrada;
import org.luciarodriguez.rocktownclimbingapp.repositories.TipoEntradaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de gestionar la lógica de negocio relacionada con los distintos
 * tipos de entrada (bonos, clases, cumpleaños, etc.) ofrecidos por RockTown Climbing.
 * <p>
 * Permite consultar y guardar tipos de entrada en la base de datos.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Service
public class TipoEntradaService {

    /**
     * Repositorio encargado del acceso a datos de los tipos de entrada.
     */
    private final TipoEntradaRepository repo;

    /**
     * Constructor que inyecta el repositorio de tipos de entrada.
     *
     * @param repo repositorio de tipos de entrada
     */
    public TipoEntradaService(TipoEntradaRepository repo) {
        this.repo = repo;
    }

    /**
     * Recupera todos los tipos de entrada disponibles en la base de datos.
     *
     * @return lista de objetos {@link TipoEntrada}
     */
    public List<TipoEntrada> findAll() {
        return repo.findAll();
    }

    /**
     * Guarda un nuevo tipo de entrada o actualiza uno existente.
     *
     * @param a objeto {@link TipoEntrada} a guardar
     * @return el tipo de entrada guardado
     */
    public TipoEntrada save(TipoEntrada a) {
        return repo.save(a);
    }
}
