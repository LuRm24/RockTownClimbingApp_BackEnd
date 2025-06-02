package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Recordatorio;
import org.luciarodriguez.rocktownclimbingapp.repositories.RecordatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado de gestionar la lógica de negocio relacionada con los recordatorios
 * del sistema RockTown Climbing.
 * <p>
 * Permite realizar operaciones CRUD sobre los recordatorios asociados a los empleados.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Service
public class RecordatorioService {

    /**
     * Repositorio que proporciona acceso a los datos de recordatorios.
     */
    private final RecordatorioRepository repo;

    /**
     * Constructor que inyecta el repositorio de recordatorios.
     *
     * @param repo repositorio de recordatorios
     */
    @Autowired
    public RecordatorioService(RecordatorioRepository repo) {
        this.repo = repo;
    }

    /**
     * Recupera todos los recordatorios almacenados en la base de datos.
     *
     * @return lista de objetos {@link Recordatorio}
     */
    public List<Recordatorio> findAll() {
        return repo.findAll();
    }

    /**
     * Busca un recordatorio por su identificador único.
     *
     * @param id identificador del recordatorio
     * @return un {@link Optional} con el recordatorio encontrado, o vacío si no existe
     */
    public Optional<Recordatorio> findById(Long id) {
        return repo.findById(id);
    }

    /**
     * Elimina todos los recordatorios existentes en la base de datos.
     */
    public void removeAll() {
        repo.deleteAll();
    }

    /**
     * Recupera todos los recordatorios asociados a un empleado específico.
     *
     * @param empleadoId identificador del empleado
     * @return lista de recordatorios vinculados al empleado
     */
    public List<Recordatorio> findRecordatorioByEmpleado(Long empleadoId) {
        return repo.findByEmpleado_Id(empleadoId);
    }

    /**
     * Guarda un nuevo recordatorio o actualiza uno existente.
     *
     * @param a objeto {@link Recordatorio} a guardar
     * @return el recordatorio guardado
     */
    public Recordatorio save(Recordatorio a) {
        return repo.save(a);
    }

    /**
     * Elimina un recordatorio a partir de su identificador.
     *
     * @param id identificador del recordatorio a eliminar
     * @return {@code true} si el recordatorio existía y se eliminó; {@code false} en caso contrario
     */
    public boolean borrarPorId(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
