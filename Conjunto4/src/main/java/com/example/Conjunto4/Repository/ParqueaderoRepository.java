package com.example.Conjunto4.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import  com.example.Conjunto4.Entity.Parqueadero;
@Repository
public interface ParqueaderoRepository extends JpaRepository<Parqueadero, Long> {

}
