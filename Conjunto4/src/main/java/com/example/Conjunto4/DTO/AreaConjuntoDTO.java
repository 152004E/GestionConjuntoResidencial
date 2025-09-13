package com.example.Conjunto4.DTO;

import com.example.Conjunto4.Entity.Enums;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaConjuntoDTO {

    // Atributos de la entidad AreaConjunto DTO
    private Long id;

    @NotBlank(message = "El nombre del area no puede estar vacio")
    @Size(max = 100, message = "El nombre del area no puede tener mas de 100 caracteres")
    private String nombreArea;
    private String descripcion;
    private Integer capacidad;
    private Enums.AreaTipo tipoArea;
    private Boolean reservable;
}
