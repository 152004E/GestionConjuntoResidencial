package com.miapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParqueaderoDTO {
    private Long id;
    private String numero;
    private String tipo;
    private Long apartamentoId;
}
