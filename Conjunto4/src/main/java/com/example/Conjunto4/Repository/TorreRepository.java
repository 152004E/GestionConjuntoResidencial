package com.example.Conjunto4.Repository;

import com.example.Conjunto4.Entity.Torre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Torre.
 */
@Repository
public interface TorreRepository extends JpaRepository<Torre, Long> {
    // Métodos personalizados si se requieren
}
