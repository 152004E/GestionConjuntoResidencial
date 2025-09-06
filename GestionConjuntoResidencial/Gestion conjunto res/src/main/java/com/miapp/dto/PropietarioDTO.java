package com.miapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropietarioDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String documento;
    private String telefono;
    private String email;
    private List<Long> apartamentosIds;
}
