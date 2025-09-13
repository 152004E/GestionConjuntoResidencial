package com.example.Conjunto4.Service;

import com.example.Conjunto4.DTO.AreaConjuntoDTO;
import java.util.List;

public interface AreaConjuntoService {

    /* Métodos del servicio para la entidad AreaConjunto 
     * CRUD: Crear, Leer, Actualizar, Eliminar
     * Cada método debe ser implementado en la clase AreaConjuntoServiceImpl
     * que implementa esta interfaz.
    */

    // Crear un nuevo AreaConjunto 
    AreaConjuntoDTO crearArea(AreaConjuntoDTO areaDTO);

    // Obtener un AreaConjunto por su ID
    AreaConjuntoDTO obtenerAreaPorId(Long id);

    // Listar todas las AreaConjunto 
    List<AreaConjuntoDTO> listarAreas();

    // Actualizar un AreaConjunto existente
    AreaConjuntoDTO actualizarArea(Long id, AreaConjuntoDTO areaDTO);

    // Eliminar un AreaConjunto por su ID
    void eliminarArea(Long id);
}
