package com.example.Conjunto4.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para la entidad Apartamento.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApartamentoDTO {
    private Long id;
    private String numero;
    private Integer piso;
    private Long torreId;
}
