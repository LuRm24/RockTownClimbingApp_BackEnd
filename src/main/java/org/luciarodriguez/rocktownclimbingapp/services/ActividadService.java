package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Actividad;
import org.luciarodriguez.rocktownclimbingapp.repositories.ActividadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la gestión de actividades en RockTown Climbing.
 *
 * Proporciona métodos de alto nivel para interactuar con la capa de persistencia
 * relacionada con las actividades, facilitando operaciones como la consulta,
 * inserción, búsqueda y eliminación de actividades.
 *
 * Este servicio actúa como intermediario entre los controladores y el repositorio
 * de datos, encapsulando la lógica de negocio asociada a las actividades.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Service
public class ActividadService {

    /** Repositorio de actividades utilizado para interactuar con la base de datos. */
    private final ActividadRepository repo;

    /**
     * Constructor que inyecta el repositorio de actividades.
     *
     * @param repo instancia de {@link ActividadRepository}
     */
    public ActividadService(ActividadRepository repo) {
        this.repo = repo;
    }

    /**
     * Recupera todas las actividades registradas.
     *
     * @return lista de todas las actividades
     */
    public List<Actividad> findAll() {
        return repo.findAll();
    }

    /**
     * Guarda o actualiza una actividad en la base de datos.
     *
     * @param a actividad a guardar
     * @return la actividad guardada
     */
    public Actividad save(Actividad a) {
        return repo.save(a);
    }

    /**
     * Busca una actividad por su identificador.
     *
     * @param id identificador de la actividad
     * @return {@link Optional} con la actividad encontrada, o vacío si no existe
     */
    public Optional<Actividad> findById(Long id) {
        return repo.findById(id);
    }

    /**
     * Elimina una actividad por su identificador si existe.
     *
     * @param id identificador de la actividad a eliminar
     * @return {@code true} si se eliminó correctamente, {@code false} si no existía
     */
    public boolean borrarPorId(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
