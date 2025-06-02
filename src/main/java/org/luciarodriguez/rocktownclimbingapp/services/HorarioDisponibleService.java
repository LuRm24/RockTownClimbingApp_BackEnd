package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.HorarioDisponible;
import org.luciarodriguez.rocktownclimbingapp.repositories.HorarioDisponibleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que gestiona las operaciones relacionadas con los horarios disponibles
 * de las actividades en el sistema RockTown Climbing.
 * <p>
 * Permite consultar, guardar, buscar por ID y eliminar horarios.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Service
public class HorarioDisponibleService {

    /**
     * Repositorio para operaciones de persistencia sobre horarios disponibles.
     */
    private final HorarioDisponibleRepository repo;

    /**
     * Constructor que inyecta el repositorio.
     *
     * @param repo repositorio de horarios disponibles
     */
    public HorarioDisponibleService(HorarioDisponibleRepository repo) {
        this.repo = repo;
    }

    /**
     * Obtiene la lista completa de horarios disponibles registrados.
     *
     * @return lista de objetos {@link HorarioDisponible}
     */
    public List<HorarioDisponible> findAll() {
        return repo.findAll();
    }

    /**
     * Guarda o actualiza un horario disponible.
     *
     * @param h objeto horario a guardar
     * @return el horario guardado
     */
    public HorarioDisponible save(HorarioDisponible h) {
        return repo.save(h);
    }

    /**
     * Busca un horario disponible por su identificador.
     *
     * @param id ID del horario
     * @return un {@link Optional} que puede contener el horario o estar vacío
     */
    public Optional<HorarioDisponible> findById(Long id) {
        return repo.findById(id);
    }

    /**
     * Elimina un horario disponible por su identificador, si existe.
     *
     * @param id ID del horario a eliminar
     * @return {@code true} si fue eliminado, {@code false} si no existía
     */
    public boolean borrarPorId(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
