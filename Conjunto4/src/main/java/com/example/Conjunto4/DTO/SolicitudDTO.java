package com.example.Conjunto4.DTO;

import java.time.LocalDateTime;
import com.example.Conjunto4.Entity.Enums;

import lombok.Data;

@Data
public class SolicitudDTO {

    // Atributos de la entidad Solicitud DTO
    private Long id;
    private LocalDateTime fechaHoraCreacion;
    private String descripcion;
    private Enums.SolicitudTipo tipoSolicitud;
    private Enums.SolicitudEstado estadoSolicitud;

    // Relaciones 
    private Long usuarioId;
    private Long apartamentoId;
    private Long areaConjuntoId;
}
