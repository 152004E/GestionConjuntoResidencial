package com.miapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResidenteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String documento;
    private String telefono;
    private String email;
    private Long apartamentoId;
}
