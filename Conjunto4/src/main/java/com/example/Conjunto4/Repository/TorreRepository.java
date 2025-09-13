package com.example.Conjunto4.Repository;

import com.example.Conjunto4.Entity.Torre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorreRepository extends JpaRepository<Torre, Long> {
    // Listo para consultas personalizadas
}
