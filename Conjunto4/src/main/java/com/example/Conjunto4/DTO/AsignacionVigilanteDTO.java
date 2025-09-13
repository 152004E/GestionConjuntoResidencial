package com.example.Conjunto4.DTO;


import java.time.LocalDateTime;
import lombok.Data;

@Data
public class AsignacionVigilanteDTO {

    // Atributos de la entidad AsignacionVigilante DTO
    private Long id;
    private String turno;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaSalida;

    // Relaciones (IDs de las entidades relacionadas)
    private Long idVigilante;    
    private Long idArea;         
}
