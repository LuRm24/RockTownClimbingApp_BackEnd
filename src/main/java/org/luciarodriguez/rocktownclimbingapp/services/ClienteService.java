package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Cliente;
import org.luciarodriguez.rocktownclimbingapp.models.Empleado;
import org.luciarodriguez.rocktownclimbingapp.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository repo;
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository repo, ClienteRepository clienteRepository) {
        this.repo = repo;
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> findAll() {
        return repo.findAll(); }

    public Optional<Cliente> findById(Long id) {
        return repo.findById(id); }

    public Cliente save(Cliente c) {
        return repo.save(c); }

    public boolean borrarPorId(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
    public Cliente updateCliente(Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findById(cliente.getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Actualizamos campos editables
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setApellidos(cliente.getApellidos());
        clienteExistente.setDni(cliente.getDni());
        clienteExistente.setTelefono(cliente.getTelefono());
        clienteExistente.setFechaBono(cliente.getFechaBono());
        clienteExistente.setMenorEdad(cliente.isMenorEdad());
        clienteExistente.setPieGato(cliente.isPieGato());
        clienteExistente.setSesionesGastadas(cliente.getSesionesGastadas());
        clienteExistente.setTipo_entrada(cliente.getTipo_entrada());

        return clienteRepository.save(clienteExistente);
    }
    public List<Cliente> findMultiple(String dni, String apellidos, String telefono) {
        return repo.findByDniContainingIgnoreCaseOrApellidosContainingIgnoreCaseOrTelefonoContainingIgnoreCase(
                dni, apellidos, telefono
        );
    }


}
