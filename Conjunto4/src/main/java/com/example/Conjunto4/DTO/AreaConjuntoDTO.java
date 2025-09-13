package com.example.Conjunto4.DTO;

import com.example.Conjunto4.Entity.Enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaConjuntoDTO {

    // Atributos de la entidad AreaConjunto DTO
    private Long id;
    private String nombreArea;
    private String descripcion;
    private Integer capacidad;
    private Enums.AreaTipo tipoArea;
    private Boolean reservable;
}
