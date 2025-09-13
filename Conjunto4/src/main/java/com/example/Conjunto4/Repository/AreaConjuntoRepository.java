package com.example.Conjunto4.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Conjunto4.Entity.AreaConjunto;

@Repository
public interface AreaConjuntoRepository extends JpaRepository<AreaConjunto, Long> {

/*Metodos personalizados de area conjunto
 * Todas las consultas personalizadas que se requieran para el AreaConjunto
 * se definen en esta interfaz 
*/


//Buscar AreaConjunto por nombre exacto
    AreaConjunto findByNombreArea(String nombreArea);

//Buscar AreaConjunto por tipo (social u operativa)
    List<AreaConjunto> findByTipoArea(com.example.Conjunto4.Entity.Enums.AreaTipo tipoArea);

//Buscar AreaConjunto por si es reservable o no
    List<AreaConjunto> findByReservable(Boolean reservable);
    
}
