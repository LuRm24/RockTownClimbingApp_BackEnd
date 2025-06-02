package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Cliente;
import org.luciarodriguez.rocktownclimbingapp.repositories.ClienteRepository;
import org.luciarodriguez.rocktownclimbingapp.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para la gestión de clientes en la aplicación RockTown Climbing.
 * <p>
 * Proporciona endpoints para operaciones CRUD completas sobre la entidad {@link Cliente}, como:
 * - Obtener todos los clientes
 * - Insertar un nuevo cliente
 * - Buscar por ID, DNI, apellidos o teléfono
 * - Actualizar y eliminar clientes
 * <p>
 * Este controlador delega la lógica de negocio en {@link ClienteService} y utiliza {@link ClienteRepository}
 * para algunas operaciones directas con la base de datos.
 *
 * @author Lucía Rodríguez Martín
 * @version 1.0
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private final ClienteService service;
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    /**
     * Obtiene una lista con todos los clientes registrados.
     *
     * @return Lista de objetos {@link Cliente}
     */
    @GetMapping("/select-all")
    public List<Cliente> getAll() {
        return service.findAll();
    }

    /**
     * Inserta un nuevo cliente en la base de datos.
     *
     * @param cliente Objeto {@link Cliente} recibido en el cuerpo de la petición
     * @return Cliente guardado
     */
    @PostMapping
    public Cliente save(@RequestBody Cliente cliente) {
        return service.save(cliente);
    }

    /**
     * Inserta un nuevo cliente utilizando directamente el repositorio.
     *
     * @param cliente Objeto {@link Cliente} recibido en la petición
     * @return Cliente guardado con respuesta HTTP 200 OK
     */
    @PostMapping("/insert")
    public ResponseEntity<Cliente> insertarCliente(@RequestBody Cliente cliente) {
        Cliente guardado = clienteRepository.save(cliente);
        return ResponseEntity.ok(guardado);
    }

    /**
     * Elimina un cliente por su ID si existe.
     *
     * @param id Identificador del cliente
     * @return {@code 200 OK} si se eliminó, o {@code 404 Not Found} si no existe
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarCliente(@PathVariable Long id) {
        Optional<Cliente> cliente = service.findById(id);
        if (cliente.isPresent()) {
            service.borrarPorId(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Busca un cliente por su ID.
     *
     * @param id Identificador del cliente
     * @return Cliente encontrado o {@code 404 Not Found}
     */
    @GetMapping("/find")
    public ResponseEntity<Cliente> findById(@RequestParam Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Busca clientes que coincidan con el DNI, apellidos o teléfono proporcionados.
     * <p>
     * Todos los parámetros son opcionales; si se proporcionan varios, se aplican como condiciones combinadas.
     *
     * @param dni       DNI del cliente (opcional)
     * @param apellidos Apellidos del cliente (opcional)
     * @param telefono  Teléfono del cliente (opcional)
     * @return Lista de clientes coincidentes
     */
    @GetMapping("/find-client")
    public List<Cliente> findByDniOrApellidosOrTelefono(
            @RequestParam(required = false) String dni,
            @RequestParam(required = false) String apellidos,
            @RequestParam(required = false) String telefono) {

        return service.findMultiple(dni, apellidos, telefono);
    }

    /**
     * Actualiza un cliente existente con los nuevos datos proporcionados.
     *
     * @param clienteActualizado Cliente con los datos actualizados
     * @return Cliente actualizado con {@code 200 OK}
     */
    @PutMapping("/update")
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente clienteActualizado) {
        Cliente actualizado = service.updateCliente(clienteActualizado);
        return ResponseEntity.ok(actualizado);
    }
}
