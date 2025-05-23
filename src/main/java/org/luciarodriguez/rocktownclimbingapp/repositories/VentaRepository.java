package org.luciarodriguez.rocktownclimbingapp.repositories;

import org.luciarodriguez.rocktownclimbingapp.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
}
