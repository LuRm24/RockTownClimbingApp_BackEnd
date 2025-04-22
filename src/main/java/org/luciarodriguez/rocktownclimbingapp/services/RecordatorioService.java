package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Recordatorio;
import org.luciarodriguez.rocktownclimbingapp.repositories.RecordatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordatorioService {
    private final RecordatorioRepository repo;

    @Autowired
    public RecordatorioService(RecordatorioRepository repo) {
        this.repo = repo;
    }

    public List<Recordatorio> findAll() {
        return repo.findAll();
    }


    public List<Recordatorio> findRecordatorioByEmpleado(Long empleadoId) {
        //return repo.findByEmpleado_Id(empleadoId);

        List<Recordatorio> lista = repo.findByEmpleado_Id(empleadoId);
        return lista;

    }
    public Recordatorio save(Recordatorio a) {
        return repo.save(a);
    }
}
