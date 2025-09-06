package com.miapp.repository;

import com.miapp.entity.Residente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidenteRepository extends JpaRepository<Residente, Long> {
}
