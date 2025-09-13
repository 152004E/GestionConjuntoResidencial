package com.example.Conjunto4.Service;

import java.util.List;
import com.example.Conjunto4.DTO.SolicitudDTO;

public interface SolicitudService {

    // Métodos del servicio para la entidad Solicitud

    // Obtener todas las solicitudes
    List<SolicitudDTO> getAllSolicitudes();

    // Obtener una solicitud por su ID
    SolicitudDTO getSolicitudById(Long id);

    // Crear una nueva solicitud
    SolicitudDTO createSolicitud(SolicitudDTO solicitudDTO);

    // Actualizar una solicitud existente
    SolicitudDTO updateSolicitud(Long id, SolicitudDTO solicitudDTO);

    // Eliminar una solicitud por su ID
    void deleteSolicitud(Long id);
}
