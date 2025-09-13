package com.example.Conjunto4.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


// DTO para la transferencia de datos de Apartamento

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApartamentoDTO {

    private Long idApartamento;
    private String numero;
    private int piso;
    private Long idTorre;
    private Long idPropietario;
    private List<Long> residentesIds;
    private List<Long> visitantesIds;
    private List<Long> parqueaderosIds;
    private List<Long> correspondenciasIds;
}
