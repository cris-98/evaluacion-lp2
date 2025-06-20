package com.lozano.alquiler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lozano.alquiler.entity.Alquiler;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {
}
