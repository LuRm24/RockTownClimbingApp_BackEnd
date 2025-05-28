package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Actividad;
import org.luciarodriguez.rocktownclimbingapp.models.HorarioDisponible;
import org.luciarodriguez.rocktownclimbingapp.repositories.HorarioDisponibleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioDisponibleService {
    private final HorarioDisponibleRepository repo;
    public HorarioDisponibleService(HorarioDisponibleRepository repo) { this.repo = repo; }
    public List<HorarioDisponible> findAll() { return repo.findAll(); }
    public HorarioDisponible save(HorarioDisponible h) {

        return repo.save(h); }
    public Optional<HorarioDisponible> findById(Long id) {
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
