package com.example.Conjunto4.DTO;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TorreDTO {
    private Long idTorre;
    private String nombre;
    private List<Long> apartamentosIds;
}
