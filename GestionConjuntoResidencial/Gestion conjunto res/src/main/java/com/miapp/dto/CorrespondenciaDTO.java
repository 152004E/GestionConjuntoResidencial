package com.miapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CorrespondenciaDTO {
    private Long id;
    private String descripcion;
    private String fechaRecepcion;
    private String entregadoA;
    private Long apartamentoId;
}
