package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Actividad;
import org.luciarodriguez.rocktownclimbingapp.repositories.ActividadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadService {
    private final ActividadRepository repo;
    public ActividadService(ActividadRepository repo) { this.repo = repo; }
    public List<Actividad> findAll() { return repo.findAll(); }
    public Actividad save(Actividad a) { return repo.save(a); }

    public Optional<Actividad> findById(Long id) {
        return repo.findById(id);
    }

    public boolean borrarPorId(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
