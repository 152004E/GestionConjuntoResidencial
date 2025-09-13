package com.example.Conjunto4.Service;

import com.example.Conjunto4.DTO.AreaConjuntoDTO;
import java.util.List;

public interface AreaConjuntoService {

    // Métodos del servicio para la entidad AreaConjunto

    // Crear un nuevo área
    AreaConjuntoDTO crearArea(AreaConjuntoDTO dto);

    // Obtener un área por su ID
    AreaConjuntoDTO obtenerAreaPorId(Long id);

    // Listar todas las áreas
    List<AreaConjuntoDTO> listarAreas();

    // Actualizar un área existente
    AreaConjuntoDTO actualizarArea(Long id, AreaConjuntoDTO dto);

    // Eliminar un área por su ID
    void eliminarArea(Long id);
}
