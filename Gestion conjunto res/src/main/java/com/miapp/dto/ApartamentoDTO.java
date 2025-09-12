package com.miapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor; 
import java.util.List;
 
@Data
@NoArgsConstructor 
@AllArgsConstructor
public class ApartamentoDTO {
    private Long id;
    private String numero;
    private String torre;
    private int piso;
    private Long propietarioId;
    private List<Long> residentesIds;
    private List<Long> visitantesIds;
    private List<Long> parqueaderosIds;
    private List<Long> correspondenciasIds;
}
