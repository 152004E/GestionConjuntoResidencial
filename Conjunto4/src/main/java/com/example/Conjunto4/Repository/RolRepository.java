package com.example.Conjunto4.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Conjunto4.Entity.Rol;


@Repository

public interface RolRepository extends JpaRepository<Rol, Long> {

}
