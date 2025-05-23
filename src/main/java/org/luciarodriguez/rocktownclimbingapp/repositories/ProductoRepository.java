package org.luciarodriguez.rocktownclimbingapp.repositories;

import org.luciarodriguez.rocktownclimbingapp.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
