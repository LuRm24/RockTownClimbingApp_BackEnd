package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Cliente;
import org.luciarodriguez.rocktownclimbingapp.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado de gestionar operaciones relacionadas con los clientes
 * del sistema RockTown Climbing.
 * <p>
 * Incluye funcionalidades para buscar, guardar, actualizar y eliminar clientes,
 * así como realizar búsquedas filtradas por DNI, apellidos o teléfono.
 * <p>
 * Este servicio centraliza la lógica de negocio vinculada a los clientes y
 * actúa como puente entre los controladores y el repositorio de datos.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@Service
public class ClienteService {

    /**
     * Repositorio principal de clientes.
     */
    private final ClienteRepository repo;

    /**
     * Repositorio auxiliar para operaciones específicas de actualización.
     */
    private final ClienteRepository clienteRepository;

    /**
     * Constructor que inyecta las dependencias necesarias.
     *
     * @param repo              repositorio principal
     * @param clienteRepository repositorio para operaciones específicas
     */
    public ClienteService(ClienteRepository repo, ClienteRepository clienteRepository) {
        this.repo = repo;
        this.clienteRepository = clienteRepository;
    }

    /**
     * Devuelve todos los clientes registrados.
     *
     * @return lista completa de clientes
     */
    public List<Cliente> findAll() {
        return repo.findAll();
    }

    /**
     * Busca un cliente por su ID.
     *
     * @param id identificador del cliente
     * @return un {@link Optional} que puede contener el cliente o estar vacío
     */
    public Optional<Cliente> findById(Long id) {
        return repo.findById(id);
    }

    /**
     * Guarda un nuevo cliente o actualiza uno existente.
     *
     * @param c cliente a guardar
     * @return el cliente guardado
     */
    public Cliente save(Cliente c) {
        return repo.save(c);
    }

    /**
     * Elimina un cliente si existe por su ID.
     *
     * @param id identificador del cliente
     * @return {@code true} si fue eliminado, {@code false} si no existía
     */
    public boolean borrarPorId(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Actualiza los datos de un cliente existente.
     *
     * @param cliente cliente con los nuevos datos
     * @return cliente actualizado
     * @throws RuntimeException si no se encuentra el cliente
     */
    public Cliente updateCliente(Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findById(cliente.getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setApellidos(cliente.getApellidos());
        clienteExistente.setDni(cliente.getDni());
        clienteExistente.setTelefono(cliente.getTelefono());
        clienteExistente.setFechaBono(cliente.getFechaBono());
        clienteExistente.setEdad(cliente.getEdad());
        clienteExistente.setPieGato(cliente.isPieGato());
        clienteExistente.setTipo_entrada(cliente.getTipo_entrada());

        return clienteRepository.save(clienteExistente);
    }

    /**
     * Busca clientes que coincidan parcialmente con el DNI, apellidos o teléfono.
     *
     * @param dni       parte del DNI
     * @param apellidos parte de los apellidos
     * @param telefono  parte del número de teléfono
     * @return lista de clientes que cumplen alguno de los criterios
     */
    public List<Cliente> findMultiple(String dni, String apellidos, String telefono) {
        return repo.findByDniContainingIgnoreCaseOrApellidosContainingIgnoreCaseOrTelefonoContainingIgnoreCase(
                dni, apellidos, telefono
        );
    }
}
