package com.miapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitanteDTO {
    private Long id;
    private String nombre;
    private String documento;
    private String motivoVisita;
    private String fechaVisita;
    private Long apartamentoId;
}
