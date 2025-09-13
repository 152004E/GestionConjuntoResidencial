package com.example.Conjunto4.Service;



import com.example.Conjunto4.DTO.AsignacionVigilanteDTO;
import java.util.List;

public interface AsignacionVigilanteService {
    
    // Métodos del servicio para AsignacionVigilante

    // Crear una nueva asignación
    AsignacionVigilanteDTO crearAsignacion(AsignacionVigilanteDTO dto);

    // Obtener una asignación por su ID
    AsignacionVigilanteDTO obtenerPorId(Long id);

    // Listar todas las asignaciones
    List<AsignacionVigilanteDTO> listarTodos();

    // Actualizar una asignación existente
    AsignacionVigilanteDTO actualizarAsignacion(Long id, AsignacionVigilanteDTO dto);

    // Eliminar una asignación por su ID
    void eliminarAsignacion(Long id);
}
