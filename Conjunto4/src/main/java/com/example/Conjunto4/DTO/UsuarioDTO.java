package com.example.Conjunto4.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long idUsuario;

    private String nombre;
    private String apellido;
    private String documento;
    private String telefono;
    private String email;
    private String contrasena;
    private Boolean estado;

}
