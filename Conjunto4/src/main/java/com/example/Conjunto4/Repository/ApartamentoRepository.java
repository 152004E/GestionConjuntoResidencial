package com.example.Conjunto4.Repository;

import com.example.Conjunto4.Entity.Apartamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {
}
