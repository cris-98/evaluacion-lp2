package com.lozano.alquiler.repository;

import com.lozano.alquiler.entity.DetalleAlquiler;
import com.lozano.alquiler.entity.DetalleAlquilerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleAlquilerRepository extends JpaRepository<DetalleAlquiler, DetalleAlquilerId> {
}
