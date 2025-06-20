package com.lozano.alquiler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lozano.alquiler.entity.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
